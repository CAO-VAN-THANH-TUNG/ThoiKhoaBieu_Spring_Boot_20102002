package anhthanhtung.thoikhoabieuthanhtung.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "sinhvien")
public class SinhVien {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "ten_dang_nhap")
	private String tenDangNhap;
	
	@Column(name = "ma_sinh_vien")
	private String maSinhVien;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "khoa_hoc")
	private String khoaHoc;
	
	@Column(name = "mat_khau")
	private String matKhau;
	
	@Column(name = "ngay_sinh")
	private String ngaySinh;
	
	@Column(name = "so_dien_thoai")
	private String soDienThoai;
	
	@Column(name = "gioi_tinh")
	private String gioiTinh;

	public SinhVien() {
		super();
	}

	public SinhVien(String tenDangNhap, String maSinhVien, String email, String khoaHoc, String matKhau,
			String ngaySinh, String soDienThoai, String gioiTinh) {
		super();
		this.tenDangNhap = tenDangNhap;
		this.maSinhVien = maSinhVien;
		this.email = email;
		this.khoaHoc = khoaHoc;
		this.matKhau = matKhau;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.gioiTinh = gioiTinh;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getKhoaHoc() {
		return khoaHoc;
	}

	public void setKhoaHoc(String khoaHoc) {
		this.khoaHoc = khoaHoc;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
}

