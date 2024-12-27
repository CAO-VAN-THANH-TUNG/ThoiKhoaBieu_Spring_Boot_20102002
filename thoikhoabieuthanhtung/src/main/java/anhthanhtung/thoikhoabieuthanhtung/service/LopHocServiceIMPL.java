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

import anhthanhtung.thoikhoabieuthanhtung.model.LopHoc;
import anhthanhtung.thoikhoabieuthanhtung.repository.LopHocRepository;

@Service
public class LopHocServiceIMPL implements LopHocService {

	@Autowired
	private LopHocRepository lopHocRepository;
	
	@Override
	public List<LopHoc> getAllLopHoc() {
		return lopHocRepository.findAll();
	}

	@Override
	public void saveLopHoc(LopHoc lopHoc) {
		this.lopHocRepository.save(lopHoc);
		
	}

	@Override
	public LopHoc getLopHocById(long id) {
		Optional<LopHoc> optional = lopHocRepository.findById(id);
		LopHoc lopHoc = null;
		if (optional.isPresent()) {
			lopHoc = optional.get();
		} else {
			throw new RuntimeException(" LopHoc not found for id : " + id);
		}
		return lopHoc;
	}

	@Override
	public void deleteLopHocById(long id) {
		this.lopHocRepository.deleteById(id);
		
	}

	@Override
	public Page<LopHoc> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.lopHocRepository.findAll(pageable);
	}

	@Override
	public List<LopHoc> getLopHocforBatch(String batchName) {
		
		List<LopHoc> getLopHoc = new ArrayList<>();
		
		for (LopHoc lopHoc : getAllLopHoc()) {
			
			System.out.println(" LopHoc date: "+lopHoc.getNgay()+" LopHoc batch: "+lopHoc.getKhoa());
			if(lopHoc.getKhoa().equals(batchName)) {
				getLopHoc.add(lopHoc);
			}
			
		}
		return getLopHoc;
	}

	

}
