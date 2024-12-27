package anhthanhtung.thoikhoabieuthanhtung.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import anhthanhtung.thoikhoabieuthanhtung.model.NguoiDung;
import anhthanhtung.thoikhoabieuthanhtung.repository.NguoiDungRepository;
@Service
public class NguoiDungServiceIMPL implements NguoiDungService{

	@Autowired
	private NguoiDungRepository  nguoiDungRepository;

	@Override
	public void saveNguoiDung(NguoiDung nguoiDung) {
		this.nguoiDungRepository.save(nguoiDung);
	}

	@Override
	public List<NguoiDung> getallNguoiDung() {
		
		return nguoiDungRepository.findAll();

	}

	@Override
	public NguoiDung getUserByID(long id) {
		Optional<NguoiDung> userInstance = nguoiDungRepository.findById(id);
		NguoiDung nguoiDung = null ;
		if(userInstance.isPresent()) {
			nguoiDung = userInstance.get();
			String tenNguoiDung = nguoiDung.getTenNguoiDung();
			String matKhau = nguoiDung.getMatKhau();

			System.out.println("get username: "+tenNguoiDung+"getMatKhau: "+matKhau);
		} else {
			throw new RuntimeException(" User not found for id " + id);
		}
		return null;
	}

	
	@Override
	public NguoiDung findUserUsingEnhancedForLoop(String names,String matKhau) {
	
	
		
	    for (NguoiDung nguoiDung : getallNguoiDung()) {
	    	System.out.println("User Name: "+nguoiDung.getTenNguoiDung()+" ,nguoiDung getMatKhau: "+nguoiDung.getMatKhau()+" ,nguoiDung Role: "+nguoiDung.getquyenHan());
	    
	        if (nguoiDung.getTenNguoiDung().equals(names) && nguoiDung.getMatKhau().equals(matKhau)) {
	        	System.out.println(nguoiDung.getTenNguoiDung()+" loged in");
	        	
	            return nguoiDung;
	        }
	      
	    }
	    return null;
	}

	
	
	
	
	

}
