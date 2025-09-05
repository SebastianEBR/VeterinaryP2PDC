package org.uniquindio.edu.co.pdc.model;

public abstract class Pet {
    
    protected String id;
    protected String name;
    protected int    age;
    protected String race;

    protected Pet(Builder<?> builder){
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
        this.race = builder.race;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    @Override
    public String toString() {
        return "Pet [id=" + id + ", name=" + name + ", age=" + age + ", race=" + race + "]";
    }

    public abstract static class Builder<T extends Builder<T>>{

        private String id;
        private String name;
        private int    age;
        private String race;

        public T id(String id){
            this.id = id;
            return self();
        }

        public T name(String name){
            this.name = name;
            return self();
        }

        public T age(int age){
            this.age = age;
            return self();
        }

        public T race(String race){
            this.race = race;
            return self();
        }

        protected abstract T self();
        
        public abstract Pet build();
    }
}
