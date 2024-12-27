package anhthanhtung.thoikhoabieuthanhtung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import anhthanhtung.thoikhoabieuthanhtung.model.LopHoc;
import anhthanhtung.thoikhoabieuthanhtung.service.LopHocService;

@Controller
public class ThoiKhoaBieuController {

	@Autowired
	private LopHocService lopHocService;

	@PostMapping("/makeTimetableRow")
	public String makeTimetableRow(@ModelAttribute("LopHoc") LopHoc lopHoc, BindingResult bindingResult, Model model) {
		model.addAttribute("lopHoc", lopHoc);
		lopHocService.saveLopHoc(lopHoc);
		return "timetablerHome";
	}

	@RequestMapping("/gotomakeTimetableRow")
	public String gotomakeTimetableRow(@ModelAttribute("LopHoc") LopHoc lopHoc, BindingResult bindingResult,
			Model model) {
		model.addAttribute("lopHoc", lopHoc);
		String email = LogInController.email;
		model.addAttribute("mykey", email);
		return "timetablerHome";
	}

	@GetMapping("/timetableEdit")
	public String timeTableEdit(Model model) {

		return findPaginated(1, "ngay", "asc", model);
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

		// get classes from the service
		LopHoc lopHoc = lopHocService.getLopHocById(id);

		// set classes as a model attribute to pre-populate the form
		model.addAttribute("lopHoc", lopHoc);
		return "editTimetableForm";
	}

	@PostMapping("/saveLopHoc")
	public String saveClasses(@ModelAttribute("LopHoc") LopHoc lopHoc) {
		// save classes to database
		lopHocService.saveLopHoc(lopHoc);
		return "redirect:/timetableEdit";
	}

	@GetMapping("/deleteLopHoc/{id}")
	public String deleteLopHoc(@PathVariable(value = "id") long id) {

		// call delete classes method
		this.lopHocService.deleteLopHocById(id);
		return "redirect:/timetableEdit";
	}

	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;

		Page<LopHoc> page = lopHocService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<LopHoc> listlopHoc = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listlopHoc", listlopHoc);
		return "editTimetable";
	}

}
