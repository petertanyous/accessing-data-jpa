package com.example.accessingdatajpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BuddyInfo {


    @Id
    @GeneratedValue
    private Integer id = null;
    private String name;
    private String number;

    public BuddyInfo(){

    }

    public  BuddyInfo(String name, String number) {
        this.name = name;
        this.number = number;
    }
    public void setId(Integer id) {

        this.id = id;
    }

    public Integer getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setNumber(String number){
        this.number = number;
    }
    public String getName() {
        return name;
    }
    public String getNumber() {
        return number;
    }
    @Override
    public String toString(){
        return String.format(
                "Buddy[id=%d, name='%s', number='%s']",
                        id, name, number);
    }
//    public static void main(String[] args) {
//        BuddyInfo buddy = new BuddyInfo("homer", "6138793901");
//
//        System.out.println("Hello " + buddy.getName()) ;
//    }
}