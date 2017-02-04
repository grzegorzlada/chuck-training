package testSimulator;

public class Student {

	private int annualGrade;
	private Answer answer;
	private double mistakeProb;
	private double delta;

	// GETTERS AND SETTERS

	public double getDelta() {
		return delta;
	}

	public void setDelta(double delta) {
		this.delta = delta;
	}

	public double getMistakeProb() {
		return mistakeProb;
	}

	public void setMistakeProb(double mistakeProb) {
		this.mistakeProb = mistakeProb;
	}

	public int getAnnualGrade() {
		return annualGrade;
	}

	public void setAnnualGrade(int grade) {
		this.annualGrade = grade;
	}

	public Student(int annualGrade) {

		this.annualGrade = annualGrade;
	}
	// END OF GETTERS AND SETTERS

	public Answer answer(double CoefficientA, double CoefficientB, double CoefficientC) {
		Answer answer = new Answer();

		double delta = Math.pow(CoefficientB, 2) - 4 * CoefficientA * CoefficientC;
		double pierwiastek = Math.sqrt(delta);
		double x1 = (-CoefficientB + pierwiastek) / (2 * CoefficientA);
		double x2 = (-CoefficientB - pierwiastek) / (2 * CoefficientA);
		if (delta >= 0) {
			answer.setX1(x1);
			answer.setX2(x2);
			answer.addJunkValueToX1(this);
			answer.addJunkValueToX2(this);
		} else if (delta < 0) {
			answer.setNotExist("brak rozwiązań");
			answer.addJunkValuetoSolutionSolutionNotExist(this);
			//setDelta(-1);
		}

		return answer;
	}

}
