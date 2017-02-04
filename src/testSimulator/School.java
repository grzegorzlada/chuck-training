package testSimulator;

import java.util.ArrayList;

public class School {

	private ArrayList<Classroom> classrooms;
	private ArrayList<ArrayList<Answer>> answers;

	public ArrayList<Answer> getAnswers(int whichClass) {

		ArrayList<Answer> answersOfChoosenClass = answers.get(whichClass);
		return answersOfChoosenClass;
	}

	public void setAnswers(ArrayList<ArrayList<Answer>> answers) {
		this.answers = answers;
	}

	public void setClassrooms(ArrayList<Classroom> classrooms) {
		this.classrooms = classrooms;
	}

	public ArrayList<Classroom> getClassrooms() {

		return classrooms;
	}

}
