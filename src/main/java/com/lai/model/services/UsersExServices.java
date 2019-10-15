package com.lai.model.services;

import java.util.Optional;

import com.lai.model.UsersModel;

public interface UsersExServices {

	void deleteAll();

	void deleteAll(Iterable<? extends UsersModel> entities);

	void delete(UsersModel entity);

	void deleteById(String id);

	long count();

	Iterable<UsersModel> findAllById(Iterable<String> ids);

	Iterable<UsersModel> findAll();

	boolean existsById(String id);

	Optional<UsersModel> findById(String id);

	<S extends UsersModel> Iterable<S> saveAll(Iterable<S> entities);

	<S extends UsersModel> S save(S entity);

}
