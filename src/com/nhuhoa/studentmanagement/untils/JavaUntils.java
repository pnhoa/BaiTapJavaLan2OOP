package com.nhuhoa.studentmanagement.untils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class JavaUntils {
	public static String standardize(String str) {
		str = str.trim();
		while(str.indexOf("  ") != -1) {
			str = str.replaceAll("  ", " ");
		}
		
		return str;
	}
	public static String standardizeName(String str) {
		
		str = standardize(str);
		/*
		 * String[] arrWord = standardizedStr.split(" "); standardizedStr = ""; for
		 * (String word : arrWord) { word = word.toLowerCase(); word =
		 * word.replaceFirst(word.charAt(0) + "", (word.charAt(0) + "").toUpperCase());
		 * standardizedStr += word + " "; } standardizedStr = standardizedStr.trim();
		 * return standardizedStr;
		 */
		//Cach 2
		String newS ="";
		for(int i = 0; i<str.length(); i++) {
			String c = str.substring(i, i + 1);
			if(i == 0 || str.substring(i-1,i).compareTo(" ") == 0) {
				newS += c.toUpperCase();
			}
			else {
				newS += c.toLowerCase();
			}
		}
		return newS;
	}
	public static float convertNumberStringToFloat(String numberString) {
		try {
			float number = 0;
			number =Float.parseFloat(numberString);
			return number;
		} catch(Exception e) {
			System.out.println("An error occured.");
			e.printStackTrace();
		}
		return 0;
	}
	public static String standardizeID(String str) {
		str = standardize(str);
		if(str.length() == 5) {
			//Cach 1
			 //if(Character.isLetter(str.charAt(0)) &&
			//		 Character.isLetter(str.charAt(1)) &&
				//			 Character.isDigit(str.charAt(2)) &&
				//					 Character.isDigit(str.charAt(3)) &&
				//							 Character.isDigit(str.charAt(4))) {
				// return str;
			 //} else {
			//	 return "NA000";
			// }
			
			//Cach 2
			 //str = str.toUpperCase();
			//	char[] arrChar = str.toCharArray();
			// if((arrChar[0] < 'A' || arrChar[0] > 'Z') || 
			//		 (arrChar[1] < 'A' || arrChar[1] > 'Z') ||
			//		 (arrChar[2] < '0' || arrChar[2] > '9') ||
			//		 (arrChar[3] < '0' || arrChar[3] > '9') ||
			//		 (arrChar[4] < '0' || arrChar[4] > '9') ) {
			//	 return "NA000";
			// }
			// else return str;
			
			//Cach 3
			if(str.matches("[a-zA-z]{2}[0-9]{3}")) {
				return str;
			} else {
				return "NA000";
			}
		}
		else
			return "NA000";
	}
	public static int checkDate(int testDay, int month,int year)
	{
		int[] dayofMonth = { 0,31,28,31,30,31,30,31,31,30,31,30,31 };
		if (testDay > 0 && testDay <= dayofMonth[month])
			return testDay;
		if (month == 2 && testDay == 29 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))
			return testDay;
		return -1;
	}
	public static LocalDate standardizeDate(String str) {
		str = str.trim();
		String[] arrStr = str.split("-");
		if(arrStr.length == 3)
		{
			if(arrStr[0].length() == 2 && arrStr[1].length() == 2) {
				try {
					int day = Integer.parseInt(arrStr[0]);
					int month = Integer.parseInt(arrStr[1]);
					int year = Integer.parseInt(arrStr[2]);
					if(month < 0 || month >12) {
						return null;
					}
					else {
						if(checkDate(day, month, year) == -1) {
							return null;
						} 
						
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					LocalDate date = LocalDate.parse(str, formatter);
					return date;
				}
				} catch(Exception e) {
					System.out.println("An error occured.");
					e.printStackTrace();
					return null;
					
				}
			}
		}
		else
			return null;
		
		return null;
	}
	public static String standardizePhoneNumber(String str) {
		//str = str.trim();
		/*
		 * if (str.length() < 10 || str.length() > 12) { return ""; } else { int count =
		 * 0; //char[] arrChar = str.toCharArray(); for (int i = 0; i < str.length();
		 * i++) { if (str.charAt(i) == '.') { count++; } if (str.charAt(i) == '.') { if
		 * (str.charAt(i + 1) == '.') { return ""; } } } if (str.charAt(0) == '.' ||
		 * count > 2) { return null; } else { for (int i = 0; i < str.length(); i++) {
		 * if(str.charAt(i) == '.') { str = str.replaceAll(".", ""); } } char[]
		 * arrNewChar = str.toCharArray(); for (int i = 0; i < str.length(); i++) { if
		 * (Character.isDigit(str.charAt(i)) == false) { return ""; } } return str; } }
		 */
		if (str.length() == 0) {
			return "";
		} else {
			try {
				if (str.charAt(0) == '.' || str.length() > 12) {

					return "";
				} else {
					str = str.replace(".", "");
					if (str.matches("[0-9]{10}")) {
						return str;
					} else
						return "";
				}
			} catch (Exception e) {
				e.printStackTrace();
				return "";
			}
		}
	}

	public static String standardizeEmail(String str, String id) {
		/*
		 * str = str.trim(); String[] arrStr = str.split("\\."); String[] arrStrC
		 * =arrStr[0].split("\\@"); if(arrStr.length == 2 && arrStrC.length ==2) {
		 * if(arrStr[1].length() > 0 && arrStrC[0].length() >0 && arrStrC[1].length() >
		 * 0) { str =str.toLowerCase(); return str; } } else { if(id == "NA000") {
		 * return ""; } else { id =id.toLowerCase(); return id +"@msita.edu"; } } return
		 * "";
		 */
		if(str.matches("[^@.\\s]{1,}+[@]{1}+[a-zA-Z]{1,}+[.]{1}+[a-zA-Z]{1,}")) {
			str =str.toLowerCase();
			return str;

		}else {
			if(id == "NA000") {
				return "";
			} else {
				id =id.toLowerCase();
				return id +"@msita.edu";
			}
		}
	}
	public static String formatDayOfBirth(LocalDate date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		String dateAfter=formatter.format(date);
		return dateAfter;
	}
	
}
