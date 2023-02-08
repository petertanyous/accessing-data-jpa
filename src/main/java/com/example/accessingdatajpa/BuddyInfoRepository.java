package com.example.accessingdatajpa;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long>{

    BuddyInfo getBuddyInfoById(Integer id);

}
