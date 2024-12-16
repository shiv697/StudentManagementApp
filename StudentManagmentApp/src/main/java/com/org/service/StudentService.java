package com.org.service;

import java.util.List;

import com.org.model.Student;

public interface StudentService {
	public void saveStudentDetails(Student s);
	public List<Student> getAllStudents();
	public List<Student> searchBatch(String batchNumber);
	public Student getSingleStudent(int id);
	public List<Student> updateStudentfees(int studentid, float ammount);
	public void removeDelete(int id);
	//public List<Student>getBatches();
	public List<Student> updateStudentBatch(int studentid, String batchNumber);
	

}
