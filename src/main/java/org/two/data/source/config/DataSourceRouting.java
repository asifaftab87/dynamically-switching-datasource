package org.two.data.source.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.two.data.source.constant.BranchEnum;

public class DataSourceRouting extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		return BranchContextHolder.getBranchContext();
	}

	public void initDatasource(DataSource modifyDataSource, DataSource readDataSource) {
		Map<Object, Object> dataSourceMap = new HashMap<>();
		dataSourceMap.put(BranchEnum.READ_ONLY, readDataSource);
		dataSourceMap.put(BranchEnum.WRITE_ONLY, modifyDataSource);
		this.setTargetDataSources(dataSourceMap);
		this.setDefaultTargetDataSource(readDataSource);
	}
	
}
