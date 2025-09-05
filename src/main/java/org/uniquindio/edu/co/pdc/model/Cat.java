package org.uniquindio.edu.co.pdc.model;

public class Cat extends Pet implements IpetAction{

    private Cat(Builder builder){
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
        System.out.println("miau, miau");
    }


    public static class Builder extends Pet.Builder<Builder>{

        @Override
        protected Builder self(){return this;}

        @Override
        public Cat build(){
            return new Cat(this);
        }
    }

    
}
