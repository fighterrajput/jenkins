package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.StoreDAOImpl;
import com.rays.dto.StoreDTO;

@Service
@Transactional
public class StoreServiceImpl extends BaseServiceImpl<StoreDTO, StoreDAOImpl> implements StoreServiceInt {

}