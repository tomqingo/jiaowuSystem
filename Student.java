import javax.swing.*;
import java.util.*;

public class Student{
	String name;
	String id;
	String classes; 
	List<Lecture> StudentLectures;
	
	public Student(String name, String id, String classes)
	{
		this.name = name;
		this.id = id;
		this.classes = classes;
		StudentLectures = new LinkedList<Lecture>();
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getid()
	{
		return id;
	}
	public String getclass()
	{
		return classes;
	}
	public List getlectures()
	{
		return StudentLectures;
	}
	public void Addlectures(Lecture lec)
	{
		int contained = 0;
		for(int i=0; i<StudentLectures.size(); i++)
		{

			if((lec.getlecname()).equals((StudentLectures.get(i)).getlecname()))
			{
				contained = 1;
				break;
			}
		}
		if(contained != 1)
			StudentLectures.add(lec);
	}
	public void Deletelectures(Lecture lec)
	{
		int selected = -1;
		
		for(int i=0; i<StudentLectures.size(); i++)
		{

			if((lec.getlecname()).equals((StudentLectures.get(i)).getlecname()))
			{
				selected = i;
				break;
			}
		}
		if(selected != -1)
			StudentLectures.remove(selected);
	}
	public void printgrades()
	{
		if(StudentLectures.size() > 0)
	   {
			for(int i=0; i<StudentLectures.size(); i++)
			{
				System.out.println((StudentLectures.get(i)).getlecname() + ": ");
				System.out.println((StudentLectures.get(i)).getgrades() + "\n");
			}
	   }
	}
	public void inputgrades(String grades, String lecname)
	{
		for(int i = 0; i < StudentLectures.size(); i++)
		{
			if(lecname.equals((StudentLectures.get(i)).getlecname()))
			{
				(StudentLectures.get(i)).entergrades(grades);
			     break;
		    }
		}
	}
		
	public void searchgrades()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Lecture Name:");
		String lecname = sc.nextLine();
		int find = -1;
		for(int i=0; i<StudentLectures.size(); i++)
		{
			if(lecname.equals((StudentLectures.get(i)).getlecname()))
			{
				find = 1;
				System.out.println("Grades: ");
			    System.out.println(((StudentLectures.get(i)).getgrades()) + "\n");
			}
        }
        if(find == -1)
           System.out.println("No such lecture, no grades!");
    }	   		
}
	