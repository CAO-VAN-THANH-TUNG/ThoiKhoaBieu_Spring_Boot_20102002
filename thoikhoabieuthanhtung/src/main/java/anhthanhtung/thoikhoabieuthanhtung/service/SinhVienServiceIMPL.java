package anhthanhtung.thoikhoabieuthanhtung.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import anhthanhtung.thoikhoabieuthanhtung.model.SinhVien;
import anhthanhtung.thoikhoabieuthanhtung.repository.SinhVienRepository;

@Service
public class SinhVienServiceIMPL implements SinhVienService {

	@Autowired
	private SinhVienRepository sinhVienRepository;
	
	@Override
	public void saveSinhVien(SinhVien sinhVien) {
		this.sinhVienRepository.save(sinhVien);
		
	}

}
