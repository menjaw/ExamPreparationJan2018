/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaControl;

import java.util.HashMap;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Menja
 */
public class CreateTables {

    public static void main(String[] args) {
        createSchemaWithScript();
        createSchemaPU();
        runEMF();
    }

    /*---------METHODS---------*/
    public static void createSchemaPU() {
        Persistence.generateSchema("PU", null);
    }

    public static void runEMF() {
        //Opretter og returnerer en EntityManagerFactory til den navngivne Persistence Unit
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU"); 
        emf.createEntityManager();
    }

    public static void createSchemaWithScript() {
        HashMap puProperty = new HashMap();
        puProperty.put("javax.persistence.sql-load-script-source", "scripts/CreateTables.sql");
        Persistence.generateSchema("PU", puProperty);

        puProperty.remove("javax.persistence.sql-load-script-source");
        Persistence.generateSchema("PU", puProperty);
    }
}
