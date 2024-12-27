package anhthanhtung.thoikhoabieuthanhtung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import anhthanhtung.thoikhoabieuthanhtung.model.GiaoVien;
import anhthanhtung.thoikhoabieuthanhtung.model.LopHoc;
import anhthanhtung.thoikhoabieuthanhtung.model.NgayNghi;
import anhthanhtung.thoikhoabieuthanhtung.model.NguoiDung;
import anhthanhtung.thoikhoabieuthanhtung.model.PhongHoc;
import anhthanhtung.thoikhoabieuthanhtung.model.SinhVien;
import anhthanhtung.thoikhoabieuthanhtung.repository.GiaoVienRepository;
import anhthanhtung.thoikhoabieuthanhtung.repository.LopHocRepository;
import anhthanhtung.thoikhoabieuthanhtung.repository.NgayNghiRepository;
import anhthanhtung.thoikhoabieuthanhtung.repository.NguoiDungRepository;
import anhthanhtung.thoikhoabieuthanhtung.repository.PhongHocRepository;
import anhthanhtung.thoikhoabieuthanhtung.repository.SinhVienRepository;
import anhthanhtung.thoikhoabieuthanhtung.service.GiaoVienService;
import anhthanhtung.thoikhoabieuthanhtung.service.LopHocService;
import anhthanhtung.thoikhoabieuthanhtung.service.NgayNghiService;
import anhthanhtung.thoikhoabieuthanhtung.service.NguoiDungService;
import anhthanhtung.thoikhoabieuthanhtung.service.PhongHocService;
import anhthanhtung.thoikhoabieuthanhtung.service.SinhVienService;

@RestController
@RequestMapping("/api/v1")
public class RestApiController {

	@Autowired
	private PhongHocService phongHocService;

	@Autowired
	private LopHocService lopHocService;
	@Autowired
	private NgayNghiService ngayNghiService;

	@Autowired
	private GiaoVienService giaoVienService;

	@Autowired
	private NguoiDungService nguoiDungService;

	@Autowired
	private SinhVienService sinhVienService;

	@Autowired
	private NguoiDungRepository nguoiDungRepository;

	@Autowired
	private PhongHocRepository phongHocRepository;

	@Autowired
	private LopHocRepository lopHocRepository;

	@Autowired
	private NgayNghiRepository ngayNghiRepository;

	@Autowired
	private GiaoVienRepository giaoVienRepository;

	@Autowired
	private SinhVienRepository sinhVienRepository;

	@GetMapping("/lopHoc")
	public List<LopHoc> getAllLopHoc() {
		return lopHocRepository.findAll();

	}

	@PostMapping("/lopHoc")
	public LopHoc createLopHoc(@RequestBody LopHoc lopHoc) {
		return lopHocRepository.save(lopHoc);
	}

	@GetMapping("/ngayNghi")
	public List<NgayNghi> getAllNgayNghi() {
		return ngayNghiRepository.findAll();
	}

	@GetMapping("/deleteNgayNghi/{id}")
	public void deleteNgayNghi(@PathVariable(value = "id") long id) {
		// call delete classes method
		this.ngayNghiService.deleteNgayNghiById(id);

	}

	@GetMapping("/giaoVien")
	public List<GiaoVien> getAllGiaoVien() {
		return giaoVienRepository.findAll();
	}

	@GetMapping("/nguoiDung")
	public List<NguoiDung> getAllNguoiDung() {
		return nguoiDungRepository.findAll();
	}

	@PostMapping("/ngayNghiSave")
	public void saveNgayNghi(@RequestBody NgayNghi ngayNghi) {
		// save classes to database
		ngayNghiService.saveNgayNghi(ngayNghi);

	}

	@PostMapping("/lopHocSave")
	public void saveLopHoc(@RequestBody LopHoc lopHoc) {
		// save LopHoc to database
		lopHocService.saveLopHoc(lopHoc);

	}

	@GetMapping("/deleteLopHoc/{id}")
	public void deleteLopHoc(@PathVariable(value = "id") long id) {
		// call delete LopHocs method
		this.lopHocService.deleteLopHocById(id);

	}

	@PostMapping("/giaoVienSave")
	public void saveGiaoVien(@RequestBody GiaoVien teacher) {
		// save GiaoVien to database
		giaoVienService.saveGiaoVien(teacher);

	}

	@GetMapping("/deleteGiaoVien/{id}")
	public void deleteGiaoVien(@PathVariable(value = "id") long id) {
		// call delete GiaoVien method
		this.giaoVienService.deleteGiaoVienById(id);

	}

	@GetMapping("/phongHoc")
	public List<PhongHoc> getAllPhongHoc() {
		return phongHocRepository.findAll();
	}

	@PostMapping("/phongHocSave")
	public void savePhongHoc(@RequestBody PhongHoc phongHoc) {
		phongHocService.savePhongHoc(phongHoc);

	}

	@GetMapping("/deletePhongHoc/{id}")
	public void deletePhongHoc(@PathVariable(value = "id") long id) {
		this.phongHocService.deletePhongHocById(id);

	}

	@PostMapping("/registerSinhVien")
	public void registerStudent(@RequestBody SinhVien sinhVien) {

		String email = sinhVien.getEmail();
		String password = sinhVien.getMatKhau();
		System.out.println("print " + email);
		System.out.println("print " + password);
		NguoiDung user = new NguoiDung(email, password, "sinhVien");
		nguoiDungService.saveNguoiDung(user);
		// save sinhViens to database
		sinhVienService.saveSinhVien(sinhVien);

	}

	@GetMapping("/sinhVien")
	public List<SinhVien> getAllSinhVien() {
		return sinhVienRepository.findAll();
	}

}