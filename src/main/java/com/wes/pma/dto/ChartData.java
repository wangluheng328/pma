package com.wes.pma.dto;

public interface ChartData {
	
	// the name after get should exactly match the column name in the table
	public String getLabel();
	public long getCount();
		
}
