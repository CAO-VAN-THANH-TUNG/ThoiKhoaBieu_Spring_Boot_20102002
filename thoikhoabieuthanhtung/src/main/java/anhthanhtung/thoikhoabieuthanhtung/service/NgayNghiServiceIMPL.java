package anhthanhtung.thoikhoabieuthanhtung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import anhthanhtung.thoikhoabieuthanhtung.model.NgayNghi;
import anhthanhtung.thoikhoabieuthanhtung.repository.NgayNghiRepository;

@Service
public class NgayNghiServiceIMPL implements NgayNghiService{

	@Autowired
	private NgayNghiRepository ngayNghiRepository;

	@Override
	public void saveNgayNghi(NgayNghi ngayNghi) {
		this.ngayNghiRepository.save(ngayNghi);
		
	}

	@Override
	public List<NgayNghi> getAllNgayNghi() {
		return ngayNghiRepository.findAll();

	}

	@Override
	public void deleteNgayNghiById(long id) {
		this.ngayNghiRepository.deleteById(id);
	}
}