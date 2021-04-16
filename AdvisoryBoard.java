
public class AdvisoryBoard {
	
	private String Advisor;
	private String CoAdvisor;
	private String IndustrialAdvisor;
	
	public AdvisoryBoard() {
		
	}
	
	public AdvisoryBoard(String a,String CA,String IA) {
		this.Advisor = a;
		this.CoAdvisor = CA;
		this.IndustrialAdvisor = IA;
	}
	
	public String getAdvisor() {
		return Advisor;
	}
	public void setAdvisor(String advisor) {
		Advisor = advisor;
	}
	public String getCoAdvisor() {
		return CoAdvisor;
	}
	public void setCoAdvisor(String coAdvisor) {
		CoAdvisor = coAdvisor;
	}
	public String getIndustrialAdvisor() {
		return IndustrialAdvisor;
	}
	public void setIndustrialAdvisor(String industrialAdvisor) {
		IndustrialAdvisor = industrialAdvisor;
	}
	
	public void Print() {
		System.out.println("Advisor = " + this.Advisor + "\n" +
						   "Co Advisor = " + this.CoAdvisor + "\n"	+
							"Industrial Advisor = " +this.IndustrialAdvisor	+ "\n");
	}
}
