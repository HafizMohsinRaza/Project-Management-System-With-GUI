
public class Project {
	private int ProjectId;
	private String ProjectTitle;
	private String ProjectType;
	
	public Project() 
	{
		
	}
	
	public Project(int pid,String ptitle,String ptype)
	{
		this.setProjectId(pid);
		this.setProjectTitle(ptitle);
		this.setProjectType(ptype);
	}

	public int getProjectId() {
		return ProjectId;
	}

	public void setProjectId(int projectId) {
		ProjectId = projectId;
	}

	public String getProjectTitle() {
		return ProjectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		ProjectTitle = projectTitle;
	}

	public String getProjectType() {
		return ProjectType;
	}

	public void setProjectType(String projectType) {
		ProjectType = projectType;
	}
	
	public void Print() {
		System.out.println("\nProect ID = " + this.ProjectId +
						   "\nProject Title = " +this.ProjectTitle +
						   "\nProject Type = " + this.ProjectType);
		
	}

}
