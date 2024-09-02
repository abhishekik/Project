package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseDAOInt;
import com.rays.common.BaseServiceImpl;
import com.rays.dao.PrescriptionDAOInt;
import com.rays.dto.PrescriptionDTO;


@Service
@Transactional
public class PrescriptionServiceImpl extends BaseServiceImpl<PrescriptionDTO, PrescriptionDAOInt> implements PrescriptionServiceInt {

}
