package com.lai.model.services.imlp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lai.model.UsersModel;
import com.lai.model.repositories.UsersRepository;
import com.lai.model.services.UsersExServices;


@Service
public class UsersExServicesimpl implements UsersExServices {
@Autowired UsersRepository UsersRepository;

@Override
public <S extends UsersModel> S save(S entity) {
	return UsersRepository.save(entity);
}

@Override
public <S extends UsersModel> Iterable<S> saveAll(Iterable<S> entities) {
	return UsersRepository.saveAll(entities);
}

@Override
public Optional<UsersModel> findById(String id) {
	return UsersRepository.findById(id);
}

@Override
public boolean existsById(String id) {
	return UsersRepository.existsById(id);
}

@Override
public Iterable<UsersModel> findAll() {
	return UsersRepository.findAll();
}

@Override
public Iterable<UsersModel> findAllById(Iterable<String> ids) {
	return UsersRepository.findAllById(ids);
}

@Override
public long count() {
	return UsersRepository.count();
}

@Override
public void deleteById(String id) {
	UsersRepository.deleteById(id);
}

@Override
public void delete(UsersModel entity) {
	UsersRepository.delete(entity);
}

@Override
public void deleteAll(Iterable<? extends UsersModel> entities) {
	UsersRepository.deleteAll(entities);
}

@Override
public void deleteAll() {
	UsersRepository.deleteAll();
}
}
