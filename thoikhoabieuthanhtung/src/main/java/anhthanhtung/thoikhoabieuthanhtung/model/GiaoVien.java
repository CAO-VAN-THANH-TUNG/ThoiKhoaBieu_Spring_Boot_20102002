package anhthanhtung.thoikhoabieuthanhtung.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "giaovien")
public class GiaoVien {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "ten_dang_nhap")
	private String tenDangNhap;
	
	@Column(name = "ma_nhan_vien")
	private String maNhanVien;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "mo_hinh_giang_day")
	private String moHinhGiangDay;
	
	@Column(name = "mat_khau")
	private String matKhau;
	
	@Column(name = "ngay_sinh")
	private String ngaySinh;
	
	@Column(name = "so_dien_thoai")
	private String soDienThoai;
	
	@Column(name = "gioi_tinh")
	private String gioiTinh;

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

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMoHinhGiangDay() {
		return moHinhGiangDay;
	}

	public void setMoHinhGiangDay(String moHinhGiangDay) {
		this.moHinhGiangDay = moHinhGiangDay;
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

