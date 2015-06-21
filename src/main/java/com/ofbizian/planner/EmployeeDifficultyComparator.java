package com.ofbizian.planner;

import java.util.Comparator;

import org.apache.commons.lang.builder.CompareToBuilder;

public class EmployeeDifficultyComparator implements Comparator<Employee> {
	@Override
	public int compare(final Employee a, final Employee b) {
		return new CompareToBuilder()
				.append(a.getId().length(), b.getId().length())
				.append(a.getId(), b.getId()).toComparison();
	}
}
