package anhthanhtung.thoikhoabieuthanhtung.service;

import java.util.List;

import org.springframework.data.domain.Page;

import anhthanhtung.thoikhoabieuthanhtung.model.GiaoVien;

public interface GiaoVienService {

	List<GiaoVien> getAllGiaoVien();
	List<GiaoVien> getGiaoVienforBatch(String batchName);
	void saveGiaoVien(GiaoVien giaoVien);
	GiaoVien getGiaoVienById(long id);
	void deleteGiaoVienById(long id);
	Page<GiaoVien> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}

