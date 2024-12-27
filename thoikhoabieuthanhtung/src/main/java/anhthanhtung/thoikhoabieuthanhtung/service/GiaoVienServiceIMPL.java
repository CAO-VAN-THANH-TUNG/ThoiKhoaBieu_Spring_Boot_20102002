package anhthanhtung.thoikhoabieuthanhtung.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import anhthanhtung.thoikhoabieuthanhtung.model.GiaoVien;
import anhthanhtung.thoikhoabieuthanhtung.repository.GiaoVienRepository;

@Service
public class GiaoVienServiceIMPL implements GiaoVienService {
	
	@Autowired
	private GiaoVienRepository giaoVienRepository;
	
	@Override
	public List<GiaoVien> getAllGiaoVien() {
		return  giaoVienRepository.findAll();
	}

	@Override
	public void saveGiaoVien( GiaoVien  giaoVien) {
		this. giaoVienRepository.save( giaoVien);
		
	}

	@Override
	public  GiaoVien getGiaoVienById(long id) {
		Optional< GiaoVien> optional =  giaoVienRepository.findById(id);
		 GiaoVien  giaoVien = null;
		if (optional.isPresent()) {
			 giaoVien = optional.get();
		} else {
			throw new RuntimeException(" Classes not found for id :: " + id);
		}
		return  giaoVien;
	}

	@Override
	public void deleteGiaoVienById(long id) {
		this. giaoVienRepository.deleteById(id);
		
	}

	@Override
	public Page< GiaoVien> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this. giaoVienRepository.findAll(pageable);
	}

	@Override
	public List< GiaoVien> getGiaoVienforBatch(String TeacherName) {
		
		List< GiaoVien> getGiaoVien = new ArrayList<>();
		
		for ( GiaoVien  giaoVien : getAllGiaoVien()) {
			
			System.out.println(" Teacher name: "+ giaoVien.getTenDangNhap()+"  GiaoVien subject: "+ giaoVien.getMoHinhGiangDay());
			if( giaoVien.getTenDangNhap().equals(TeacherName)) {
				getGiaoVien.add( giaoVien);
			}
			
		}
		return getGiaoVien;
	}


}
