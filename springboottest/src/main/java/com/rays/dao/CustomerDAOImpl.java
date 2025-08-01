package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.CustomerDTO;

@Repository
public class CustomerDAOImpl extends BaseDAOImpl<CustomerDTO> implements CustomerDAOInt {

	@Override
	protected List<Predicate> getWhereClause(CustomerDTO dto, CriteriaBuilder builder, Root<CustomerDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<>();

		if (dto.getId() != null && dto.getId() > 0) {
			whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
		}

		if (dto.getName() != null && !dto.getName().isEmpty()) {
			whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
		}

		if (dto.getDescription() != null && !dto.getDescription().isEmpty()) {
			whereCondition.add(builder.like(qRoot.get("description"), dto.getDescription() + "%"));
		}

		if (dto.getAddedDate() != null) {
			whereCondition.add(builder.equal(qRoot.get("addedDate"), dto.getAddedDate()));
		}

		if (dto.getPurchaseAmount() != null) {
			whereCondition.add(builder.equal(qRoot.get("purchaseAmount"), dto.getPurchaseAmount()));
		}

		return whereCondition;
	}

	@Override
	public Class<CustomerDTO> getDTOClass() {
		return CustomerDTO.class;
	}
}