package anhthanhtung.thoikhoabieuthanhtung.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import anhthanhtung.thoikhoabieuthanhtung.model.YeuCau;
import anhthanhtung.thoikhoabieuthanhtung.repository.YeuCauRepository;

@Service
public class ChinhServicesIMPL implements ChinhService{
	
	@Autowired
	private YeuCauRepository yeuCauRepository;

	@Override
	public void saveYeuCau(YeuCau yeuCau) {
		this.yeuCauRepository.save(yeuCau);
		
	}	

}
