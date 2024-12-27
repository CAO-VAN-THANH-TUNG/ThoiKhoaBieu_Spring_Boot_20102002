package anhthanhtung.thoikhoabieuthanhtung.controller;

import java.util.ArrayList;
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
import anhthanhtung.thoikhoabieuthanhtung.model.PhongHoc;
import anhthanhtung.thoikhoabieuthanhtung.service.LopHocService;
import anhthanhtung.thoikhoabieuthanhtung.service.PhongHocService;

@Controller
public class PhongHocController {

	@Autowired
	private PhongHocService phongHocService;
	@Autowired
	private LopHocService lopHocService;

	@PostMapping("/makeRoomsRow")
	public String makeRoomsRow(@ModelAttribute("PhongHoc") PhongHoc phongHoc, BindingResult bindingResult,
			Model model) {
		model.addAttribute("phongHoc", phongHoc);
		phongHocService.savePhongHoc(phongHoc);
		return "/";
	}

	@RequestMapping("/gotomakeRoomsRow")
	public String gotomakeRoomsRow(@ModelAttribute("PhongHoc") PhongHoc phongHoc, BindingResult bindingResult,
			Model model) {
		model.addAttribute("phongHoc", phongHoc);
		return "/";
	}

	@GetMapping("/editRooms")
	public String editPhongHoc(Model model) {

		return findPaginatedRooms(1, "soPhong", "asc", model);
	}

	@PostMapping("/saveRooms")
	public String savePhongHoc(@ModelAttribute("PhongHoc") PhongHoc phongHoc) {
		// save Rooms to database
		phongHocService.savePhongHoc(phongHoc);
		return "editRooms";
	}

	@GetMapping("/showRoomsFormForUpdate/{id}")
	public String showRoomsFormForUpdate(@PathVariable(value = "id") long id, Model model) {

		// get Rooms from the service
		PhongHoc phongHoc = phongHocService.getPhongHocById(id);

		// set Rooms as a model attribute to pre-populate the form
		model.addAttribute("phongHoc", phongHoc);
		return "editTimetableForm";
	}

	@GetMapping("/deleteRooms/{id}")
	public String deletePhongHoc(@PathVariable(value = "id") long id) {

		// call delete Rooms method
		this.phongHocService.deletePhongHocById(id);
		return "redirect:/editRooms";
	}

	@GetMapping("/pagerooms/{pageNo}")
	public String findPaginatedRooms(@PathVariable(value = "pageNo") int pageNo,
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;

		Page<PhongHoc> page = phongHocService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<PhongHoc> listPhongHoc = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listPhongHoc", listPhongHoc);
		return "editRooms";
	}

	@GetMapping("/pagePhongHocstu/{pageNo}")
	public String findPaginatedPhongHocStu(@PathVariable(value = "pageNo") int pageNo,
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;

		Page<PhongHoc> page = phongHocService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<PhongHoc> listPhongHoc = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listPhongHoc", listPhongHoc);
		return "phonghoc";
	}

	@GetMapping("/teacherPhongHocpage")
	public String teachereditPhongHoc(Model model) {

		return findPaginatedPhongHocteacher(1, "soPhong", "asc", model);
	}

	@GetMapping("/teacherroomrespage/{pageNo}")
	public String findPaginatedPhongHocteacher(@PathVariable(value = "pageNo") int pageNo,
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;

		Page<PhongHoc> page = phongHocService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<PhongHoc> listPhongHoc = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listPhongHoc", listPhongHoc);
		return "teacherRoomReservation";
	}

	@GetMapping("/timetablerPhongHocpage")
	public String timetablerPhongHocpage(Model model) {

		return findPaginatedPhongHocTimetabler(1, "soPhong", "asc", model);
	}

	@GetMapping("/pagetimetablerroom/{pageNo}")
	public String findPaginatedPhongHocTimetabler(@PathVariable(value = "pageNo") int pageNo,
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;

		Page<PhongHoc> page = phongHocService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<PhongHoc> listPhongHoc = page.getContent();
		List<PhongHoc> pendingList = new ArrayList<>();

		for (PhongHoc phongHoc : listPhongHoc) {
			System.out.println(phongHoc.getTrangThai());

			if (phongHoc.getTrangThai().equals("pending")) {
				pendingList.add(phongHoc);
			}
		}

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listPhongHoc", pendingList);
		return "timeTablerRoomReservation";
	}

	@GetMapping("/RoomReservationConfirm/{id}")
	public String RoomReservationConfirm(@PathVariable(value = "id") long id, Model model) {

		// get PhongHoc from the service
		PhongHoc phongHoc = phongHocService.getPhongHocById(id);
		phongHoc.setTrangThai("booked");
		System.out.println(phongHoc.getId() + " get " + id);
		phongHocService.savePhongHoc(phongHoc);
		// set PhongHoc as a model attribute to pre-populate the form
		model.addAttribute("phongHoc", phongHoc);
		return "redirect:/timetablerPhongHocpage";
	}

	@RequestMapping("/gotoTeachRooms")
	public String toStuRooms(@ModelAttribute("phongHoc") PhongHoc phongHoc, BindingResult bindingResult, Model model) {
		model.addAttribute("listPhongHoc", phongHocService.getAllPhongHoc());
		String email = LogInController.email;
		model.addAttribute("mykey", email);
		return "roomsTeacher";
	}

	@GetMapping("/TeaRooms/{tinhTrangSanSang}")
	public String StuRoomsPagination(@PathVariable(value = "tinhTrangSanSang") String availability,
			@ModelAttribute("phongHoc") PhongHoc phongH,
			Model model) {

		List<PhongHoc> phongHocList = phongHocService.getPhongHocforBatch(availability);
		for (PhongHoc phongHoc : phongHocList) {
			System.out.println(
					" classes date: " + phongHoc.getTinhTrangSanSang() + " classes batch: " + phongHoc.getSoPhong());
		}
		String email = LogInController.email;
		model.addAttribute("mykey", email);
		model.addAttribute("listPhongHoc", phongHocList);
		return "roomsTeacher";
	}

	@GetMapping("/showFormForRoomReservation/{id}")
	public String showFormForRoomsReservat(@PathVariable(value = "id") long id, Model model) {

		// get rooms from the service
		PhongHoc phongHoc = phongHocService.getPhongHocById(id);
		List<LopHoc> lopHoc = lopHocService.getAllLopHoc();
		List<LopHoc> bookedlopHoc = new ArrayList<>();
		for (LopHoc cl : lopHoc) {

			String cla = cl.getDiaDiem();
			String roonNumber = phongHoc.getSoPhong();
			System.out.println(cla + "|||||||" + roonNumber);
			if (cla.equals(phongHoc.getSoPhong())) {

				bookedlopHoc.add(cl);
			}

		}
		String email = LogInController.email;
		phongHoc.setGiangVienDat(email);

		// set phongHoc as a model attribute to pre-populate the form
		model.addAttribute("phongHoc", phongHoc);
		model.addAttribute("bookedlopHoc", bookedlopHoc);
		return "teacherRoomReservationSelect";
	}

	@PostMapping("/makeRoomReservation")
	public String saveClasses(@ModelAttribute("PhongHoc") PhongHoc phongHoc) {
		// save classes to database
		String starttime = phongHoc.getThoiGianBatDau();
		phongHoc.setTrangThai("pending");
		phongHoc.setTinhTrangSanSang("unavailable");
		System.out.println(starttime);
		phongHocService.savePhongHoc(phongHoc);
		return "redirect:/teacherPhongHocpage";
	}

}
