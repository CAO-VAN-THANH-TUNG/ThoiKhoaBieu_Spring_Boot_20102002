package anhthanhtung.thoikhoabieuthanhtung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import anhthanhtung.thoikhoabieuthanhtung.model.LopHoc;
import anhthanhtung.thoikhoabieuthanhtung.model.NguoiDung;
import anhthanhtung.thoikhoabieuthanhtung.model.SinhVien;
import anhthanhtung.thoikhoabieuthanhtung.service.LopHocService;
import anhthanhtung.thoikhoabieuthanhtung.service.NguoiDungService;
import anhthanhtung.thoikhoabieuthanhtung.service.SinhVienService;

@Controller
public class SinhVienController {

	@Autowired
	private SinhVienService sinhVienService;

	@Autowired
	private NguoiDungService nguoiDungService;

	@Autowired
	private LopHocService lopHocService;

	@GetMapping("/signUpView")
	public String ViewSignUpPage(@ModelAttribute SinhVien sinhVien, BindingResult bindingResult, Model model) {
		model.addAttribute("sinhVien", sinhVien);
		return "signUp";
	}

	@PostMapping("/addStudent")
	public String saveSinhVien(@ModelAttribute("SinhVien") SinhVien sinhVien) {

		String email = sinhVien.getEmail();
		String password = sinhVien.getMatKhau();
		System.out.println("print ");
		NguoiDung nguoiDung = new NguoiDung(email, password, "sinhVien");
		saveUsers(nguoiDung);

		sinhVienService.saveSinhVien(sinhVien);

		return "redirect:/logInView";
	}
	@RequestMapping("/gotoStuHome")
	public String gotoStuHome(@ModelAttribute("LopHoc") LopHoc lopHoc, BindingResult bindingResult,
			Model model) {
		model.addAttribute("lopHoc", lopHoc);
		String email = LogInController.email;
		model.addAttribute("mykey", email);
		return "studentHome";
	}
	public void saveUsers(@ModelAttribute("NguoiDung") NguoiDung nguoiDung) {
		// save users to database

		nguoiDungService.saveNguoiDung(nguoiDung);

	}

	@GetMapping("/batchtimetableList/{batchName}")
	public String findLopHocforBatch(@PathVariable(value = "batchName") String batchName,
			@ModelAttribute("lop_hoc") LopHoc lopH,
			Model model) {

		List<LopHoc> batchClassList = lopHocService.getLopHocforBatch(batchName);
		for (LopHoc lopHoc : batchClassList) {
			System.out.println(" classes date: " + lopHoc.getNgay() + " classes batch: " + lopHoc.getKhoa());
		}
		String email = LogInController.email;
		model.addAttribute("mykey", email);
		model.addAttribute("batchClassList", batchClassList);
		return "studentHome";
	}
}
