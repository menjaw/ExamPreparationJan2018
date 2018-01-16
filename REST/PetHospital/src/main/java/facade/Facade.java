/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Pet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Menja
 */
public class Facade {

    private EntityManagerFactory emf;
    private EntityManager em;

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.initiateSystem();
        
        //Run methods
        facade.getAllPets();
    }

    public void addEntityManagerFacotry(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public void initiateSystem() {
        Persistence.generateSchema("PU", null);
        emf = Persistence.createEntityManagerFactory("PU");
        em = emf.createEntityManager();

    }

    public void getAllPets() {
        List<Pet> pets = new ArrayList();
        pets = em.createNamedQuery("Pet.findAll").getResultList();
        for (Pet pet : pets) {
            System.out.println(pet.toString());
        }

    }

}
