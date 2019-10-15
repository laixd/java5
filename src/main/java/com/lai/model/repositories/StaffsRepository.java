package com.lai.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lai.model.DepartsModel;
import com.lai.model.StaffsModel;

@Repository
public interface StaffsRepository  extends CrudRepository<StaffsModel, String>{
	List<StaffsModel> findAllByDepartID(DepartsModel departsModel); 
}
