
public class Student {
	
	private int RollNumber;
	private String Name;
	private String Session;
	
	public Student() {
		
	}
	
	public Student(int rn,String N,String s) {
		this.RollNumber = rn;
		this.Name = N;
		this.Session = s;
		
	}
	
	public int getRollNumber() {
		return RollNumber;
	}
	public void setRollNumber(int rollNumber) {
		RollNumber = rollNumber;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSession() {
		return Session;
	}
	public void setSession(String session) {
		Session = session;
	}
	
	public void Print() {
		System.out.println("Roll Number = " + RollNumber +"\n" +
						   "Name = " + Name + "\n" +
						   "Session = "+ Session + "\n");
		
	}
	

}
