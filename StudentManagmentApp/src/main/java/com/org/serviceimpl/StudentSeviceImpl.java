package com.org.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.Repository.StudentRepository;
import com.org.model.Student;
import com.org.service.StudentService;
@Service
public class StudentSeviceImpl implements StudentService {
 @Autowired
 StudentRepository sr;
	@Override
	public void saveStudentDetails(Student s) {
		sr.save(s);
		
		
	}
	@Override
	public List<Student> getAllStudents() {
		return (List<Student>)sr.findAll();
	}
	@Override
	public List<Student> searchBatch(String batchNumber) {
		
		return sr.findAllByBatchNumber(batchNumber);
	}
	@Override
	public Student getSingleStudent(int id) {
		
		return sr.findById(id).get();
	}
	@Override
	public List<Student> updateStudentfees(int studentid, float ammount) {
		Student s =sr.findById(studentid).get();
		float paidfees=Float.parseFloat(s.getFeesPaid())+ammount;
		
		s.setFeesPaid(String.valueOf(paidfees));
		sr.save(s);
		return (List<Student>) sr.findAll();
	}
	@Override
	public void removeDelete(int id) {
		sr.deleteById(id);
		
	}

}
