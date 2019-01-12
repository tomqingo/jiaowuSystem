import javax.swing.*;
import java.util.*;

public class SystemTest{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int identity = 0;
		Student stu;
		Lecture lec;
		String name;
		String id;
		String classes;
		String class_reg;
		String courses_name;
		TopManage administrator;
		administrator = new TopManage();
		List<String> Chooseclassid = new LinkedList<String> ();
		int admin_choose;
		int stu_choose;
		int i;
		
		while(identity != -1)
	   {
		System.out.println("Class System\n");
		System.out.println("Your identity(1-administrator,2-student,-1-exit)\n");
		identity = sc.nextInt();
		admin_choose = 0;
		stu_choose = 0;
		while(identity == 1 && admin_choose != 6)
		{
			System.out.println("Choices of administrator:(1-Add Students 2-Delete Students 3-Find Students 4-See class Choices 5-Register Grades 6-Exit)\n");
			admin_choose = sc.nextInt();
			switch(admin_choose)
			{
				case 1:
						System.out.println("Student Name:");
						sc.nextLine();
						name = sc.nextLine();
						System.out.println(name);
						System.out.println("Student id:");
						id = sc.nextLine();
						System.out.println("Student class:");
						classes = sc.nextLine();
						stu = new Student(name, id, classes);
						administrator.StudentAdd(stu);
						break;
				case 2:
						System.out.println("Student name:");
						sc.nextLine();
						name = sc.nextLine();
						System.out.println("Student id:");
						id = sc.nextLine();
						System.out.println("Student class:");
						classes = sc.nextLine();
						stu = new Student(name, id, classes);
						administrator.DeleteStudents(stu);
						break;
				case 3:
						System.out.println("Student id:");
						sc.nextLine();
						id = sc.nextLine();
						stu = administrator.searchStudent(id);
						if(stu == null)
							System.out.println("Not found\n");
						else
						{
							System.out.println("Student Name:");
	                        System.out.println(stu.getName());
							System.out.println("Student Class:");
							System.out.println(stu.getclass());
							System.out.println("Student Lectures and Grades:");
							stu.printgrades();
						}
					    break;
				case 4:
						System.out.println("Class Name:");
						sc.nextLine();
						class_reg = sc.nextLine();
						Chooseclassid = administrator.searchClassChoose(class_reg);
						break;
				case 5:
						System.out.println("Class Name:");
						sc.nextLine();
						class_reg = sc.nextLine();
						Chooseclassid = administrator.searchClassChoose(class_reg);
						administrator.LogGrades(Chooseclassid, class_reg);
						break;
				default:
						break;
			
						
						
	  	    }
        }
	
		i = 1;
		while(identity==2)
		{
			System.out.println("Please enter your id:(5 to exit)\n");
			if(i==1)
			{
				sc.nextLine();
				i = 2;
			}
			id = sc.nextLine();
			stu = administrator.searchStudent(id);
			if(id.equals(Integer.toString(5)))
				break;
			else
			{
				if(stu == null)
					System.out.println("Not found!\n");
				else
				{
					stu_choose = 0;
					while(stu_choose!=5)
					{
						System.out.println("Choices of Students:(1-Add courses 2-Delete courses 3-Show Grades Chart 4-Search grades 5-Exit)\n");
						stu_choose = sc.nextInt();
						switch(stu_choose)
						{
							case 1:
								System.out.println("Please enter the name of one course:\n");
								sc.nextLine();
								courses_name = sc.nextLine();
								lec = new Lecture(courses_name, Integer.toString(0));
								administrator.DeleteStudents(stu); 
								stu.Addlectures(lec);
								administrator.StudentAdd(stu);
								break;
							case 2:
								System.out.println("Please enter the name of one course:\n");
								sc.nextLine();
								courses_name = sc.nextLine();
								lec = new Lecture(courses_name, Integer.toString(0));
								administrator.DeleteStudents(stu); 
								stu.Deletelectures(lec);
								administrator.StudentAdd(stu);
								break;
							case 3:
								System.out.println("Your grades for all courses are as follows:\n");
								i = 1;
								stu.printgrades();
								break;
							case 4:
								stu.searchgrades();
								i = 1;
								break;
							default:
							    i = 1;
								break;
						}
					}
				}
				  
						
	
			}
		}
	}
	}
}		
		