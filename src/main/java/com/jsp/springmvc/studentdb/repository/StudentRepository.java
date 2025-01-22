package com.jsp.springmvc.studentdb.repository;

import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.jsp.springmvc.studentdb.entity.Student;

@Repository
public class StudentRepository {
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mysql-config");
	
	public void addStudent(Student student) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		entityManager.persist(student);
		
		transaction.commit();
		entityManager.close();
	}
	
	public List<Student> displayStudent() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
//		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//		CriteriaQuery<Student> query = criteriaBuilder.createQuery(Student.class);
//		Root<Student> from = query.from(Student.class);
//		
//		TypedQuery<Student> typedQuery = entityManager.createQuery(query);
//	    List<Student> resultList = typedQuery.getResultList();
		
		Query query = entityManager.createQuery("from Student");
		List resultList = query.getResultList();
	    
	    transaction.commit();
	    entityManager.close();
	    
	    return  resultList;
	    
	}
	
	public void updateStudent(Student student) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		entityManager.merge(student);
		
		
		transaction.commit();
		entityManager.close();
		
	}

	public Student findStudentById(int studentId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Student student = entityManager.find(Student.class, studentId);
		
		transaction.commit();
		entityManager.close();
		
		return student;
	}
	
	public void deleteStudent(int studentId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Student student = entityManager.find(Student.class, studentId);
		entityManager.remove(student);
		
		
		transaction.commit();
		entityManager.close();
		
	}
}
