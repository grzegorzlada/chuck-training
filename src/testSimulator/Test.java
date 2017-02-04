package testSimulator;

import java.util.ArrayList;

/**
 * Bedzie kilka iteracji poprawek tego programu.
 * Niestety na te chwile kod wyglada jak zyg. Sformatuj to ladnie, a nie jakies
 * bazgroly mi wysylasz, ktorych sie czytac nie da.
 * Nie odpalam tego dopoki nie posprzatasz.
 * Zastosuj sie tez do wszelkich innych uwag.
 * 
 * Oprocz tego, zeby Cie zachecic do zmiany nieco architektory rozwiazania dam Ci tylko jeden hint:
 * zrob tak, zeby robione byly dwie klasy w znaczeniu klasy szkolnej. Obydwa dostaja te same parametry wejsciowe 
 * (ilosc studentow, rownanie). Nastepnie obydwie wypisuja swoje wyniki tak jak teraz (najpierw jedna, potem druga, z zaznaczeniem ktora aktualnie klasa jest wypisywana)
 * A na koniec ma byc napisane ktora klasa podala wiecej prawidlowych odpowiedzi (jako ze bazujemy na prawdopodobienstwie, to wyniki moga byc rozne).
 * @author grzeg
 */

public class Test {	
	public static void main(String[] args) {        
		
	DataProvider data = new DataProvider();
	Classroom classroom = new Classroom();
	Teacher teacher = new Teacher();
	Calculator calculator = new Calculator();
	Summary summary = new Summary();
	School school = new School();
	data.getClassroomInformationFromUser(school);
	classroom.eachClassroomMaker(school);
	calculator.parseAllEquasionsCoefficients(school);
	teacher.questionAllStudents(school, calculator);
	summary.eachClassroomSummary(school);	
	
	}

}
