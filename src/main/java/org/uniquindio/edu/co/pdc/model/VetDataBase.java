package org.uniquindio.edu.co.pdc.model;

import java.util.ArrayList;
import java.util.Optional;

public class VetDataBase {

    private static VetDataBase vetdbInstance;

    private ArrayList<Pet> pets;
    private ArrayList<Veterinarian> veterinarians;


    private VetDataBase() {
        this.pets = new ArrayList<>();
        this.veterinarians = new ArrayList<>();
    }

    public static VetDataBase getInstance(){
        if (vetdbInstance == null){
            vetdbInstance = new VetDataBase();
        }
        return vetdbInstance;
    }

    //CRUD pet

    public void addPet(Pet newPet){
        Optional<Pet> p = searchPet(newPet.getId());
        
        if (p.isPresent()){
            throw new IllegalArgumentException("The pet with ID: " + newPet.getId() + " exist.");
        } else{
            pets.add(newPet);
        }
    }

    public ArrayList<Pet> showPets(){
        return pets;
    }

    public void updatePet(Pet newPet){
        Optional<Pet> p = searchPet(newPet.getId());
        
        if (p.isPresent()){
            Pet petAux = p.get();
            petAux.setName(newPet.getName());
            petAux.setAge(newPet.getAge());
            petAux.setRace(newPet.getRace());
        } else {
            throw new IllegalArgumentException("The pet with ID: " + newPet.getId() + " dont exist.");
        }
    }

    public void deletePet(Pet Pet){
       Optional<Pet> p = searchPet(Pet.getId());

        if (p.isPresent()){
            pets.remove(p.get());
        } else{
           throw new IllegalArgumentException("The pet with ID: " + Pet.getId() + " dont exist.");
        }
    }


    // CRUD veterinarian
    public void addVet(Veterinarian newVet){
        veterinarians.add(newVet);
    }

    public String showVet(Veterinarian vet){
        String infoVet = "";
        Optional<Veterinarian> v = searchVet(vet.getId());

        if (v.isPresent()){
            infoVet = v.toString();
            return infoVet;
        } else{
            throw new IllegalArgumentException("The veterinarian with ID: " + vet.getId() + " dont exist.");
        }
    }


    public ArrayList<Veterinarian> showVets(){
        return veterinarians;
    }


    public void updateVet(Veterinarian newVet){
        Optional<Veterinarian> v = searchVet(newVet.getId());

        if (v.isPresent()){
            Veterinarian vetAux = v.get();
            vetAux.setName(newVet.getName());
            vetAux.setAddress(newVet.getAddress());
            vetAux.setPhone(newVet.getPhone());
        } else{
            throw new IllegalArgumentException("The veterinarian with ID: " + newVet.getId() + " dont exist.");
        }
    }

    public void deleteVet(String id){
        Optional<Veterinarian> v = searchVet(id);

        if (v.isPresent()){
            veterinarians.remove(v.get());
        } else{
            throw new IllegalArgumentException("The veterinarian with ID: " + id + " dont exist.");
        }
    }
    

    private Optional<Pet> searchPet(String id){
        return pets.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    private Optional<Veterinarian> searchVet(String id){
        return veterinarians.stream().filter(v -> v.getId().equals(id)).findFirst();
    }
    
}
