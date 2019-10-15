package com.lai.model.services.imlp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lai.model.DepartsModel;
import com.lai.model.repositories.DepartsRepository;
import com.lai.model.services.DepartsExServices;

@Service
public class DepartsExServicesimpl implements DepartsExServices{
	@Autowired DepartsRepository departsRepository;

	@Override
	public <S extends DepartsModel> S save(S entity) {
		return departsRepository.save(entity);
	}

	@Override
	public <S extends DepartsModel> Iterable<S> saveAll(Iterable<S> entities) {
		return departsRepository.saveAll(entities);
	}

	@Override
	public Optional<DepartsModel> findById(String id) {
		return departsRepository.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return departsRepository.existsById(id);
	}

	@Override
	public Iterable<DepartsModel> findAll() {
		return departsRepository.findAll();
	}

	@Override
	public Iterable<DepartsModel> findAllById(Iterable<String> ids) {
		return departsRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return departsRepository.count();
	}

	@Override
	public void deleteById(String id) {
		departsRepository.deleteById(id);
	}

	@Override
	public void delete(DepartsModel entity) {
		departsRepository.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends DepartsModel> entities) {
		departsRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		departsRepository.deleteAll();
	}
}
