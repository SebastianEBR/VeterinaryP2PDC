package org.uniquindio.edu.co.pdc.model;

public class PetFactory {

    public static Pet createPet(String type, String id, String name, int age, String race){
        switch(type.toUpperCase()){
            case "DOG": 
                return new Dog.Builder()
                        .id(id)
                        .name(name)
                        .age(age)
                        .race(race)
                        .build();
            case "CAT":
                return new Cat.Builder()
                        .id(id)
                        .name(name)
                        .age(age)
                        .race(race)
                        .build();
            default:
                throw new IllegalArgumentException("The type: " + type + " is not valid");
        }
    }
    
}
