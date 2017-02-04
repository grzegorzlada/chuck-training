package testSimulator;

import java.util.ArrayList;

public class Teacher {

	private ArrayList<Answer> answers;
	private static Answer correctAnswer;
	private static ArrayList<Answer> correctAnswers = new ArrayList<Answer>();

	public ArrayList<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(ArrayList<Answer> answers) {
		answers = answers;
	}

	public static Answer getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(Answer correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public void questionAllStudents(School school, Calculator calculator) {
		ArrayList<ArrayList<Answer>> answers = new ArrayList<ArrayList<Answer>>();
		for (Classroom c : school.getClassrooms()) {
			answers.add(questionStudent(c, calculator));
		}
		school.setAnswers(answers);
	}

	public ArrayList<Answer> questionStudent(Classroom classroom, Calculator calculator) {

		ArrayList<Answer> answers = new ArrayList<Answer>();
		ArrayList<Double> coefficients;
		coefficients = calculator.parseEquasionCoefficients(classroom);
		double a = coefficients.get(0);
		double b = coefficients.get(1);
		double c = coefficients.get(2);
		for (Student s : classroom.getStudents()) {
			calculator.mistakeProbabilityCalculator(s, classroom);
			Answer studentAnswer = s.answer(a, b, c);
			answers.add(studentAnswer);
		}
		Student student = new Student(5);
		correctAnswer = student.answer(a, b, c);
		correctAnswers.add(correctAnswer);
		return answers;

	}

	public static ArrayList<Answer> getCorrectAnswers() {
		return correctAnswers;
	}
}
