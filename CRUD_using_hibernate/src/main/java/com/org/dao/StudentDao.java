package com.org.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.org.dto.Student;

public class StudentDao {
	public void insertStudent(Student std) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("sujii");
		EntityManager em= emf.createEntityManager();
		EntityTransaction et= em.getTransaction();
		
		Student student =new Student();
		student.setId(std.getId());
		student.setName(std.getName());
		student.setAge(std.getAge());
		student.setEmail(std.getEmail());
		
		student.setPassword(std.getPassword());
		et.begin();
		em.persist(student);
		et.commit();
		System.out.println("data inserted successfully :-)");
		
		
	}
	
	public Student fetchStudentById(int id) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("sujii");
		EntityManager em= emf.createEntityManager();
		
		Student student=em.find(Student.class, id);
		System.out.println("student Id: "+ student.getId());
		System.out.println("student Name: "+ student.getName());
		System.out.println("student Age: "+ student.getAge());
		System.out.println("student Email: "+ student.getEmail());
		System.out.println("student Password: "+ student.getPassword());
		
		return student;
	}
	
	public Student removeStudentById(int id) {
		EntityManagerFactory emf=  Persistence.createEntityManagerFactory("sujii");
		EntityManager em= emf.createEntityManager();
		EntityTransaction et= em.getTransaction();
		et.begin();
		Student student= em.find(Student.class, id);
		em.remove(student);
		et.commit();
		System.out.println("data removed :(");
		
		return student;
	}
	
	public void updateStudent(Student std) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("sujii");
		EntityManager em= emf.createEntityManager();
		EntityTransaction et= em.getTransaction();
		


	et.begin();
	em.merge(std);
	et.commit();
	System.out.println("data updated successfully :-)");
	}
}
