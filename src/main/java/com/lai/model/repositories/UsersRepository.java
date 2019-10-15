package com.lai.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lai.model.UsersModel;

@Repository
public interface UsersRepository extends CrudRepository<UsersModel, String> {

}
