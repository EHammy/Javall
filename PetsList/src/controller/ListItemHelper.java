package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListItem;

public class ListItemHelper{
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PetsList");
	
	
	public void cleanUp(){
		emfactory.close();
	}
	
	public void deleteItem(ListItem toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.name = :selectedName and li.breed = :selectedBreed and li.weight = :selectedWeight", ListItem.class);
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedBreed", toDelete.getBreed());
		typedQuery.setParameter("selectedWeight", toDelete.getWeight());
		typedQuery.setMaxResults(1);
		ListItem result = typedQuery.getSingleResult();
		em.remove(result);
		
		em.getTransaction().commit();
		em.close();
		
	}
	
//Continue Editing Here
	
	public void insertItem(ListItem li){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	//search by name

	public List<ListItem> searchForPetByName(String petName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.item = :selectedName", ListItem.class);
		typedQuery.setParameter("selectedItem", petName);

		List<ListItem> foundPets = typedQuery.getResultList();
		em.close();
		return foundPets;
	}
//search by breed
	public List<ListItem> searchForPetByBreed(String petBreed) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.store = :selectedBreed", ListItem.class);
		typedQuery.setParameter("selectedBreed", petBreed);

		List<ListItem> foundPets = typedQuery.getResultList();
		em.close();
		return foundPets;
		
	}
	
	//search by weight
	public ListItem searchForPetByWeight(ListItem weightToEdit){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListItem found = em.find(ListItem.class, weightToEdit);
		em.close();
		return found;
	}

	public List<ListItem> showAllPets(){
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li", ListItem.class);
		List<ListItem> allPets = typedQuery.getResultList();
		em.close();
		return allPets;
	}
	
	//

	public void updatePet(ListItem toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	

}
