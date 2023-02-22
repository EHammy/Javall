package view;

import java.util.List;
import java.util.Scanner;

import controller.ListStudentHelper;
import model.ListStudent;

public class StartProgram {
	static Scanner in = new Scanner(System.in);
	static ListStudentHelper lih = new ListStudentHelper();

	private static void addAnStudent() {
		// TODO Auto-generated method stub
		System.out.print("Enter a Student: ");
		String Student = in.nextLine();
		System.out.print("Enter Attendance(Here(H) or Absent(A)): ");
		String Attendance = in.nextLine();

		ListStudent toInsert = new ListStudent(Student, Attendance);

		lih.insertStudent(toInsert);

	}

	private static void deleteAnStudent() {
		// TODO Auto-generated method stub
		System.out.print("Enter a Student to delete: ");
		String Student = in.nextLine();
		System.out.print("Enter the Attendance to delete: ");
		String Attendance = in.nextLine();
		ListStudent toDelete = new ListStudent(Student, Attendance);
		
		lih.deleteStudent(toDelete);
	}

	private static void editAnStudent() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Student");
		System.out.println("2 : Search by Attendance");
		int searchBy = in.nextInt();
		in.nextLine();
		List<ListStudent> foundStudents;
		if (searchBy == 1) {
			System.out.print("Enter the Student's Name: ");
			String StudentName = in.nextLine();
			foundStudents = lih.searchForStudentByStudent(StudentName);
		} else {
			System.out.print("Enter Attendance:(H,A) ");
			String AttendanceName = in.nextLine();
			foundStudents = lih.searchForStudentByAttendance(AttendanceName);

		}

		if (!foundStudents.isEmpty()) {
			System.out.println("Found Results.");
			for (ListStudent l : foundStudents) {
				System.out.println(l.getId() + " : " + l.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			ListStudent toEdit = lih.searchForStudentById(idToEdit);
			System.out.println("Retrieved " + toEdit.getStudent() + " from " + toEdit.getAttendance());
			System.out.println("1 : Update Student");
			System.out.println("2 : Update Attendance");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Student: ");
				String newStudent = in.nextLine();
				toEdit.setStudent(newStudent);
			} else if (update == 2) {
				System.out.print("New Attendance: ");
				String newAttendance = in.nextLine();
				toEdit.setAttendance(newAttendance);
			}

			lih.updateStudent(toEdit);

		} else {
			System.out.println("---- No results found");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Attendance Management System ---");
		while (goAgain) {
			System.out.println("*  Select an Student:");
			System.out.println("*  1 -- Add an Student");
			System.out.println("*  2 -- Edit an Student");
			System.out.println("*  3 -- Delete an Student");
			System.out.println("*  4 -- View the list");
			System.out.println("*  5 -- Exit the program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAnStudent();
			} else if (selection == 2) {
				editAnStudent();
			} else if (selection == 3) {
				deleteAnStudent();
			} else if (selection == 4) {
				viewTheList();
			} else {
				lih.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}

	private static void viewTheList() {
		// TODO Auto-generated method stub
		List<ListStudent> allStudents = lih.showAllStudents();
		for(ListStudent l : allStudents){
			System.out.println(l.toString());
		}

	}

}
