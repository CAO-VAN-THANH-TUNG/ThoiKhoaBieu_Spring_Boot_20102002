package anhthanhtung.thoikhoabieuthanhtung.service;

import java.util.List;

import org.springframework.data.domain.Page;

import anhthanhtung.thoikhoabieuthanhtung.model.PhongHoc;



public interface PhongHocService {
	List<PhongHoc> getAllPhongHoc();
	void savePhongHoc(PhongHoc phongHoc);
	PhongHoc getPhongHocById(long id);
	void deletePhongHocById(long id);
	Page<PhongHoc> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	public List<PhongHoc> getPhongHocforBatch(String batchName);
}
