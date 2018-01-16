/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Pet;
import java.util.List;

/**
 *
 * @author Menja
 */
public class JsonConverter {
    
       GsonBuilder builder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
       Gson gson = builder.create();

    public Pet getPetFromJson(String js) {
        return gson.fromJson(js, Pet.class);
    }

    public String getJSONFromPet(Pet c) {
        return gson.toJson(c);       
    }

    public String getJSONFromPets(List<Pet> pets) {      
        return gson.toJson(pets);       
    }
}
