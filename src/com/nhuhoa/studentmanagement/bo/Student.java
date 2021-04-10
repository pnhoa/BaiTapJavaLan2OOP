package com.nhuhoa.studentmanagement.bo;

import java.time.LocalDate;

public class Student implements Comparable<Student> {
	private String id;
	private String name;
	private LocalDate dateOfBirth;
	private String city;
	private String phoneNumber;
	private String email;
	private float score;
	public Student(String id, String name, LocalDate dateOfBirth, String city, String phoneNumber, String email,float score) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.city = city;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.score = score;
	}
	public Student() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	
	public int compareTo(Student st) {
		// TODO Auto-generated method stub
		return this.id.compareToIgnoreCase(st.id);
	}
	
}
