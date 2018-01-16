/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entity.Book;
import entity.EBook;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Menja
 */
public class Facade {

    private EntityManagerFactory emf;

    public Facade() {

    }

    public void addEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void addBook(EBook eBook) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();//Return the resource-level EntityTransaction object.
            em.persist(eBook); //Indsætter 
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Book editBook(EBook eBook) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Book b = em.find(EBook.class, eBook.getId());
            if (b != null) {
                b = eBook;
                em.merge(b);
                em.getTransaction().commit();
                return b;
            }
        } finally {
            em.close();
        }
        return null;
    }

}
