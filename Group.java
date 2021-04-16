import java.util.ArrayList;

public class Group {
	private int gid;
	private Student S1;
	private Student S2;
	private Student S3;
	private Project P1;
	private AdvisoryBoard A1;
	private ArrayList<Evaluation> Ev = new ArrayList<Evaluation>();
	
	public Group() {
		
	}
	
	public Group(int g1,Student s1,Student s2,Student s3,Project p1,AdvisoryBoard a1) {
		this.gid = g1;
		this.S1 = s1;
		this.S2 = s2;
		this.S3 = s3;
		this.P1 = p1;
		this.A1 = a1;
	}
	
	public Student getS1() {
		return S1;
	}
	public void setS1(Student s1) {
		S1 = s1;
	}
	public Student getS2() {
		return S2;
	}
	public void setS2(Student s2) {
		S2 = s2;
	}
	public Student getS3() {
		return S3;
	}
	public void setS3(Student s3) {
		S3 = s3;
	}
	public Project getP1() {
		return P1;
	}
	public void setP1(Project p1) {
		P1 = p1;
	}
	public AdvisoryBoard getA1() {
		return A1;
	}
	public void setA1(AdvisoryBoard a1) {
		A1 = a1;
	}
	
	public void Print() {
		System.out.println("Group Id  = ");
		System.out.println(gid + "\n");
		System.out.println("Student 1 = ");
		S1.Print();
		System.out.println("Student 2 = ");
		S2.Print();
		System.out.println("Student 3 = ");
		S3.Print();
		System.out.println("Advisory Board = ");
		A1.Print();
		System.out.println("Project = ");
		P1.Print();
	}

	public ArrayList<Evaluation> getEv() {
		return Ev;
	}

	public void setEv(ArrayList<Evaluation> ev) {
		Ev = ev;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}
	
	public void AddEvaluation(Evaluation a)
	{
		Ev.add(a);
	}
	
	public void RemoveEvaluation(int eid)
	{
		for(Evaluation a : Ev)
		{
			if(a.getEID() == eid)
			{
				Ev.remove(a);
				System.out.println("Evaluation of " + eid + "has been removed");
				break;
			}
		}
	}
	
	public void DisplayEvaluations() {
		for(Evaluation e: Ev)
		{
			e.Print();
		}
	}

}
