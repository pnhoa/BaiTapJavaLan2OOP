package com.nhuhoa.studentmanagement.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

import com.nhuhoa.studentmanagement.bo.Student;
import com.nhuhoa.studentmanagement.enums.LearningCapacity;
import com.nhuhoa.studentmanagement.untils.JavaUntils;

public class Main {
	 
	public static  void convert(ArrayList<Student> listOfStudent) {
		try {
			File myFile = new File("filename.txt");
			Scanner myReader = new Scanner(myFile);
			while(myReader.hasNextLine()) {
				String data = myReader.nextLine();
				if(data.length()>0) {
					String[] arrStr = data.split(";");
					if(arrStr.length == 7) {
						arrStr[0] = JavaUntils.standardizeID(arrStr[0]);
						arrStr[1] = JavaUntils.standardizeName(arrStr[1]);
						LocalDate birthday = JavaUntils.standardizeDate(arrStr[2]);
						arrStr[3] = JavaUntils.standardize(arrStr[3]);
						arrStr[4] = JavaUntils.standardizePhoneNumber(arrStr[4]);
						arrStr[5] = JavaUntils.standardizeEmail(arrStr[5], arrStr[0]);
						float number = JavaUntils.convertNumberStringToFloat(arrStr[6]);
						listOfStudent.add(new Student(arrStr[0], arrStr[1], birthday, arrStr[3], arrStr[4], arrStr[5],number));
					}
					
				}
				}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occured.");
			e.printStackTrace();
		}
	}
	public static void display(ArrayList<Student> listOfStudent) {
		System.out.println("+ List of student");
		int index = 1;
		System.out.println("Index\tID name\tName\t\tDate of birth\tPhone number\tEmail\t\t\tLearning Capacity");
		for (Student stu : listOfStudent) {
			LearningCapacity s;
			if (stu.getScore() >= 9) {
				s = LearningCapacity.EXCILLENT;
			} else if (stu.getScore() < 9 && stu.getScore() >= 7) {
				s = LearningCapacity.GOOD;
			} else {
				s = LearningCapacity.BAD;
			}
			if (stu.getEmail() == "") {
				stu.setEmail("N/A       ");
			}
			if (stu.getPhoneNumber() == "") {

				stu.setPhoneNumber("N/A       ");
			}
			if(stu.getDateOfBirth() == null) {
				System.out.println(index + "\t" + stu.getId() + "\t" + stu.getName() + "   \t" +  "N/A       " + "\t"
						+ stu.getPhoneNumber() + "\t" + stu.getEmail() + "  \t" + s);
			} else {
				String date = JavaUntils.formatDayOfBirth(stu.getDateOfBirth());
			System.out.println(index + "\t" + stu.getId() + "\t" + stu.getName() + "   \t" + date + "\t"
					+ stu.getPhoneNumber() + "\t" + stu.getEmail() + "  \t" + s);
			}
			index++;
		}
		System.out.println("-----------------------------------------------------------------------------------------------------------");
	}
	public static void size(ArrayList<Student> listOfStudent) {
		System.out.println("+ Number of student in list: " + listOfStudent.size());
		System.out.println();
	}
	public static void displayIDName(ArrayList<Student> listOfStudent) {
		System.out.println("+ List of student");
		System.out.println("ID name\tName");
		for(Student stu : listOfStudent) {
			System.out.println(stu.getId() + "\t" + stu.getName() );
		}
		System.out.println("----------------------------------------------------------------");
	}
	public static void displayNoPhoneEmail(ArrayList<Student> listOfStudent) {
		System.out.println("+ List of student no phone or email");
		System.out.println("ID name\tName\t\tStatus");
		for(Student stu : listOfStudent) {
			if(stu.getPhoneNumber().isEmpty() && stu.getEmail().isEmpty()) {
				System.out.println(stu.getId() + "\t" + stu.getName() + "No phone and email");
			}
			else {
				if(stu.getPhoneNumber().isEmpty() && stu.getEmail().isEmpty() == false) {
					System.out.println(stu.getId() + "\t" + stu.getName() + "\t\tNo phone ");
				}
				if(stu.getPhoneNumber().isEmpty() ==false && stu.getEmail().isEmpty()) {
					System.out.println(stu.getId() + "\t" + stu.getName() + "\tNo email ");
				}
			}
			
		}
		System.out.println("----------------------------------------------------------------");
	}
	public static void displayExellentStuent(ArrayList<Student> listOfStudent) {
		System.out.println("+ Exellent student:");
		System.out.println("ID name\tName");
		for(Student stu : listOfStudent) {
			if(stu.getScore() >= 9)
			System.out.println(stu.getId() + "\t" + stu.getName() );
		}
		System.out.println("----------------------------------------------------------------");
	}
	public static void displayGoodStuent(ArrayList<Student> listOfStudent) {
		System.out.println("+ Good student:");
		System.out.println("ID name\tName");
		for(Student stu : listOfStudent) {
			if(stu.getScore() < 9 && stu.getScore() >= 7)
			System.out.println(stu.getId() + "\t" + stu.getName() );
		}
		System.out.println("----------------------------------------------------------------------------------------------------------");
	}
	public static void displayNoUpdateEmail(ArrayList<Student> listOfStudent) {
		System.out.println("+ No update Email");
		System.out.println("ID name\tName");
		for(Student stu : listOfStudent) {
			if(stu.getEmail().isEmpty()) {
				System.out.println(stu.getId() + "\t" + stu.getName());
			}
		}
		System.out.println("----------------------------------------------------------------");
	}
	public static void main(String[] args) {
		ArrayList<Student> listOfStudent = new ArrayList<Student>();
		convert(listOfStudent);
		size(listOfStudent);
		displayIDName(listOfStudent);
		displayNoPhoneEmail(listOfStudent);
		displayNoUpdateEmail(listOfStudent);
		displayExellentStuent(listOfStudent);
		displayGoodStuent(listOfStudent);
		Collections.sort(listOfStudent);
		display(listOfStudent);
			}
}
