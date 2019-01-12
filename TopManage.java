import javax.swing.*;
import java.util.*;

public class TopManage{
	List<Student> StudentLists;
	
	public TopManage()
	{
		StudentLists = new LinkedList<Student>();
	}
	
	public void StudentAdd(Student stu)
	{
		int contained = 0;
		for(int i=0; i<StudentLists.size(); i++)
		{

			if((stu.getid()).equals((StudentLists.get(i)).getid()))
			{
				contained = 1;
				break;
			}
		}
		if(contained != 1)
			StudentLists.add(stu);
	}
	public void DeleteStudents(Student stu)
	{
		int selected = -1;
		
		for(int i=0; i<StudentLists.size(); i++)
		{

			if((stu.getid()).equals((StudentLists.get(i)).getid()))
			{
				selected = i;
				break;
			}
		}
		if(selected != -1)
			StudentLists.remove(selected);
	}
	public List getStudentList()
	{
		return StudentLists;
	}
	public void printStudentsChart()
	{
		List<Lecture> lectures = new LinkedList<Lecture>();
		for(int i=0; i<StudentLists.size(); i++)
		{
			System.out.println((StudentLists.get(i)).getName() + " ");
			System.out.println((StudentLists.get(i)).getid() + " ");
			System.out.println((StudentLists.get(i)).getclass() + " ");
			lectures = (StudentLists.get(i)).getlectures();
			if(((StudentLists.get(i)).getlectures()).size() > 1 || ((StudentLists.get(i)).getlectures()).size() == 1)
			{
				for(int j=0; j<((StudentLists.get(i)).getlectures()).size(); j++)
				{
					System.out.println((lectures.get(j)).getlecname() + ": ");
					System.out.println((lectures.get(j)).getgrades() + ": ");
				}
			}
			System.out.println("\n");
		}
	}
	public Student searchStudent(String id)
	{
		int find = -1;
		for(int i=0; i<StudentLists.size(); i++)
		{
			if(id.equals((StudentLists.get(i)).getid()))
			{
				find = i;
				break;
			}
		}
		if(find == -1)
		    return null;
		else
			return StudentLists.get(find);
	}
	public List searchClassChoose(String lecname)
	{
		List<String> Chooseclassid = new LinkedList<String>();
		System.out.println("The Students who choose this lecture:\n");
		List<Lecture> lectures = new LinkedList<Lecture>();
		for(int i=0; i<StudentLists.size(); i++)
		{
			lectures = (StudentLists.get(i)).getlectures();
			for(int j=0; j<((StudentLists.get(i)).getlectures()).size(); j++)
			{
				if (lecname.equals((lectures.get(j)).getlecname()))
				{
					Chooseclassid.add((StudentLists.get(i)).getid());
					System.out.println((StudentLists.get(i)).getid() + "\n");
					break;
				}
			}
			
		}
		return Chooseclassid;
	}
					
	public void LogGrades(List Chooseclassid, String classes)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the grades for these students\n");
		for(int i=0; i<Chooseclassid.size(); i++)
		{
			int location = -1;
			System.out.println(Chooseclassid.get(i) + ": ");
			for(int j=0; j<StudentLists.size(); j++)
			{
				if((Chooseclassid.get(i)).equals((StudentLists.get(j)).getid()))
				{
					location = j;
					break;
				}
			}
			
			String grades;
			grades = sc.nextLine();
			(StudentLists.get(location)).inputgrades(grades, classes);
		}
	}
			
				
}
		
		