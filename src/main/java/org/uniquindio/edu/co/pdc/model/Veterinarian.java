package org.uniquindio.edu.co.pdc.model;

public class Veterinarian extends Person{


    private Veterinarian(Builder builder){
        super(builder);
    }

    public static class Builder extends Person.Builder<Builder>{

        @Override
        protected Builder self(){return this;}

        @Override
        public Veterinarian build(){
            return new Veterinarian(this);
        }
    }
}
