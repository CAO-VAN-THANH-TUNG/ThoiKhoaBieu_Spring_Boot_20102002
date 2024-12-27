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

import anhthanhtung.thoikhoabieuthanhtung.model.GiaoVien;
import anhthanhtung.thoikhoabieuthanhtung.model.LopHoc;
import anhthanhtung.thoikhoabieuthanhtung.model.NguoiDung;
import anhthanhtung.thoikhoabieuthanhtung.service.GiaoVienService;
import anhthanhtung.thoikhoabieuthanhtung.service.LopHocService;
import anhthanhtung.thoikhoabieuthanhtung.service.NguoiDungService;

@Controller
public class GiaoVienController {

	@Autowired
	private GiaoVienService giaoVienService;

	@Autowired
	private NguoiDungService nguoiDungService;

	@Autowired
	private LopHocService lopHocService;

	@GetMapping("/goaddTeacher")
	public String ViewSignUpPage(@ModelAttribute GiaoVien giaoVien, Model model) {
		model.addAttribute("giaoVien", giaoVien);
		return "addTeacherForm";
	}

	@GetMapping("/batchtimetableListTeach/{batchName}")
	public String findclassesforBatchteach(@PathVariable(value = "batchName") String batchName,
			@ModelAttribute("lop_hoc") LopHoc lopH,
			Model model) {

		List<LopHoc> batchClassList = lopHocService.getLopHocforBatch(batchName);
		for (LopHoc lopHoc : batchClassList) {
			System.out.println(" Lớp Học Ngày: " + lopHoc.getNgay() + " Tên Khoa: " + lopHoc.getKhoa());
		}
		String email = LogInController.email;
		model.addAttribute("mykey", email);
		model.addAttribute("batchClassList", batchClassList);
		return "teacherHome";
	}

	@GetMapping("/viewTeacherHolidays")
	public String viewStuHolidays(@ModelAttribute GiaoVien giaoVien, BindingResult bindingResult, Model model) {
		model.addAttribute("giaoVien", giaoVien);
		return "teacherHolidays";
	}

	@RequestMapping("/TeacherHome")
	public String gotomakeTimetableRow(@ModelAttribute("LopHoc") LopHoc lopHoc, BindingResult bindingResult,
			Model model) {
		model.addAttribute("lopHoc", lopHoc);
		String email = LogInController.email;
		model.addAttribute("mykey", email);
		return "teacherHome";
	}

	@PostMapping("/addTeacher")
	public String saveStudent(@ModelAttribute("GiaoVien") GiaoVien giaoVien) {

		String email = giaoVien.getEmail();
		String password = giaoVien.getMatKhau();

		NguoiDung nguoiDung = new NguoiDung(email, password, "giaoVien");

		// save teachers to database

		saveNguoiDung(nguoiDung);
		giaoVienService.saveGiaoVien(giaoVien);

		return "redirect:/goaddTeacher";
	}

	public void saveNguoiDung(@ModelAttribute("NguoiDung") NguoiDung nguoiDung) {
		// save users to database

		nguoiDungService.saveNguoiDung(nguoiDung);

	}
}
