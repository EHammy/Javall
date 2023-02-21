package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListPet;

public class ListPetHelper{
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PetsList");
	
	
	public void cleanUp(){
		emfactory.close();
	}
	
	public void deletePet(ListPet toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListPet> typedQuery = em.createQuery("select li from ListPet li where li.name = :selectedName and li.breed = :selectedBreed and li.weight = :selectedWeight", ListPet.class);
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedBreed", toDelete.getBreed());
		typedQuery.setParameter("selectedWeight", toDelete.getWeight());
		typedQuery.setMaxResults(1);
		ListPet result = typedQuery.getSingleResult();
		em.remove(result);
		
		em.getTransaction().commit();
		em.close();
		
	}
	
//Continue Editing Here
	
	public void insertPet(ListPet li){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	//search by name

	public List<ListPet> searchForPetByName(String petName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListPet> typedQuery = em.createQuery("select li from ListPet li where li.pet = :selectedName", ListPet.class);
		typedQuery.setParameter("selectedPet", petName);

		List<ListPet> foundPets = typedQuery.getResultList();
		em.close();
		return foundPets;
	}
//search by breed
	public List<ListPet> searchForPetByBreed(String petBreed) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListPet> typedQuery = em.createQuery("select li from ListPet li where li.store = :selectedBreed", ListPet.class);
		typedQuery.setParameter("selectedBreed", petBreed);

		List<ListPet> foundPets = typedQuery.getResultList();
		em.close();
		return foundPets;
		
	}
	
	//search by weight
	public ListPet searchForPetByWeight(ListPet weightToEdit){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListPet found = em.find(ListPet.class, weightToEdit);
		em.close();
		return found;
	}

	public List<ListPet> showAllPets(){
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<ListPet> typedQuery = em.createQuery("select li from ListPet li", ListPet.class);
		List<ListPet> allPets = typedQuery.getResultList();
		em.close();
		return allPets;
	}
	
	//

	public void updatePet(ListPet toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	

}
