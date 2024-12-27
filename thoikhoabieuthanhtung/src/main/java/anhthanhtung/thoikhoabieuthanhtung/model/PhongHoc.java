package anhthanhtung.thoikhoabieuthanhtung.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "phonghoc")
public class PhongHoc {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
		
	@Column(name = "so_phong")
	private String soPhong;
	
	@Column(name = "tang")
	private String tang;
	
	@Column(name = "trang_thai")
	private String trangThai;
	
	@Column(name = "ngay_dat")
	private String ngayDat;
	
	@Column(name = "thoi_gian_bat_dau")
	private String thoiGianBatDau;
	
	@Column(name = "thoi_gian_ket_thuc")
	private String thoiGianKetThuc;
	
	@Column(name = "giang_vien_dat")
	private String giangVienDat;
	
	@Column(name = "suc_chua_toi_da")
	private String sucChuaToiDa;
	
	@Column(name = "suc_chua_toi_thieu")
	private String sucChuaToiThieu;
	
	@Column(name = "tinh_trang_san_sang")
	private String tinhTrangSanSang;

	public PhongHoc(String soPhong, String tang, String trangThai, String ngayDat, String thoiGianBatDau,
			String thoiGianKetThuc, String giangVienDat, String sucChuaToiDa, String sucChuaToiThieu, String tinhTrangSanSang) {
		super();
		this.soPhong = soPhong;
		this.tang = tang;
		this.trangThai = trangThai;
		this.ngayDat = ngayDat;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
		this.giangVienDat = giangVienDat;
		this.sucChuaToiDa = sucChuaToiDa;
		this.sucChuaToiThieu = sucChuaToiThieu;
		this.tinhTrangSanSang = tinhTrangSanSang;
	}

	public PhongHoc() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSoPhong() {
		return soPhong;
	}

	public void setSoPhong(String soPhong) {
		this.soPhong = soPhong;
	}

	public String getTang() {
		return tang;
	}

	public void setTang(String tang) {
		this.tang = tang;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getNgayDat() {
		return ngayDat;
	}

	public void setNgayDat(String ngayDat) {
		this.ngayDat = ngayDat;
	}

	public String getThoiGianBatDau() {
		return thoiGianBatDau;
	}

	public void setThoiGianBatDau(String thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}

	public String getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}

	public void setThoiGianKetThuc(String thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}

	public String getGiangVienDat() {
		return giangVienDat;
	}

	public void setGiangVienDat(String giangVienDat) {
		this.giangVienDat = giangVienDat;
	}

	public String getSucChuaToiDa() {
		return sucChuaToiDa;
	}

	public void setSucChuaToiDa(String sucChuaToiDa) {
		this.sucChuaToiDa = sucChuaToiDa;
	}

	public String getSucChuaToiThieu() {
		return sucChuaToiThieu;
	}

	public void setSucChuaToiThieu(String sucChuaToiThieu) {
		this.sucChuaToiThieu = sucChuaToiThieu;
	}

	public String getTinhTrangSanSang() {
		return tinhTrangSanSang;
	}

	public void setTinhTrangSanSang(String tinhTrangSanSang) {
		this.tinhTrangSanSang = tinhTrangSanSang;
	}
}
