package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListStudent;

public class ListStudentHelper{
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("AttendanceManagement");
	
	
	public void cleanUp(){
		emfactory.close();
	}
	
	public void deleteStudent(ListStudent toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListStudent> typedQuery = em.createQuery("select li from ListStudent li where li.student = :selectedStudent and li.Attendance = :selectedAttendance", ListStudent.class);
		typedQuery.setParameter("selectedStudent", toDelete.getStudent());
		typedQuery.setParameter("selectedAttendance", toDelete.getAttendance());
		typedQuery.setMaxResults(1);
		ListStudent result = typedQuery.getSingleResult();
		em.remove(result);
		
		em.getTransaction().commit();
		em.close();
		
	}
	

	
	public void insertStudent(ListStudent li){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}

	public List<ListStudent> searchForStudentByStudent(String Student) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListStudent> typedQuery = em.createQuery("select li from ListStudent li where li.Student = :selectedStudent", ListStudent.class);
		typedQuery.setParameter("selectedStudent", Student);

		List<ListStudent> foundStudents = typedQuery.getResultList();
		em.close();
		return foundStudents;
	}

	public List<ListStudent> searchForStudentByAttendance(String Attendance) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListStudent> typedQuery = em.createQuery("select li from ListStudent li where li.Attendance = :selectedAttendance", ListStudent.class);
		typedQuery.setParameter("selectedAttendance", Attendance);

		List<ListStudent> foundStudents = typedQuery.getResultList();
		em.close();
		return foundStudents;
		
	}
	
	public ListStudent searchForStudentById(int id){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListStudent found = em.find(ListStudent.class, id);
		em.close();
		return found;
	}

	public List<ListStudent> showAllStudents(){
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<ListStudent> typedQuery = em.createQuery("select li from ListStudent li", ListStudent.class);
		List<ListStudent> allStudents = typedQuery.getResultList();
		em.close();
		return allStudents;
	}

	public void updateStudent(ListStudent toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

}
