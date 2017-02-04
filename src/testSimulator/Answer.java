package testSimulator;

/**
 * Znowu spierdolone formatowanie. Jak mozesz to spierdolic, skoro w obecnych
 * czasach kazdy edytor ma opcje autoformatowania i naprawde trudno to
 * spierdolic?
 * 
 * @author grzeg
 */
public class Answer {

	private double x1;
	private double x2;
	private String solutionNotExist;

	public String getNotExist() {

		return solutionNotExist;
	}

	public void setNotExist(String notExist) {
		this.solutionNotExist = notExist;
	}

	public double getX1() {
		return x1;
	}

	public void setX1(double x1) {
		this.x1 = x1;
	}

	public double getX2() {
		return x2;
	}

	public void setX2(double x2) {
		this.x2 = x2;
	}

	public void addJunkValueToX1(Student student) {

		double randomValue = Math.random();
		if (randomValue > student.getMistakeProb()) {
			this.x1 = x1;
		}

		else {
			this.x1 = x1 + 1;
		}

	}

	public void addJunkValueToX2(Student student) {

		double randomValue = Math.random();

		if (randomValue > student.getMistakeProb()) {

			this.x2 = x2;
		}

		else {
			this.x2++;
		}
	}

	public void addJunkValuetoSolutionSolutionNotExist(Student student) {

		double randomValue = Math.random();

		if (randomValue > student.getMistakeProb()) {

			this.solutionNotExist = solutionNotExist;
		}

		else {
			this.solutionNotExist = "nie umiem rozwiązać";
		}

	}

}
