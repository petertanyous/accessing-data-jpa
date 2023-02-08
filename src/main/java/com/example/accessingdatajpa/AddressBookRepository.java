package com.example.accessingdatajpa;

import org.springframework.data.repository.CrudRepository;

public interface AddressBookRepository extends CrudRepository<AddressBook, Integer> {
    //AddressBook getAddressBookById(Integer id);
    AddressBook findAddressBookById(Integer id);
}
