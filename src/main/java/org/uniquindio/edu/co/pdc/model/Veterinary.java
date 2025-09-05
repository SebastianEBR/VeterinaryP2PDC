package org.uniquindio.edu.co.pdc.model;


public class Veterinary{

    private String name;
    private String nit;
    private String address;
    
    private Veterinary(Builder builder){
        this.name = builder.name;
        this.nit = builder.nit;
        this.address = builder.address;
    }

    //getters and setters
    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getNit() {return nit;}

    public void setNit(String nit) {this.nit = nit;}

    public String getAddress() {return address;}

    public void setAddress(String address) {this.address = address;}



    @Override
    public String toString() {
        return "Veterinary [name=" + name + ", nit=" + nit + ", address=" + address;
    }

    public static class Builder{
        private String name;
        private String nit;
        private String address;

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder nit(String nit){
            this.nit = nit;
            return this;
        }

        public Builder address(String address){
            this.address = address;
            return this;
        }

        public Veterinary build(){
            return new Veterinary(this);
        }
    }
}