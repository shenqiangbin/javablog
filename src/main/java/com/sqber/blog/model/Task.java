package com.sqber.blog.model;

import java.util.Date;

public class Task extends BaseModel{
	
	private String title;
	private int taskType;
	private int taskStatus;
	private int projectId;
	private int moduleId;
	private String demandor;
	private String assignTo;
	private String solver;
	private String content;
	private Date putTime;
	private Date scheduledStart;
	private Date scheduledEnd;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getTaskType() {
		return taskType;
	}
	public void setTaskType(int taskType) {
		this.taskType = taskType;
	}
	public int getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(int taskStatus) {
		this.taskStatus = taskStatus;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public int getModuleId() {
		return moduleId;
	}
	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}
	public String getDemandor() {
		return demandor;
	}
	public void setDemandor(String demandor) {
		this.demandor = demandor;
	}
	public String getAssignTo() {
		return assignTo;
	}
	public void setAssignTo(String assignTo) {
		this.assignTo = assignTo;
	}
	public String getSolver() {
		return solver;
	}
	public void setSolver(String solver) {
		this.solver = solver;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPutTime() {
		return putTime;
	}
	public void setPutTime(Date putTime) {
		this.putTime = putTime;
	}
	public Date getScheduledStart() {
		return scheduledStart;
	}
	public void setScheduledStart(Date scheduledStart) {
		this.scheduledStart = scheduledStart;
	}
	public Date getScheduledEnd() {
		return scheduledEnd;
	}
	public void setScheduledEnd(Date scheduledEnd) {
		this.scheduledEnd = scheduledEnd;
	}
	
}
