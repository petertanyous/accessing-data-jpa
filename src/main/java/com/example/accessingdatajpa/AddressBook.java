package com.example.accessingdatajpa;
import jakarta.persistence.*;

import java.util.*;
//this is to test commit and push
@Entity
public class AddressBook {
    @Id
    @GeneratedValue
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BuddyInfo> budds;

    public AddressBook() {
        budds = new ArrayList<>();
    }
    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void addBuddy(BuddyInfo homie) {
        budds.add(homie);
    }

    public void removeBuddy(String exHomie) {
        for (int i = 0; i < budds.size(); i++) {
            if ((budds.get(i)).getName().equals(exHomie)) {
                budds.remove(i);
            }
        }
    }
    //    public String getAllNames(){
//        String result ="";
//        String m;
//        for(int i = 0; i < budds.size(); i++){
//            m = (  budds.get(i).getName() + "  " + budds.get(i).getNumber() + ',');
//            result = m + result;
//        }
//        return result;
//    }

    public List<BuddyInfo> getBudds(){
        return this.budds;
    }
    public void setBudds(List<BuddyInfo> budds){
        this.budds = budds;
    }
    @Override
    public String toString(){
        String s = "";
        for (int i = 0; i < budds.size(); i++) {
            s = s + (budds.get(i) + " \n");
        }
        return s;
    }

//    public static void main(String[] args){
//
//
//        BuddyInfo buddy = new BuddyInfo("Tom", "6138793901" ) ;
//        BuddyInfo buddy2 = new BuddyInfo("peter" , "61353454" );
//        AddressBook addressBook = new AddressBook();
//        addressBook.addBuddy(buddy);
//        addressBook.addBuddy(buddy2);
//        System.out.println(addressBook.getAllNames());
//
//    }
}
