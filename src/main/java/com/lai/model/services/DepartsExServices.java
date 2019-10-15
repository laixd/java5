package com.lai.model.services;

import java.util.Optional;

import com.lai.model.DepartsModel;

public interface DepartsExServices {

	void deleteAll();

	void deleteAll(Iterable<? extends DepartsModel> entities);

	void delete(DepartsModel entity);

	void deleteById(String id);

	long count();

	Iterable<DepartsModel> findAllById(Iterable<String> ids);

	Iterable<DepartsModel> findAll();

	boolean existsById(String id);

	Optional<DepartsModel> findById(String id);

	<S extends DepartsModel> Iterable<S> saveAll(Iterable<S> entities);

	<S extends DepartsModel> S save(S entity);

}
