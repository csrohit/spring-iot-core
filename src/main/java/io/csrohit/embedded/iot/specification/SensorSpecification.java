package io.csrohit.embedded.iot.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import io.csrohit.embedded.iot.model.Sensor;

public class SensorSpecification implements Specification<Sensor> {
	
	private SearchCriteria criteria;

	public SensorSpecification(SearchCriteria searchCriteria) {
		criteria = searchCriteria;
	}

	@Override
	public Predicate toPredicate(Root<Sensor> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		
		if(criteria.getOperation().equalsIgnoreCase(">")) {
			return builder.greaterThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue().toString());
		}
		else if (criteria.getOperation().equalsIgnoreCase("==")) {
			return builder.equal(root.get(criteria.getKey()), criteria.getValue().toString());
		}
		
		
		return null;
	}

}
