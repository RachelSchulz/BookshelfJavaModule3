package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Book;


public class BookHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Bookshelf");
	
	public void insertBook(Book toAdd) {
		EntityManager manager = emfactory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(toAdd);
		manager.getTransaction().commit();
		manager.close();
	}
	

	public void removeBook(Book toDelete) {
		EntityManager manager = emfactory.createEntityManager();
		manager.getTransaction().begin();
		manager.remove(manager.find(Book.class, toDelete.getId()));
		manager.getTransaction().commit();
		manager.close();
		
	}
	
	public void updateBook(Book toUpdate) {
		EntityManager manager = emfactory.createEntityManager();
		Book dbEntity = manager.find(Book.class, toUpdate.getId());
		manager.getTransaction().begin();
		dbEntity.setAuthor(toUpdate.getAuthor());
		dbEntity.setTitle(toUpdate.getTitle());
		manager.getTransaction().commit();
		manager.close();
		
	}
	
	public List<Book> showAllItems() {
		EntityManager manager = emfactory.createEntityManager();
		List<Book> allItems = manager.createQuery("SELECT i FROM	Book i").getResultList();
		return	allItems;
	}
}
