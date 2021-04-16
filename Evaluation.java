
public class Evaluation {
	private int EID;
	private int Obtainedmarks;
	private int TotalMarks;
	
	public Evaluation()
	{
		
	}
	
	public Evaluation(int eid,int OM,int TM)
	{
		this.EID = eid;
		this.Obtainedmarks = OM;
		this.TotalMarks = TM;
	}
	
	public int getEID() {
		return EID;
	}
	public void setEID(int eID) {
		EID = eID;
	}
	public int getObtainedmarks() {
		return Obtainedmarks;
	}
	public void setObtainedmarks(int obtainedmarks) {
		Obtainedmarks = obtainedmarks;
	}
	public int getTotalMarks() {
		return TotalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		TotalMarks = totalMarks;
	}
	
	public void Print() {
		System.out.println("Evaluation Id = " + EID + "\n"
				+ 		   "Total Marks = " + TotalMarks + "\n"
				+		   "Obtained Marks = " + Obtainedmarks + "\n");
	}
	
}
