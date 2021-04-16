import java.awt.FlowLayout;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.*;  
import java.awt.event.*; 

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ProjectManagement implements ActionListener{
	
	static ArrayList<Project> projectList = new ArrayList<Project>(); 
	static ArrayList<Group> groupList = new ArrayList<Group>();
	static ArrayList<AdvisoryBoard> advisoryList = new ArrayList<AdvisoryBoard>(); 
	static ArrayList<Student> students = new ArrayList<Student>();
	
	public static void AddProjectFromFile() {
		int pid;
		String ProjectTitle;
		String ProjectType;
		
		String LinesReader;
		String [] BrokenStrings;
		try {
		      File myObj = new File("..\\ProjectManagement\\Projects.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		    	  
		        LinesReader = myReader.nextLine();
		        System.out.println(LinesReader);
		        BrokenStrings = LinesReader.split(",");
		        pid = Integer.parseInt(BrokenStrings[0]);
		        ProjectTitle = BrokenStrings[1];
		        ProjectType = BrokenStrings[2];
		        
		        Project project = new Project(pid,ProjectTitle,ProjectType);
		        
		        projectList.add(project);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	public static void AddStudentsFromFile() {
		int rn;
		String Name;
		String Session;
		
		String LinesReader;
		String [] BrokenStrings;
		try {
		      File myObj = new File("..\\ProjectManagement\\Students.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		    	  
		        LinesReader = myReader.nextLine();
		        System.out.println(LinesReader);
		        BrokenStrings = LinesReader.split(",");
		        rn = Integer.parseInt(BrokenStrings[0]);
		        Name = BrokenStrings[1];
		        Session = BrokenStrings[2];
		        Student sn = new Student(rn,Name,Session);
		        students.add(sn);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	
	
	public static void AddAdvisorsFromFile() {
		String Advisor;
		String CoAdvisor;
		String IndustrialAdvisor;
		
		String LinesReader;
		String [] BrokenStrings;
		try {
		      File myObj = new File("..\\ProjectManagement\\Advisors.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		    	  
		        LinesReader = myReader.nextLine();
		        System.out.println(LinesReader);
		        BrokenStrings = LinesReader.split(",");
		        Advisor = BrokenStrings[0];
		        CoAdvisor = BrokenStrings[1];
		        IndustrialAdvisor = BrokenStrings[2];
		        
		        AdvisoryBoard advisory = new AdvisoryBoard(Advisor,CoAdvisor,IndustrialAdvisor);
		        
		        advisoryList.add(advisory);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	public static void DisplayStudents() {
		for(Student c :students) {
			c.Print();
		}
	}
	
	public static void DisplayProjects() {
		for(Project c :projectList) {
			c.Print();
		}
	}
	
	public static void DisplayAdvisors() {
		for(AdvisoryBoard c :advisoryList) {
			c.Print();
		}
	}
	
	public static void DisplayGroups() {
		for(Group c :groupList) {
			c.Print();
		}
	}
	static Scanner Inputer = new Scanner(System.in);
	
	public static void AddGroupInGroupList() {
		Student s1=null,s2 = null,s3=null;
		int rn = 0;
		int gd=0;
		System.out.println("Enter group ID =  ");
		gd = Inputer.nextInt();
		
		System.out.println("Enter Student roll number S1 = ");
		rn = Inputer.nextInt();
		for(Student c:students)
		{
			if(c.getRollNumber() == rn)
			{
				s1 = c;
				students.remove(c);
				break;
			}
		}
		System.out.println("Enter Student roll number S2 = ");
		rn = Inputer.nextInt();
		for(Student c:students)
		{
			if(c.getRollNumber() == rn)
			{
				s2 = c;
				students.remove(c);
				break;
			}			
		}
		System.out.println("Enter Student roll number S3 = ");
		rn = Inputer.nextInt();
		
		for(Student c:students)
		{
			if(c.getRollNumber() == rn)
			{
				s3 = c;
				students.remove(c);
				break;
			}
		}
		String a1;
		System.out.println("Enter Advisor Name = ");
		a1 = Inputer.next();
		AdvisoryBoard A1 = null;
		for(AdvisoryBoard c:advisoryList)
		{
			if(c.getAdvisor().equalsIgnoreCase(a1))
			{
				A1 = c;
				advisoryList.remove(c);
				break;
			}
		}
		
		System.out.println("Enter Project ID = ");
		int k1 = Inputer.nextInt();
		Project P1 = null;
		for(Project c:projectList)
		{
			if(c.getProjectId() == k1)
			{
				P1 = c;
				projectList.remove(c);
				break;
			}
		}
		
		Group g = new Group(gd,s1,s2,s3,P1,A1);
		groupList.add(g);
	}
	
	public static void AddEvaluationofGroup() {
		int eid=0,TM=0,OM=0;
		System.out.println("Enter Group ID = ");
		int gid = Inputer.nextInt();
	
		System.out.println("Enter Evaluation ID = ");
		eid = Inputer.nextInt();
		
		System.out.println("Enter Total Marks = ");
		TM = Inputer.nextInt();
		
		System.out.println("Enter Obtained Marks = ");
		OM = Inputer.nextInt();
		Evaluation a;
		for(Group g : groupList) {
			if(g.getGid() == gid)
			{
				a = new Evaluation(eid,TM,OM);
				g.AddEvaluation(a);
				break;
			}
		}
	}
	
	public static void RemoveEvaluationofGroup() {
		int eid=0,TM=0,OM=0;
		System.out.println("Enter Group ID = ");
		int gid = Inputer.nextInt();
	
		System.out.println("Enter Evaluation ID = ");
		eid = Inputer.nextInt();
	
		for(Group g : groupList) {
			if(g.getGid() == gid)
			{
				g.RemoveEvaluation(eid);
				break;
			}
		}
	}
	
	public static void DisplayEvaluationofGroup() {
		int eid=0;
		System.out.println("Enter Group ID = ");
		int gid = Inputer.nextInt();
	
		System.out.println("Enter Evaluation ID = ");
		eid = Inputer.nextInt();
	
		for(Group g : groupList) {
			if(g.getGid() == gid)
			{
				g.DisplayEvaluations();
			}
		}
	}
	
	public static void WriteAllGroupsDetailInPDF() {
		
		 String FileName = "..\\ProjectManagement\\Groups.pdf";
		    Document document = new Document();
		    try {
				PdfWriter.getInstance(document, new FileOutputStream(FileName));
				
				document.open();
				
				Paragraph para = new Paragraph("Project Management System \n\n");
				
				for(Group g : groupList)
				{
					para.add("Group Id = " + String.valueOf(g.getGid()) + "\n\n" );
					
					para.add("Roll Number = " + String.valueOf( g.getS1().getRollNumber())+ "\n");
					para.add("Name = " + g.getS1().getName()+ "\n");
					para.add("Session = " + g.getS1().getSession()+ "\n\n");
					
					para.add("Roll Number = " +String.valueOf( g.getS2().getRollNumber())+ "\n");
					para.add("Name = " + g.getS2().getName()+ "\n");
					para.add("Session = " + g.getS2().getSession()+ "\n\n");
					
					para.add("Roll Number = " +String.valueOf( g.getS3().getRollNumber())+ "\n");
					para.add("Name = " + g.getS3().getName()+ "\n");
					para.add("Session = " + g.getS3().getSession()+ "\n\n");
				
					para.add("Project Id = " +String.valueOf(g.getP1().getProjectId()) + "\n");
					para.add("Project Title = " +g.getP1().getProjectTitle() + "\n");
					para.add("Project Type = " +g.getP1().getProjectType()+ "\n\n");
					
					para.add("Advisor = " +g.getA1().getAdvisor()+ "\n");
					para.add("Co-Advisor = " +g.getA1().getCoAdvisor() + "\n");
					para.add("Industrial Advisor = " +g.getA1().getIndustrialAdvisor()+ "\n\n");
					
					ArrayList<Evaluation> Ev = g.getEv();
					for(Evaluation e :Ev)
					{
						para.add("Evaluation Id = " +  String.valueOf(e.getEID()) + "\n");
						para.add("Evaluation Total Marks = " +  String.valueOf(e.getTotalMarks() ) + "\n");
						para.add("Evaluation Obtained Marks = " + String.valueOf(e.getObtainedmarks()) + "\n\n");
					}
					
					para.add("-----------------------------------");
				}
				
				
				document.add(para);
				
				
				document.close();
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		
	}
	Button b1,b2;
	TextField tf1,tf2,tf3;
	JFrame f;
	public void Login() {
		
		f = new JFrame("Project Management System");
		Label us = new Label("Username");
		Label pas = new Label("Password");
		
	us.setBounds(50,50,150,20);
        pas.setBounds(50,100,150,20);
	    
		  
	    
        tf1=new TextField();  
        tf1.setBounds(200,50,150,20);
        
        tf2=new TextField();  
        tf2.setBounds(200,100,150,20);  
        
           
        b1=new Button("Login");  
        b1.setBounds(50,200,50,50);  
          
        b1.addActionListener(this);  
          
        f.add(us);
        f.add(pas);
        f.add(tf1);
        f.add(tf2);
        
        f.add(b1);
          
        f.setSize(500,500);  
        f.setLayout(null);  
        f.setVisible(true);  
		
	}
	
	
	
	
	public static void main(String[] args) {
		ProjectManagement a = new ProjectManagement();
		a.Login();
				
	}
	static boolean login = true; 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String Username,Password;
		String Tu = null,Tp = null;
		if(e.getSource() == b1)
			Tu  = tf1.getText();
			Tp = tf2.getText();
		{
			String LinesReader;
			String [] BrokenStrings;
			try {
			      File myObj = new File("..\\ProjectManagement\\Users.txt");
			      Scanner myReader = new Scanner(myObj);
			      while (myReader.hasNextLine()) {
			    	  
			        LinesReader = myReader.nextLine();
			        //System.out.println(LinesReader);
			        BrokenStrings = LinesReader.split(",");
			     
			        Username = BrokenStrings[0];
			        Password = BrokenStrings[1];
			        if(Username.equalsIgnoreCase(Tu) && Password.equalsIgnoreCase(Tp) )
			        {
			        	login = false;
			        	break;
			        }
			        
			       
			     
			      }
			      if(login == false)
			      {
			    	  JOptionPane.showMessageDialog(f,
			    			    "The User has Logged In");
			    	  int choice = 0;
			  		while(true)
			  		{
			  		System.out.println("Enter 1 to read all projects form file \n"
			  						+  "Enter 2 to read all advisors from file \n"
			  						+  "Enter 3 to read all students from file \n"
			  						+  "Enter 4 to display all projects from file\n"
			  						+  "Enter 5 to display all advisors from file\n"
			  						+  "Enter 6 to display all students from file\n"
			  						+  "Enter 7 to add a group in the group List\n"
			  						+  "Enter 8 to display all the groups\n"
			  						+  "Enter 9 to add evaluation to the group\n"
			  						+  "Enter 10 to remove Evaluations of the group\n"
			  						+  "Enter 11 to Display Evaluations of the group\n"
			  						+  "Enter 12 to make pdf of all groups");
			  			choice = Inputer.nextInt();
			  		
			  			switch(choice) {
			  			case 1:
			  				AddProjectFromFile();
			  				break;
			  			case 2:
			  				AddAdvisorsFromFile();
			  				break;
			  			case 3:
			  				AddStudentsFromFile();
			  				break;
			  			case 4:
			  				DisplayProjects();
			  				break;
			  			case 5:
			  				DisplayAdvisors();
			  				break;
			  			case 6:
			  				DisplayStudents();
			  				break;
			  			case 7:
			  				AddGroupInGroupList();
			  				break;
			  			case 8:
			  				DisplayGroups();
			  				break;
			  			case 9:
			  				AddEvaluationofGroup();
			  				break;
			  			case 10:
			  				RemoveEvaluationofGroup();
			  				break;
			  			case 11:
			  				DisplayEvaluationofGroup();
			  				break;
			  			case 12:
			  				WriteAllGroupsDetailInPDF();
			  				break;
			  			}
			  		}
			      }
			      else
			      {
			    	  JOptionPane.showMessageDialog(f,
			    			    "invalid Login");
			      }
			}
			catch(Exception l)
			{
				
			}
		}
		
	}

}
