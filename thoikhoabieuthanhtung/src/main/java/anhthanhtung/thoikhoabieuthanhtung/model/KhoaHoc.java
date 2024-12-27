package anhthanhtung.thoikhoabieuthanhtung.model;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "khoa_hoc")
public class KhoaHoc {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
		
	@Column(name = "ten_khoa_hoc")
	private String tenKhoaHoc;
	
	@Column(name = "so_giao_vien")
	private String soGiaoVien;
	
	@Column(name = "ngay_bat_dau")
	private String ngayBatDau;
	
	@Column(name = "tong_so_sinh_vien")
	private String tongSoSinhVien;
	
	@Column(name = "ma_khoa_hoc")
	private String maKhoaHoc;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTenKhoaHoc() {
		return tenKhoaHoc;
	}

	public void setTenKhoaHoc(String tenKhoaHoc) {
		this.tenKhoaHoc = tenKhoaHoc;
	}

	public String getSoGiaoVien() {
		return soGiaoVien;
	}

	public void setSoGiaoVien(String soGiaoVien) {
		this.soGiaoVien = soGiaoVien;
	}

	public String getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(String ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public String getTongSoSinhVien() {
		return tongSoSinhVien;
	}

	public void setTongSoSinhVien(String tongSoSinhVien) {
		this.tongSoSinhVien = tongSoSinhVien;
	}

	public String getMaKhoaHoc() {
		return maKhoaHoc;
	}

	public void setMaKhoaHoc(String maKhoaHoc) {
		this.maKhoaHoc = maKhoaHoc;
	}
	
}
