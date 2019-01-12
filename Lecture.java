import java.util.*;

public class Lecture{
	String lecname; //课程名字
	String grades; //课程成绩
	
	public Lecture(String lecname, String grades)
	{
		this.lecname = lecname;
		this.grades = grades;
	}
	
	public String getlecname()
	{
		return lecname;
	}
	public String getgrades()
	{
		return grades;
	}
	public void entergrades(String grades)
	{
		this.grades = grades;
	}
}
	