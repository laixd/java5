package com.lai.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lai.model.RecordsModel;
import com.lai.thongke.nhanvien;
import com.lai.thongke.phongBan;


@Repository
public interface RecordsRepository extends CrudRepository<RecordsModel, String> {
	@Query(value="Select b.staffsName as tennhanvien , c.departsName as tenphongban, b.Photo as hinh,count (case when (a.type) = 'true' then 1 else null end) as thanhtich, count (case when (a.type) = 'false' then 1 else null end) as kyluat\r\n" + 
			"			From Records a inner join Staffs b on a.StaffId = b.staffsID inner join\r\n" + 
			"			Departs c on b.departId = c.departID group by b.staffsName, c.departsName, b.Photo", nativeQuery=true)
	
	List<nhanvien> fetchRecordEmp();
		
	@Query(value="Select tenphongban, Sum (thanhtich) as tongthanhtich, Sum (kyluat) as tongkyluat From (Select b.staffsName as tennhanvien, c.departsName as tenphongban,\r\n" + 
			"			 c.departID as maphongban, count (case when (a.type) = 'true' then 1 else null end) as thanhtich, count (case when (a.type) = 'false' then 1 else null end) as kyluat\r\n" + 
			"			 From records a inner join staffs b on a.staffId = b.staffsID inner join departs c on b.departId = c.departID group by b.staffsName, c.departsName, c.departID) as BangPhu group by maphongban, tenphongban",
			nativeQuery=true)
	List<phongBan> fillThanhtich();
}
