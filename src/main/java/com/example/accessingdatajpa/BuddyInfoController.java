package com.example.accessingdatajpa;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuddyInfoController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    private AddressBookRepository AddressBookRepository;
    @PostMapping("/BuddyInfo")
    public BuddyInfo BuddyInfo(@RequestParam(value = "name") String name, @RequestParam(value = "number") String number, @RequestParam(value = "AddressBookId") Integer id){
        BuddyInfo buddyInfo = new BuddyInfo(name, number);
        AddressBookRepository.findAddressBookById(id).addBuddy(buddyInfo);
        AddressBookRepository.save(AddressBookRepository.findAddressBookById(id));
        return buddyInfo;
    }
    @PostMapping("/RemoveBuddy")
    public void RemoveBuddy(@RequestParam (value = "buddyName") String budname, @RequestParam (value = "AddressBookId") Integer aID){
        AddressBookRepository.findAddressBookById(aID).removeBuddy(budname);
    }
}
