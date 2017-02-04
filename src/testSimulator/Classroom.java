package testSimulator;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Classroom {

	private int BStudents;
	private int CStudents;
	private int DStudents;
	private int EStudents;
	private int FStudents;		
	private int numOfStudents;
	private   ArrayList<Student> students;
	private String equasion;		
	
	
	// GETTERS AND SETTERS
	
	
	public   ArrayList<Student> getStudents() {
		return students;
	}		
	
	public int getNumOfStudents() {
		return numOfStudents;
	}
	public void setNumOfStudents(int numOfStudents) {
		
		this.numOfStudents = numOfStudents;
	}
	public int getBStudents() {
		return BStudents;
	}
	public void setBStudents(int bStudents) {
		BStudents = bStudents;
	}
	public int getCStudents() {
		return CStudents;
	}
	public void setCStudents(int cStudents) {
		CStudents = cStudents;
	}
	public int getDStudents() {
		return DStudents;
	}
	public void setDStudents(int dStudents) {
		DStudents = dStudents;
	}
	public int getEStudents() {
		return EStudents;
	}
	public void setEStudents(int eStudents) {
		EStudents = eStudents;
	}
	public int getFStudents() {
		return FStudents;
	}
	public void setFStudents(int fStudents) {
		FStudents = fStudents;
	}
	//END OF GETTERS AND SETTERS
	
	public Classroom(){
		
	}
	public Classroom(int numOfBStudents, int numOfCStudents, int numOfDStudents, int numOfEStudents, int numOfFStudents, int totalNumberOfStudents, String equasion){
		this.BStudents = numOfBStudents;
		this.CStudents = numOfCStudents;
		this.DStudents = numOfDStudents;
		this.EStudents = numOfEStudents;
		this.FStudents = numOfFStudents;
		this.numOfStudents = totalNumberOfStudents;
		this.equasion = equasion;
	}
	public String getEquasion() {
		return equasion;
	}

	public  void classroomMaker(){
			students = new ArrayList<Student>();
			for(int i = 0; i < this.getBStudents(); i++ ){
				Student student = new Student(5);
				students.add(student);
			}
			for(int i = 0; i < this.getCStudents(); i++ ){
				Student student = new Student(4);
				students.add(student);
			}
			for(int i = 0; i < this.getDStudents(); i++ ){
				Student student = new Student(3);
				students.add(student);
			}
			for(int i = 0; i < this.getEStudents(); i++ ){
				Student student = new Student(2);
				students.add(student);
			}
			for(int i = 0; i < this.getFStudents(); i++ ){
				Student student = new Student(1);
				students.add(student);
			}
		}
	
	public void eachClassroomMaker(School school){
		for (int i=0; i < school.getClassrooms().size(); i++){
			school.getClassrooms().get(i).classroomMaker();
		}
	}		
}

	
	

	
