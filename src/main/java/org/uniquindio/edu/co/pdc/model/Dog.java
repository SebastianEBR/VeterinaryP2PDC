package org.uniquindio.edu.co.pdc.model;

public class Dog extends Pet implements IpetAction{

    private Dog(Builder builder){
        super(builder);
    }

    @Override
    public void eat(){
        System.out.println("eating");
    }

    @Override
    public void sleep(){
        System.out.println("sleeping");
    }

    @Override
    public void sound(){
        System.out.println("wao, guao");
    }


    public static class Builder extends Pet.Builder<Builder>{

        @Override
        protected Builder self(){return this;}

        @Override
        public Dog build(){
            return new Dog(this);
        }
    }

    
}
