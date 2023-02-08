package com.example.accessingdatajpa;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AddressBookController {

    @Autowired
    private AddressBookRepository AddressBookRepository;
    @PostMapping("/AddressBook")
    @ResponseBody
    public AddressBook AddressBook(){

        AddressBook newAddressBook = new AddressBook();
        AddressBookRepository.save(newAddressBook);
        return newAddressBook;
    }
    @GetMapping(value = "/viewAddressBook")
    public String viewAddressBook(@RequestParam(value = "address-id", required = true) int addressId, Model model){

        model.addAttribute("budds", AddressBookRepository.findAddressBookById(addressId).getBudds());
        return "BuddyInfo";
    }
}
//package com.example.accessingdatajpa;
//        import java.util.concurrent.atomic.AtomicLong;
//
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.web.bind.annotation.GetMapping;
//        import org.springframework.web.bind.annotation.PostMapping;
//        import org.springframework.web.bind.annotation.RequestParam;
//        import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class BuddyInfoController {
//    private static final String template = "Hello, %s!";
//    private final AtomicLong counter = new AtomicLong();
//    @Autowired
//    private AddressBookRepository AddressBookRepository;
//    @PostMapping("/BuddyInfo")
//    public BuddyInfo BuddyInfo(@RequestParam(value = "name") String name, @RequestParam(value = "number") String number, @RequestParam(value = "AddressBookId") Integer id){
//        BuddyInfo buddyInfo = new BuddyInfo(name, number);
//        AddressBookRepository.getAddressBookById(id).addBuddy(buddyInfo);
//        AddressBookRepository.save(AddressBookRepository.getAddressBookById(id));
//        return buddyInfo;
//    }
//    @PostMapping("/RemoveBuddy")
//    public void RemoveBuddy(@RequestParam (value = "buddyName") String budname, @RequestParam (value = "AddressBookId") Integer aID){
//        AddressBookRepository.getAddressBookById(aID).removeBuddy(budname);
//    }
//}