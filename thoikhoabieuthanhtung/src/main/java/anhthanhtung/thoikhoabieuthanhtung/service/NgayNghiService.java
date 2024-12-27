package anhthanhtung.thoikhoabieuthanhtung.service;

import java.util.List;

import anhthanhtung.thoikhoabieuthanhtung.model.NgayNghi;
public interface NgayNghiService {
	void saveNgayNghi(NgayNghi ngayNghi);
	List<NgayNghi> getAllNgayNghi();
	void deleteNgayNghiById(long id);
}