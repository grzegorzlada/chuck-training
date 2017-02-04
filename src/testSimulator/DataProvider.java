package testSimulator;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataProvider {

	private String regex = "-?\\d+x\\^2\\+?-?\\d+x\\+?-?\\d+=0";
	private int totalNumberOfStudents;
	private int numberOfBStudents;
	private int numberOfCStudents;
	private int numberOfDStudents;
	private int numberOfEStudents;
	private int numberOfFStudents;
	private int numberOfClasses;
	private String equasion;

	public int getTotalNumberOfStudents() {
		return totalNumberOfStudents;
	}

	public void setTotalNumberOfStudents(int totalNumberOfStudents) {
		this.totalNumberOfStudents = totalNumberOfStudents;
	}

	public int getNumberOfBStudents() {
		return numberOfBStudents;
	}

	public void setNumberOfBStudents(int numberOfBStudents) {
		this.numberOfBStudents = numberOfBStudents;
	}

	public int getNumberOfCStudents() {
		return numberOfCStudents;
	}

	public void setNumberOfCStudents(int numberOfCStudents) {
		this.numberOfCStudents = numberOfCStudents;
	}

	public int getNumberOfDStudents() {
		return numberOfDStudents;
	}

	public void setNumberOfDStudents(int numberOfDStudents) {
		this.numberOfDStudents = numberOfDStudents;
	}

	public int getNumberOfEStudents() {
		return numberOfEStudents;
	}

	public void setNumberOfEStudents(int numberOfEStudents) {
		this.numberOfEStudents = numberOfEStudents;
	}

	public int getNumberOfFStudents() {
		return numberOfFStudents;
	}

	public void setNumberOfFStudents(int numberOfFStudents) {
		this.numberOfFStudents = numberOfFStudents;
	}

	public String getEquasion() {
		return equasion;
	}

	public void setEquasion(String equasion) {
		this.equasion = equasion;
	}

	public int getNumberOfClasses() {
		return numberOfClasses;
	}

	public void getClassroomInformationFromUser(School school) {
		ArrayList<Classroom> classrooms = new ArrayList<Classroom>();
		askNumOfClasses();
		for (int i = 0; i < this.numberOfClasses; i++) {
			System.out.println("Podaj dane dla " + (i + 1) + " klasy");
			do {
				askNumOfAllStudents();
				askNumOfBStudents();
				askNumOfCStudents();
				askNumOfDStudents();
				askNumOfEStudents();
				askNumOfFStudents();
			} while (!this.isDataValid());

			do {
				String equasionToCheck = askEquasion();
				this.setEquasion(equasionToCheck);
			} while (!this.checkEquasion(regex, equasion));
			Classroom classroom = new Classroom(this.numberOfBStudents, this.numberOfCStudents, this.numberOfDStudents,
					this.numberOfEStudents, this.numberOfFStudents, this.totalNumberOfStudents, this.equasion);
			classrooms.add(classroom);
		}
		
		school.setClassrooms(classrooms);

	}

	public int askForData(String messageForUser, int valueOfProperField) {

		boolean isDataValid = false;
		do {
			Scanner in = new Scanner(System.in);
			System.out.println(messageForUser);

			try {
				int userInput = in.nextInt();
				if (userInput >= 0) {
					valueOfProperField = userInput;
					break;
				} else {
					System.out.println("Podaj liczbę całkowitą większą od -1!");
					isDataValid = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Nie podałeś liczby całkowitej!");
				in.next();
				isDataValid = true;
			}

		} while (isDataValid);

		return valueOfProperField;
	}

	public void askNumOfClasses() {

		boolean isDataValid;

		do {
			Scanner in = new Scanner(System.in);
			System.out.println("Podaj liczbę klas, które chcesz utworzyć");

			try {
				int userInput = in.nextInt();
				if (userInput > 0) {
					this.numberOfClasses = userInput;
					break;
				} else {
					System.out.println("Podaj liczbę całkowitą większą od 0!");
					isDataValid = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Nie podałeś liczby całkowitej!");
				in.next();
				isDataValid = true;
			}

		} while (isDataValid);
	}

	public void askNumOfAllStudents() {
		int valueOfAllStudents = 0;
		String message = "Podaj liczbę wszystkich uczniów";
		valueOfAllStudents = askForData(message, valueOfAllStudents);
		this.totalNumberOfStudents = valueOfAllStudents;
	}

	public void askNumOfBStudents() {
		int valueOfBStudents = 0;
		String message = "Podaj liczbę piątkowych uczniów";
		valueOfBStudents = askForData(message, valueOfBStudents);
		this.numberOfBStudents = valueOfBStudents;
	}

	public void askNumOfCStudents() {
		int valueOfCStudents = 0;
		String message = "Podaj liczbę czwórkowych uczniów";
		valueOfCStudents = askForData(message, valueOfCStudents);
		this.numberOfCStudents = valueOfCStudents;
	}

	public void askNumOfDStudents() {
		int valueOfDStudents = 0;
		String message = "Podaj liczbę trójkowych uczniów";
		valueOfDStudents = askForData(message, valueOfDStudents);
		this.numberOfDStudents = valueOfDStudents;

	}

	public void askNumOfEStudents() {
		int valueOfEStudents = 0;
		String message = "Podaj liczbę dwójkowych uczniów";
		valueOfEStudents = askForData(message, valueOfEStudents);
		this.numberOfEStudents = valueOfEStudents;

	}

	public void askNumOfFStudents() {
		int valueOfFStudents = 0;
		String message = "Podaj liczbę jedynkowych uczniów";
		valueOfFStudents = askForData(message, valueOfFStudents);
		this.numberOfFStudents = valueOfFStudents;
	}

	public String askEquasion() {
		Scanner in = new Scanner(System.in);
		System.out.println("Podaj równanie kwardratowe do rozwiązania w formacie ax^2+bx+c=0");
		String equasion = in.next();
		this.equasion = equasion;
		// in.close();
		return equasion;
	}

	public boolean checkEquasion(String regex, String equasionToCheck) {

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(equasionToCheck);

		if (matcher.matches()) {
			this.equasion = equasionToCheck;
			return true;
		}

		else {
			System.out.println("Podałeś zły format równania! Spróbuj jeszcze raz.");
			return false;
		}
	}

	public boolean isDataValid() {

		if (this.getTotal() == this.totalNumberOfStudents) {
			return true;
		} else {
			System.out.println("Popełniłeś błąd, zaczynamy od początku!");
			return false;
		}
	}

	public int getTotal() {
		int total = this.numberOfBStudents + this.numberOfCStudents + this.numberOfDStudents + this.numberOfEStudents
				+ this.numberOfFStudents;
		return total;
	}
}
