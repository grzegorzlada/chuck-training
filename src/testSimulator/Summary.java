package testSimulator;

import java.util.ArrayList;

public class Summary {

	private static int countCorrectAnswers = 0;
	private static int countWrongAnswers = 0;

	public int getCountCorrectAnswers() {
		return countCorrectAnswers;
	}

	public void setCountCorrectAnswers(int countCorrectAnswers) {
		this.countCorrectAnswers = countCorrectAnswers;
	}

	public void setCountWrongAnswers(int countWrongAnswers) {
		this.countWrongAnswers = countWrongAnswers;
	}

	public int getCountWrongAnswers() {
		return countWrongAnswers;
	}

	public static void classroomSummary(int whichClassroom, School school) {

		int i = 0;
		for (Student s : school.getClassrooms().get(whichClassroom).getStudents()) {

			String answer;
			String answer1 = " [ODPOWIEDŹ POPRAWNA]";
			String answer2 = " [ODPOWIEDŹ BŁĘDNA]";
			if (s.getDelta() >= 0) {
				if (school.getAnswers(whichClassroom).get(i).getX1() == Teacher.getCorrectAnswers().get(whichClassroom)
						.getX1()
						&& school.getAnswers(whichClassroom).get(i).getX2() == Teacher.getCorrectAnswers()
								.get(whichClassroom).getX2()) {
					answer = answer1;
					countCorrectAnswers++;
				} else {
					answer = answer2;
					countWrongAnswers++;
				}

				System.out.println("Uczeń" + (i + 1) + "(ocena końcowa: " + s.getAnnualGrade() + "): x1 = "
						+ school.getAnswers(whichClassroom).get(i).getX1() + " x2 = "
						+ school.getAnswers(whichClassroom).get(i).getX2() + answer
						+ " Prawdopodobieństwo popełnienia błędu: " + s.getMistakeProb());

				i++;
			}

			else {
				if (school.getAnswers(whichClassroom).get(i).getNotExist()
						.equals(Teacher.getCorrectAnswers().get(whichClassroom).getNotExist())) {
					answer = answer1;
					countCorrectAnswers++;
				} else {
					answer = answer2;
					countWrongAnswers++;
				}
				System.out.println("Uczeń" + (i + 1) + "(ocena końcowa: " + s.getAnnualGrade() + ") "
						+ school.getAnswers(whichClassroom).get(i).getNotExist() + answer
						+ " Prawdopodobieństwo popełnienia błędu: " + s.getMistakeProb());
				i++;
			}
		}

		System.out.println(
				"\n\nODPOWIEDZI POPRAWNE: " + countCorrectAnswers + "\n\nODPOWIEDZI BŁĘDNE: " + countWrongAnswers);

	}

	public static void eachClassroomSummary(School school) {

		for (int i = 0; i < school.getClassrooms().size(); i++) {
			classroomSummary(i, school);
			countWrongAnswers = 0;
			countCorrectAnswers = 0;

		}
	}

}
