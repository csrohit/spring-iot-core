package io.csrohit.embedded.iot.specification;

import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SpecificationBuilder<T> {
    private List<SearchCriteria> criteriaList;

    public SpecificationBuilder() {
        this.criteriaList = new ArrayList<>();
    }

    public SpecificationBuilder with(String key, String operator, String value){
        return with(new SearchCriteria(key, operator, value));
    }

    private SpecificationBuilder with(SearchCriteria searchCriteria) {
        criteriaList.add(searchCriteria);
        return this;
    }

    private Specification<T> build(){
        List<Specification> specs = criteriaList
                                        .stream()
                .map(SensorSpecification::new)
                .collect(Collectors.toList());
        Specification<T> result = specs.get(0);
        for(int i=1; i<criteriaList.size(); i++){
            result = Specification.where(result)
                    .and(specs.get(i));
        }
        return result;
    }
}
