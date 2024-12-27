package anhthanhtung.thoikhoabieuthanhtung.service;


import java.util.List;

import anhthanhtung.thoikhoabieuthanhtung.model.NguoiDung;

public interface NguoiDungService {

	void saveNguoiDung(NguoiDung nguoiDung);
	List<NguoiDung> getallNguoiDung();
	NguoiDung getUserByID(long id);
	NguoiDung findUserUsingEnhancedForLoop(String names,String password);
	
}	

