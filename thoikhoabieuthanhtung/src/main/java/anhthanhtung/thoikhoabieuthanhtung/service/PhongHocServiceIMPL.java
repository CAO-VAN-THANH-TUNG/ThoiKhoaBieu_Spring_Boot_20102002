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

import anhthanhtung.thoikhoabieuthanhtung.model.PhongHoc;
import anhthanhtung.thoikhoabieuthanhtung.repository.PhongHocRepository;

@Service
public class PhongHocServiceIMPL implements PhongHocService {

	@Autowired
	private PhongHocRepository phongHocRepository;
	
	@Override
	public List<PhongHoc> getAllPhongHoc() {
		return phongHocRepository.findAll();
	}

	@Override
	public void savePhongHoc(PhongHoc phongHoc) {
		this.phongHocRepository.save(phongHoc);
		
	}

	@Override
	public PhongHoc getPhongHocById(long id) {
		Optional<PhongHoc> optional = phongHocRepository.findById(id);
		PhongHoc phongHoc = null;
		if (optional.isPresent()) {
			phongHoc = optional.get();
		} else {
			throw new RuntimeException(" Room not found for id :: " + id);
		}
		return phongHoc;
	}

	@Override
	public void deletePhongHocById(long id) {
		this.phongHocRepository.deleteById(id);
		
	}

	@Override
	public Page<PhongHoc> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.phongHocRepository.findAll(pageable);
	}

	@Override
	public List<PhongHoc> getPhongHocforBatch(String sanSang) {
		
		List<PhongHoc> getPhongHoc = new ArrayList<>();
		
		for (PhongHoc phongHoc : getAllPhongHoc()) {
			
			System.out.println(" classes date: "+phongHoc.getSoPhong()+" classes batch: "+phongHoc.getTang());
			if(phongHoc.getTinhTrangSanSang().equals(sanSang)) {
				getPhongHoc.add(phongHoc);
			}
			
		}
		return getPhongHoc;
	}
	

}