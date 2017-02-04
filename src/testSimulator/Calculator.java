package testSimulator;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	private ArrayList<Double> Coefficients;
	private double delta;

	public ArrayList<Double> parseEquasionCoefficients(Classroom classroom) {

		ArrayList<Double> array = new ArrayList<Double>();
		String equasion = classroom.getEquasion();
		Pattern p = Pattern.compile("-?\\d+");
		Matcher m = p.matcher(equasion);
		while (m.find()) {
			double n = Double.parseDouble(m.group());
			array.add(n);

		}
		array.remove(1);
		array.remove(3);
		return array;
	}

	public  ArrayList<ArrayList<Double>> parseAllEquasionsCoefficients(School school) {
		ArrayList<ArrayList<Double>> allCoefficients = new ArrayList<ArrayList<Double>>();
		for (Classroom c : school.getClassrooms()) {
			allCoefficients.add(parseEquasionCoefficients(c));
		}
		return allCoefficients;
	}

	public void mistakeProbabilityCalculator(Student student, Classroom classroom) {
		double mistakeProb;
		if (student.getAnnualGrade() != 5) {
			int classroomFactor = (int) (classroom.getNumOfStudents() / 5);
			mistakeProb = ((5 - student.getAnnualGrade()) * 0.1) * classroomFactor * 0.5;
			student.setMistakeProb(mistakeProb);
		} else {
			mistakeProb = 0;
			student.setMistakeProb(mistakeProb);
		}
	}

}
