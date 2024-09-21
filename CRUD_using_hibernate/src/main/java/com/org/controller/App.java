package com.org.controller;

import java.util.Scanner;

import com.org.dao.StudentDao;
import com.org.dto.Student;

public class App {
	public static void main(String[] args) {
		System.out.println("** WELCOME TO HOMEPAGE");
		StudentDao dao = new StudentDao();
		Student std=new Student();
		Scanner sc= new Scanner(System.in);
		int userChoice;
		do {
		System.out.println("1.create student");
		System.out.println("2.fetch student");
		System.out.println("3.remove student");
		System.out.println("4.update student");
		System.out.println("5.exit");
		System.out.println("choose your choice");
		
		 userChoice= sc.nextInt();
		
		switch(userChoice) {
		case 1:
			System.out.println("Enter Student id: ");
			int id= sc.nextInt();
			System.out.println("Enter Student name: ");
			String name= sc.next();
			System.out.println("Enter Student age: ");
			int age= sc.nextInt();
			System.out.println("Enter Student email: ");
			String email= sc.next();
			System.out.println("Enter Student password: ");
			String password= sc.next();
			
			
			
			std.setId(id);
			std.setName(name);
			std.setAge(age);
			std.setEmail(email);
			std.setPassword(password);
			
			dao.insertStudent(std);
			break;
			
		case 2:
			System.out.println("Enter student id to see details:");
			int fetchId= sc.nextInt();
			
			dao.fetchStudentById(fetchId);
			break;
			
		case 3:
			System.out.println("Enter student id to remove:");
			int deleteId= sc.nextInt();
			
			dao.removeStudentById(deleteId);
			break;
		case 4:
			System.out.println("Enter student id to update:");
			int updateId= sc.nextInt();
			std.setId(updateId);
			System.out.println("Enter your name: ");
			String updataName= sc.next();
			System.out.println("Enter your age:");
			int updateAge= sc.nextInt();
			System.out.println("Enter your Email:");
			String updateEmail= sc.next();
			System.out.println("Enter your password:");
			String updatePassword= sc.next();
			
			std.setName(updataName);
			std.setAge(updateAge);
			std.setEmail(updateEmail);
			std.setPassword(updatePassword);
			
			
			
			dao.updateStudent(std);
			break;
		}
		}
		while(userChoice!= 5);
		System.out.println("thank you");
		sc.close();
	}
}
