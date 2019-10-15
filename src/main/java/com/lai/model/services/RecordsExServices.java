package com.lai.model.services;

import java.util.List;
import java.util.Optional;

import com.lai.model.RecordsModel;
import com.lai.thongke.nhanvien;
import com.lai.thongke.phongBan;

public interface RecordsExServices {

	void deleteAll();

	void deleteAll(Iterable<? extends RecordsModel> entities);

	void delete(RecordsModel entity);

	void deleteById(String id);

	long count();

	Iterable<RecordsModel> findAllById(Iterable<String> ids);

	Iterable<RecordsModel> findAll();

	boolean existsById(String id);

	Optional<RecordsModel> findById(String id);

	<S extends RecordsModel> Iterable<S> saveAll(Iterable<S> entities);

	<S extends RecordsModel> S save(S entity);

	List<nhanvien> fetchRecordEmp();

	List<phongBan> fillThanhtich();

}
