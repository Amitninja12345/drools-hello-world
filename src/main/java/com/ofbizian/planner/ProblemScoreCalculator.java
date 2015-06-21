package com.ofbizian.planner;

import java.util.HashSet;
import java.util.Set;

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator;

public class ProblemScoreCalculator implements EasyScoreCalculator<ProblemDefinition> {

	@Override
	public HardSoftScore calculateScore(ProblemDefinition problemDefinition) {
        Set<Employee> employees = problemDefinition.getEmployees();
        Set<Task> tasks = problemDefinition.getTasks();
        Set<Task> assignedTasks = new HashSet<Task>();

        int hardScore = 0;
        int softScore = 0;

        for (Employee employee : employees) {
            if (employee.getTask() == null) {
                softScore++; //unassigned
            } else {
                assignedTasks.add(employee.getTask());
                if ((!employee.getId().contains(employee.getTask().getId()))) {
                    hardScore++; //skill mismatch
                }
            }
        }

        int unassignedTasks = tasks.size() - assignedTasks.size();
        hardScore += 2  * unassignedTasks;

        HardSoftScore hardSoftScore = HardSoftScore.valueOf(-hardScore, -softScore);
        return hardSoftScore;
	}
}
