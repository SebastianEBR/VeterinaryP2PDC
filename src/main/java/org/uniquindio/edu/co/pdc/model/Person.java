package org.uniquindio.edu.co.pdc.model;


public abstract class Person{

    protected String name;
    protected String id;
    protected String address;
    protected String phone;
    
    protected Person(Builder<?> builder){
        this.name = builder.name;
        this.id = builder.id;
        this.address = builder.address;
        this.phone = builder.phone;
    }

    //getters and setters
    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public String getAddress() {return address;}

    public void setAddress(String address) {this.address = address;}

     public String getPhone() {return phone;}

    public void setPhone(String phone) {this.phone = phone;}



    @Override
    public String toString() {
        return "Veterinary [name=" + name + ", Id=" + id + ", address=" + address;
    }

    public abstract static class Builder<T extends Builder<T>>{
        private String name;
        private String id;
        private String address;
        private String phone;

        public T name(String name){
            this.name = name;
            return self();
        }

        public T id(String id){
            this.id = id;
            return self();
        }

        public T address(String address){
            this.address = address;
            return self();
        }

        public T phone(String phone){
            this.phone = phone;
            return self();
        }

        protected abstract T self();
        abstract Veterinarian build();
    }
}