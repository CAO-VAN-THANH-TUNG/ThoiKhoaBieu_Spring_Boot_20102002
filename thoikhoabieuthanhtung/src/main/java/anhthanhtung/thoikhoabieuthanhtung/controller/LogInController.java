/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package anhthanhtung.thoikhoabieuthanhtung.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import anhthanhtung.thoikhoabieuthanhtung.model.LopHoc;
import anhthanhtung.thoikhoabieuthanhtung.model.NguoiDung;
import anhthanhtung.thoikhoabieuthanhtung.service.NguoiDungService;

@Controller
public class LogInController {
	@Autowired
	NguoiDungService nguoiDungService;

	@Value("${useremail}")
	public static String email;

	@GetMapping("/logInView")
	public String ViewlogInPage(@ModelAttribute NguoiDung nguoiDung, BindingResult bindingResult, Model model) {
		model.addAttribute("nguoiDung", nguoiDung);
		return "logIn";
	}

	@PostMapping("/loginUser")
	public String logInUser(@ModelAttribute("NguoiDung") NguoiDung nguoiDung, BindingResult bindingResult,
			Model model) {

		email = nguoiDung.getTenNguoiDung();
		String password = nguoiDung.getMatKhau();

		NguoiDung verifyuser = new NguoiDung();

		LopHoc lopHoc = new LopHoc();
		verifyuser = nguoiDungService.findUserUsingEnhancedForLoop(email, password);
		String returnUserType = verifyuser.getquyenHan();
		model.addAttribute("mykey", email);
		model.addAttribute("lopHoc", lopHoc);
		switch (returnUserType) {
			case "SinhVien":

				return "studentHome";

			case "giaoVien":

				return "teacherHome";

			case "admin":
				model.addAttribute("lopHoc", lopHoc);

				return "timetablerHome";

			default:
				return "redirect:/logInView";

		}

	}
}