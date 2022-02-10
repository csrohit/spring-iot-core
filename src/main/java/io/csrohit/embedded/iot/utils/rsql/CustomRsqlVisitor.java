package io.csrohit.embedded.iot.utils.rsql;

import cz.jirutka.rsql.parser.ast.AndNode;
import cz.jirutka.rsql.parser.ast.ComparisonNode;
import cz.jirutka.rsql.parser.ast.OrNode;
import cz.jirutka.rsql.parser.ast.RSQLVisitor;
import org.springframework.data.jpa.domain.Specification;

public class CustomRsqlVisitor<T> implements RSQLVisitor<Specification<T>, Void> {

    private GenericSpecBuilder<T> builder;

    public CustomRsqlVisitor() {
        this.builder = new GenericSpecBuilder<>();
    }

    @Override
    public Specification<T> visit(AndNode andNode, Void unused) {
        return builder.createSpecification(andNode);
    }

    @Override
    public Specification<T> visit(OrNode orNode, Void unused) {
        return builder.createSpecification(orNode);
    }

    @Override
    public Specification<T> visit(ComparisonNode comparisonNode, Void unused) {
        return builder.createSpecification(comparisonNode);
    }
}
