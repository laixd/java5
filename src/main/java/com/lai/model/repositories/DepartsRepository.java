package com.lai.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lai.model.DepartsModel;

@Repository
public interface DepartsRepository extends CrudRepository<DepartsModel, String> {

}
