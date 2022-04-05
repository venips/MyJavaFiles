package entity;

import java.time.LocalDate;

public class Project 
{
	private int projectId;
	private String projectTitle;
	private LocalDate projectDeadLine;

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public LocalDate getProjectDeadLine() {
		return projectDeadLine;
	}

	public void setProjectDeadLine(LocalDate projectDeadLine) {
		this.projectDeadLine = projectDeadLine;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectTitle=" + projectTitle + ", projectDeadLine="
				+ projectDeadLine + "]";
}

 

}
