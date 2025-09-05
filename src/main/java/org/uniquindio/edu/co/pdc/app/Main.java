package org.uniquindio.edu.co.pdc.app;

import java.util.ArrayList;
import java.util.Scanner;

import org.uniquindio.edu.co.pdc.model.VetDataBase;
import org.uniquindio.edu.co.pdc.model.Pet;
import org.uniquindio.edu.co.pdc.model.PetFactory;
import org.uniquindio.edu.co.pdc.model.Veterinarian;

public class Main {

    static VetDataBase database = VetDataBase.getInstance();
    public static void main(String[] args) {
    
        principalMenu();
    }

    
    public static void principalMenu(){
        int op;

        do{
            System.out.println("****MENU****");
            System.out.println("1. Pets menu");
            System.out.println("2. Veterinarians menu");
            System.out.println("5. Exit");

            Scanner keyboard = new Scanner(System.in);
            System.out.println("Choose yor option: ");
            op = keyboard.nextInt();

            switch(op){
                case 1: petsMenu(database.showPets()); break;
                case 2: veterinarianMenu(database.showVets()); break;
            }
        }while(op != 5);
    }


    public static void petsMenu(ArrayList<Pet> pets){
        int op;

        do{
            System.out.println("****PETS MENU****");
            System.out.println("1. Show pets");
            System.out.println("2. add pets");
            System.out.println("3. Show only Schnauzer");
            System.out.println("4. count only Pincher");
            System.out.println("5. Exit");

            Scanner keyboard = new Scanner(System.in);
            System.out.println("ingrese su opcion: ");
            op = keyboard.nextInt();

            switch(op){
                case 1: showPets(pets); break;
                case 2: addPet(); break;
                case 3: showSchnauzer(pets); break;
                case 4: countPincher(pets); break;

            }
        }while(op != 5);
    }


    // methods

    public static Pet createPet(){
        Scanner keyboard = new Scanner(System.in);

        System.out.println("join the Type (CAT), (DOG); ");
        String type = keyboard.next();

        System.out.println("join the ID; ");
        String id = keyboard.next();
        System.out.println("join the name; ");
        String name = keyboard.next();
        System.out.println("join the age; ");
        int age = keyboard.nextInt();
        System.out.println("join the race; ");
        String race = keyboard.next();

        Pet pet = PetFactory.createPet(type, id, name, age, race);
        return pet;
    }


    public static void addPet(){
        Pet pet = createPet();
        database.addPet(pet);
    }


    public static void showPets(ArrayList<Pet> pets){
        for (Pet p : pets) {
            System.out.println(p.toString());
        }
    }


    public static void showSchnauzer(ArrayList<Pet> pets){
        for (Pet p : pets) {
            if (p.getRace().toLowerCase().equals("schnauzer")) {
                System.out.println(p.toString());
            }
        }
    }


    public static void countPincher(ArrayList<Pet> pets){
        int cPincher = 0;
        for (Pet p : pets) {
            if (p.getRace().toLowerCase().equals("pincher")) {
                cPincher ++;
            }
        }
        System.out.println("Hay " + cPincher + " pinchers");
    }



    // Veterinarian Menu
    public static void veterinarianMenu(ArrayList<Veterinarian> veterinarians){
        int op;

        do{
            System.out.println("****VETERINARIAN MENU****");
            System.out.println("1. Show vets");
            System.out.println("2. add veterinarian");
            System.out.println("3. Update veterinarian");
            System.out.println("4. Delete veterinarian");
            System.out.println("5. Exit");

            Scanner keyboard = new Scanner(System.in);
            System.out.println("ingrese su opcion: ");
            op = keyboard.nextInt();

            switch(op){
                case 1: showVets(veterinarians); break;
                case 2: addVet(); break;
                case 3: updateVet(); break;
                case 4: deleteVet(); break;

            }

        }while(op != 5);
    }


    
    public static Veterinarian createVet(){
        Scanner keyboard = new Scanner(System.in);

        System.out.println("join the ID; ");
        String id = keyboard.next();
        System.out.println("join the name; ");
        String name = keyboard.next();
        System.out.println("join the address; ");
        String address = keyboard.next();
        System.out.println("join the phone; ");
        String phone = keyboard.next();

        Veterinarian vet = new Veterinarian.Builder()
                .id(id)
                .name(name)
                .address(address)
                .phone(phone)
                .build();

        return vet;
    }


    public static void addVet(){
        Veterinarian vet = createVet();
        database.addVet(vet);
    }


    public static void showVets(ArrayList<Veterinarian> vets){
        for (Veterinarian v : vets) {
            System.out.println(v.toString());
        }
    }


    public static void updateVet(){
        Scanner keyboard = new Scanner(System.in);

        System.out.println("join the ID; ");
        String id = keyboard.next();
        System.out.println("join the new name; ");
        String name = keyboard.next();
        System.out.println("join the new address; ");
        String address = keyboard.next();
        System.out.println("join the new phone; ");
        String phone = keyboard.next();

        Veterinarian newVetAux = new Veterinarian.Builder()
                .id(id)
                .name(name)
                .address(address)
                .phone(phone)
                .build();

        database.updateVet(newVetAux);
    }

    //method to delete a veterinarian
    public static void deleteVet(){
        Scanner keyboard = new Scanner(System.in);

        System.out.println("join the ID; ");
        String id = keyboard.next();
        database.deleteVet(id);
    } 
}
