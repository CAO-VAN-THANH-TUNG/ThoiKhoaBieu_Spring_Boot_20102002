package anhthanhtung.thoikhoabieuthanhtung.service;

import java.util.List;

import org.springframework.data.domain.Page;

import anhthanhtung.thoikhoabieuthanhtung.model.LopHoc;

public interface LopHocService {
	List<LopHoc> getAllLopHoc();
	List<LopHoc> getLopHocforBatch(String batchName);
	void saveLopHoc(LopHoc lopHoc);
	LopHoc getLopHocById(long id);
	void deleteLopHocById(long id);
	Page<LopHoc> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	 
}
