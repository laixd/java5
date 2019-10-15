package com.lai.model.services;

import java.util.List;
import java.util.Optional;

import com.lai.model.DepartsModel;
import com.lai.model.StaffsModel;

public interface StaffsExServices {

	void deleteAll();

	void deleteAll(Iterable<? extends StaffsModel> entities);

	void delete(StaffsModel entity);

	void deleteById(String id);

	long count();

	Iterable<StaffsModel> findAllById(Iterable<String> ids);

	Iterable<StaffsModel> findAll();

	boolean existsById(String id);

	Optional<StaffsModel> findById(String id);

	<S extends StaffsModel> Iterable<S> saveAll(Iterable<S> entities);

	<S extends StaffsModel> S save(S entity);

	List<StaffsModel> findAllByDepartID(DepartsModel departsModel);

}
