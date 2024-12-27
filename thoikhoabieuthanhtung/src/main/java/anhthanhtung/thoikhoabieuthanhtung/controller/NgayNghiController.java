package anhthanhtung.thoikhoabieuthanhtung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import anhthanhtung.thoikhoabieuthanhtung.model.NgayNghi;
import anhthanhtung.thoikhoabieuthanhtung.service.NgayNghiService;

@Controller
public class NgayNghiController {

	@Autowired
	NgayNghiService ngayNghiService;
	
	
	@GetMapping("/viewStuHolidays")
	public String viewStuHolidays(@ModelAttribute NgayNghi ngayN, BindingResult bindingResult, Model model) {
		List<NgayNghi> holi = ngayNghiService.getAllNgayNghi();
		for(NgayNghi ngayNghi : holi) {
			System.out.println(ngayNghi.getTenNgayNghi());
		}
		model.addAttribute("ngayNghiList",holi);
		return "holidaysView";
	}
}