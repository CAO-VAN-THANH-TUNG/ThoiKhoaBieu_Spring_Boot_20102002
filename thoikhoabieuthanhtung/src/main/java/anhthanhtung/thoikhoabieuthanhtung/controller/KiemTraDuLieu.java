package anhthanhtung.thoikhoabieuthanhtung.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import anhthanhtung.thoikhoabieuthanhtung.model.LopHoc;
import anhthanhtung.thoikhoabieuthanhtung.model.NgayNghi;
import anhthanhtung.thoikhoabieuthanhtung.model.PhongHoc;
import anhthanhtung.thoikhoabieuthanhtung.service.LopHocService;
import anhthanhtung.thoikhoabieuthanhtung.service.NgayNghiService;
import anhthanhtung.thoikhoabieuthanhtung.service.PhongHocService;

@Component
public class KiemTraDuLieu {

	@Autowired
	private PhongHocService phongHocService;
	
	@Autowired
	private LopHocService lopHocService;
	
	@Autowired
	private NgayNghiService ngayNghiService;
	
	@Scheduled(cron = "0 0/1 * * * *")
	public void run() {
		try{
		List<PhongHoc> phongHoc = new ArrayList<>();
		phongHoc =	phongHocService.getAllPhongHoc();
		
		List<LopHoc> lopHoc= new ArrayList<>();
		lopHoc =	lopHocService.getAllLopHoc();
		
		List<NgayNghi> ngayNghi= new ArrayList<>();
		ngayNghi =	ngayNghiService.getAllNgayNghi();
		
		String roomReserveDate = "";
		String roomEndTime = "";
		
		String classDate = "";
		String classEndTime = "";

		String holidaysDate = "";
		
		String todaysDate = "";
		
		for(PhongHoc r : phongHoc) {
			roomReserveDate = r.getNgayDat();
			roomEndTime = r.getThoiGianKetThuc();
			

			String conactinateDate = roomReserveDate+" "+roomEndTime;
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	        Date date1 = sdf.parse(conactinateDate);
	        Date date2 = sdf.parse("2024/10/10 14:20");
	        Date date = new Date();  
	        todaysDate = sdf.format(date);  
	        date = sdf.parse(todaysDate);
	        if(date1.before(date)) {
		        phongHocService.deletePhongHocById(r.getId());
	        }
			
		}
		
		
		for(LopHoc r : lopHoc) {
			classDate = r.getNgay();
			classEndTime = r.getThoiGianKetThuc();
			

			String conactinateDate = classDate+" "+classEndTime;
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	        Date date1 = sdf.parse(conactinateDate);
	        Date date = new Date();  
	        todaysDate = sdf.format(date);  
	        date = sdf.parse(todaysDate);
	        if(date1.before(date)) {
		        lopHocService.deleteLopHocById(r.getId());
	        }
			
		}
		
		for(NgayNghi r : ngayNghi) {
			classDate = r.getNgayNghi();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	        Date date1 = sdf.parse(classDate);
	        Date date = new Date();  
	        todaysDate = sdf.format(date);  
	        date = sdf.parse(todaysDate);
	        if(date1.before(date)) {
		        ngayNghiService.deleteNgayNghiById(r.getId());
	        }
			
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}

