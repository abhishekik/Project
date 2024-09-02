package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.common.BaseDAOInt;
import com.rays.common.BaseDTO;
import com.rays.common.UserContext;
import com.rays.dto.CollegeDTO;
import com.rays.dto.PrescriptionDTO;

@Repository
public class PrescriptionDAOImpl extends BaseDAOImpl<PrescriptionDTO> implements PrescriptionDAOInt {

	@Override
	protected List<Predicate> getWhereClause(PrescriptionDTO dto, CriteriaBuilder builder, Root<PrescriptionDTO> qRoot) {
		// Create where conditions
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getName())) {

			whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
		}

		if (!isEmptyString(dto.getDecease())) {

			whereCondition.add(builder.like(qRoot.get("decease"), dto.getDecease() + "%"));
			System.out.println(dto.getDecease());
		}

		if (!isNotNull(dto.getDate())) {

			whereCondition.add(builder.equal(qRoot.get("date"), dto.getDate()));
		}
		
		if (!isNotNull(dto.getCapacity())) {

			whereCondition.add(builder.equal(qRoot.get("capacity"), dto.getCapacity()));
		}
		
		
		if (!isZeroNumber(dto.getId()) && dto.getId() != null) {

			whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
		}
		return whereCondition;
	}

	@Override
	public Class<PrescriptionDTO> getDTOClass() {
		return PrescriptionDTO.class;
	}
}

