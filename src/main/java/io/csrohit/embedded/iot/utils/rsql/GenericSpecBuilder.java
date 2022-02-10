package io.csrohit.embedded.iot.utils.rsql;

import cz.jirutka.rsql.parser.ast.ComparisonNode;
import cz.jirutka.rsql.parser.ast.LogicalNode;
import cz.jirutka.rsql.parser.ast.LogicalOperator;
import cz.jirutka.rsql.parser.ast.Node;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GenericSpecBuilder <T>{
    public Specification<T> createSpecification(Node node){
        if(node instanceof LogicalNode){
            return createSpecification((LogicalNode) node);
        }
        if (node instanceof ComparisonNode){
            return createSpecification((ComparisonNode) node);
        }
        return null;
    }

    public Specification<T> createSpecification(LogicalNode node){
        List<Specification> specs = node.getChildren().stream().map(n -> createSpecification(n)).filter(Objects::nonNull).collect(Collectors.toList());
        Specification<T> result = specs.get(0);

        if(node.getOperator() == LogicalOperator.AND){
            for (int i=1; i<specs.size(); i++){
                result =  Specification.where(result).and(specs.get(i));
            }
        }else if (node.getOperator() == LogicalOperator.OR){
            for (int i=1; i<specs.size(); i++){
                result =  Specification.where(result).or(specs.get(i));
            }
        }
        return result;
    }
    public Specification<T> createSpecification(ComparisonNode node){
        Specification<T> result = Specification.where(
            new GenericRsqlSpecification<T>(
                    node.getSelector(),
                    node.getOperator(),
                    node.getArguments()
            )
        );
        return result;
    }
}
