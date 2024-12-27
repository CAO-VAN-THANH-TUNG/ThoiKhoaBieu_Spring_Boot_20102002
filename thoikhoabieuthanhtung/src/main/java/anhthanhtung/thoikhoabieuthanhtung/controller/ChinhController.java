package anhthanhtung.thoikhoabieuthanhtung.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import anhthanhtung.thoikhoabieuthanhtung.model.YeuCau;
import anhthanhtung.thoikhoabieuthanhtung.service.ChinhService;
import anhthanhtung.thoikhoabieuthanhtung.service.LopHocService;

@Controller
public class ChinhController {

	

	@Autowired
	private ChinhService chinhService;

	@Autowired
	private LopHocService lopHocService;

	@GetMapping("/TrangChu")
	public String viewHomePage(Model model) {
		model.addAttribute("listlopHoc", lopHocService.getAllLopHoc());

		return "index";
	}

	@GetMapping("/showAboutPage")
	public String ViewAboutPage() {

		return "aboutPage";
	}

	@GetMapping("/contactUs")
	public String ViewContactPage(@ModelAttribute YeuCau yeuCau, BindingResult bindingResult, Model model) {
		model.addAttribute("yeuCau", yeuCau);
		return "contactUs";
	}

	@PostMapping("/makeEnquiry")
	public String saveYeuCau(@ModelAttribute("YeuCau") YeuCau yeuCau) {
		// save enquiry to database
		chinhService.saveYeuCau(yeuCau);
		return "redirect:/";
	}

}
