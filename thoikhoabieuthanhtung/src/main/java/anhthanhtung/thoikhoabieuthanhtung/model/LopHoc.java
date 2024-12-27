package anhthanhtung.thoikhoabieuthanhtung.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "lop_hoc")
public class LopHoc {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
		
	@Column(name = "ngay")
	private String ngay;
	
	@Column(name = "thu")
	private String thu;
	
	@Column(name = "thoi_gian_bat_dau")
	private String thoiGianBatDau;
	
	@Column(name = "thoi_gian_ket_thuc")
	private String thoiGianKetThuc;
	
	@Column(name = "dia_diem")
	private String diaDiem;

	@Column(name = "ten_giang_vien")
	private String tenGiangVien;
	
	@Column(name = "khoa")
	private String khoa;
	
	@Column(name = "hoc_phan")
	private String hocPhan;
	
	@Column(name = "loai_bang_cap")
	private String loaiBangCap;
	
	public LopHoc() {
		super();
	}

	public LopHoc(String ngay, String thu, String thoiGianBatDau, String thoiGianKetThuc, String diaDiem, String tenGiangVien, String khoa, String hocPhan,
			String loaiBangCap) {
		super();
		this.ngay = ngay;
		this.thu = thu;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
		this.diaDiem = diaDiem;
		this.tenGiangVien = tenGiangVien;
		this.khoa = khoa;
		this.hocPhan = hocPhan;
		this.loaiBangCap = loaiBangCap;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNgay() {
		return ngay;
	}

	public void setNgay(String ngay) {
		this.ngay = ngay;
	}

	public String getThu() {
		return thu;
	}

	public void setThu(String thu) {
		this.thu = thu;
	}

	public String getThoiGianBatDau() {
		return thoiGianBatDau;
	}

	public void setThoiGianBatDau(String thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}

	public String getDiaDiem() {
		return diaDiem;
	}

	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}

	public String getTenGiangVien() {
		return tenGiangVien;
	}

	public void setTenGiangVien(String tenGiangVien) {
		this.tenGiangVien = tenGiangVien;
	}

	public String getKhoa() {
		return khoa;
	}

	public void setKhoa(String khoa) {
		this.khoa = khoa;
	}

	public String getHocPhan() {
		return hocPhan;
	}

	public void setHocPhan(String hocPhan) {
		this.hocPhan = hocPhan;
	}

	public String getLoaiBangCap() {
		return loaiBangCap;
	}

	public void setLoaiBangCap(String loaiBangCap) {
		this.loaiBangCap = loaiBangCap;
	}

	public String getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}

	public void setThoiGianKetThuc(String thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}
}
