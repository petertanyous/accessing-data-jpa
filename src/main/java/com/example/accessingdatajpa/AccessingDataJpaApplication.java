package com.example.accessingdatajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

	private  static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(AccessingDataJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BuddyInfoRepository repository, AddressBookRepository addrepo) {
		return (args) -> {
			// save a few customers
			BuddyInfo Jack =new BuddyInfo("Jack", "1111");
			BuddyInfo Chloe = new BuddyInfo("Chloe", "2222");
			BuddyInfo Kim = new BuddyInfo("Kim", "3333");
//			repository.save(Jack);
//			repository.save(Chloe);
//			repository.save(Kim);

			AddressBook book1 = new AddressBook();
//			book1.setId(4);
			AddressBook book2 = new AddressBook();
//			book2.setId(5);
//
			book1.addBuddy(Jack);
			book1.addBuddy(Chloe);
			book2.addBuddy(Kim);
//
			addrepo.save(book1);
			addrepo.save(book2);


			//fetch all buddies
			log.info("Buddies found with findAll():");
			log.info("-------------------------------");
			for (BuddyInfo buddy : repository.findAll()) {
				log.info(buddy.toString());
			}
			log.info("");

			//fetch buddies by ID
			BuddyInfo buddy = repository.getBuddyInfoById(1);
			log.info("Customer found with findById(1):");
			log.info("--------------------------------");
			log.info(buddy.toString());
			log.info("");

			//fetch all buddies
			log.info("AdressBooks found with findAll():");
			log.info("-------------------------------");
			for (AddressBook book : addrepo.findAll()) {
				log.info(buddy.toString());
			}
			log.info("");
		};

	}


}
