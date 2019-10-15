package com.lai.model.services.imlp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lai.model.DepartsModel;
import com.lai.model.StaffsModel;
import com.lai.model.repositories.StaffsRepository;
import com.lai.model.services.StaffsExServices;

@Service
public class StaffsExServicesimpl implements  StaffsExServices {
	@Autowired StaffsRepository StaffsRepository;


	@Override
	public List<StaffsModel> findAllByDepartID(DepartsModel departsModel) {
		return StaffsRepository.findAllByDepartID(departsModel);
	}

	@Override
	public <S extends StaffsModel> S save(S entity) {
		return StaffsRepository.save(entity);
	}

	@Override
	public <S extends StaffsModel> Iterable<S> saveAll(Iterable<S> entities) {
		return StaffsRepository.saveAll(entities);
	}

	@Override
	public Optional<StaffsModel> findById(String id) {
		return StaffsRepository.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return StaffsRepository.existsById(id);
	}

	@Override
	public Iterable<StaffsModel> findAll() {
		return StaffsRepository.findAll();
	}

	@Override
	public Iterable<StaffsModel> findAllById(Iterable<String> ids) {
		return StaffsRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return StaffsRepository.count();
	}

	@Override
	public void deleteById(String id) {
		StaffsRepository.deleteById(id);
	}

	@Override
	public void delete(StaffsModel entity) {
		StaffsRepository.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends StaffsModel> entities) {
		StaffsRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		StaffsRepository.deleteAll();
	}

}
