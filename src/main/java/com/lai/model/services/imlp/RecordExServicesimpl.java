package com.lai.model.services.imlp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lai.model.RecordsModel;
import com.lai.model.repositories.RecordsRepository;
import com.lai.model.services.RecordsExServices;
import com.lai.thongke.nhanvien;
import com.lai.thongke.phongBan;


@Service
public class RecordExServicesimpl implements RecordsExServices {
	@Autowired RecordsRepository recordsRepository;

	@Override
	public <S extends RecordsModel> S save(S entity) {
		return recordsRepository.save(entity);
	}

	@Override
	public List<phongBan> fillThanhtich() {
		return recordsRepository.fillThanhtich();
	}

	@Override
	public List<nhanvien> fetchRecordEmp() {
		return recordsRepository.fetchRecordEmp();
	}

	@Override
	public <S extends RecordsModel> Iterable<S> saveAll(Iterable<S> entities) {
		return recordsRepository.saveAll(entities);
	}

	@Override
	public Optional<RecordsModel> findById(String id) {
		return recordsRepository.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return recordsRepository.existsById(id);
	}

	@Override
	public Iterable<RecordsModel> findAll() {
		return recordsRepository.findAll();
	}

	@Override
	public Iterable<RecordsModel> findAllById(Iterable<String> ids) {
		return recordsRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return recordsRepository.count();
	}

	@Override
	public void deleteById(String id) {
		recordsRepository.deleteById(id);
	}

	@Override
	public void delete(RecordsModel entity) {
		recordsRepository.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends RecordsModel> entities) {
		recordsRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		recordsRepository.deleteAll();
	}
	
}
