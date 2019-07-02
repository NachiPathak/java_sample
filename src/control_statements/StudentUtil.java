package control_statements;

public class StudentUtil {

	public static double[] calculateGPA(int[] studentIdList,
			char[][] studentsGrades) {
		int gradeTotal = 0;
		int totalCourses = 0;

		double[] gpa = new double[studentIdList.length];

		for (int i = 0; i < studentsGrades.length; i++) {
			totalCourses = studentsGrades[i].length;
			for (int j = 0; j < totalCourses; j++) {
				char grade = studentsGrades[i][j];
				if (grade == 'A') {
					gradeTotal += 4;
				} else if (grade == 'B') {
					gradeTotal += 3;
				}
			}

			gpa[i] = (double) gradeTotal / totalCourses;
			gradeTotal = 0;
			totalCourses = 0;
		}

		return gpa;
		// your code
	}

	public static int[] getStudentsByGPA(double lower, double higher,
			int[] studentIdList, char[][] studentsGrades) {

		if ((lower > higher) || (lower < 0 && higher < 0)) {
			return null;
		}
		double[] gpas = calculateGPA(studentIdList, studentsGrades);
		for (int i = 0; i < studentIdList.length && i < gpas.length; i++) {
			double gpa = gpas[i];

			if (!(gpa >= lower && gpa < higher)) {
				studentIdList[i] = -9999;

			}

		}
		int size = studentIdList.length;

		for (int i = 0; i < size; i++) {
			if (studentIdList[i] == -9999) {
				size--;
			}
		}

		int count = 0;

		int[] students = new int[size];

		for (int i = 0; i < studentIdList.length; i++) {
			if (studentIdList[i] != -9999) {
				students[count] = studentIdList[i];
			}
		}
		return students;
		// perform parameter validation. Return null if passed parameters are
		// not valid

		// invoke calculateGPA

		// construct the result array and return it. You would need an extra for
		// loop to compute the size of the resulting array
	}

	public static void main(String[] args) {
		double lower = 3.2;
		double higher = 3.5;

		int[] studentIdList = { 1001, 1002 };
		char[][] studentsGrades = { { 'A', 'A', 'A', 'B' }, { 'A', 'B', 'B' } };

		int[] students = getStudentsByGPA(lower, higher, studentIdList,
				studentsGrades);

		System.out.println("Student in the GPA Range of " + lower + " and "
				+ higher + " are");
		for (int student : students) {
			System.out.println(student);
		}
		
		
		System.out.println( 9 * 5 - 'a' / 5.0);

	}
}