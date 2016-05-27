package com.test.poc.compositepu.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.test.poc.compositepu.dao.DBVersionDao;
import com.test.poc.compositepu.dao.TableOneDao;
import com.test.poc.compositepu.entity.TableOne;

@Component
@Transactional
public class TableOneServiceImpl implements TableOneService {

	private static final Logger LOG = LoggerFactory.getLogger(TableOneServiceImpl.class);

	@Autowired
	private TableOneDao tableOneDao;

	@Autowired
	private DBVersionDao dbVersionDao;
	
	@Autowired
	private DBVersions dbVersions;
	
	@Override
	public List<TableOne> getTableOneList(Integer start, Integer range) {
		LOG.info("-> getTableOneList start={}, range={}", start, range);
		List<TableOne> result;
		result = tableOneDao.getTableOneList(start, range);
		
//		String v = dbVersionDao.getDBVersion();
//		LOG.info("DBVersion: {}", v);

//		Map<String, String> versions = dbVersions.getDBVersions();
//		for(Map.Entry<String, String> entry : versions.entrySet()) {
//			LOG.info("{} {})", entry.getKey(), entry.getValue());			
//		}
		
		LOG.info("<- getTableOneList returning {} objects", result.size());
		return result;
	}
}
