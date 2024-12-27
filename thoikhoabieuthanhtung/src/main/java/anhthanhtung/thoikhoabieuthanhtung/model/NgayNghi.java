package anhthanhtung.thoikhoabieuthanhtung.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "ngay_nghi")
public class NgayNghi {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "ngay_nghi")
	private String ngayNghi;
	

	@Column(name = "ten_ngay_nghi")
	private String tenNgayNghi;
	@Column(name = "mo_hinh_giang_day")
	private String moHinhGiangDay ;

	@Column(name = "giao_vien_yeu_cau")
	private String giaoVienYeuCau;
	
	public NgayNghi() {
		super();
	}

	public NgayNghi(String ngayNghi, String tenNgayNghi, String giaoVienYeuCau,String moHinhGiangDay) {
		super();
		this.ngayNghi = ngayNghi;
		this.tenNgayNghi = tenNgayNghi;
		this.giaoVienYeuCau = giaoVienYeuCau;
		this.moHinhGiangDay= moHinhGiangDay;
	}

	public String getGiaoVienYeuCau() {
		return giaoVienYeuCau;
	}

	public void setGiaoVienYeuCau(String giaoVienYeuCau) {
		this.giaoVienYeuCau = giaoVienYeuCau;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getMoHinhGiangDay() {
		return moHinhGiangDay;
	}

	public void setMoHinhGiangDay(String moHinhGiangDay) {
		this.moHinhGiangDay = moHinhGiangDay;
	}
	public String getNgayNghi() {
		return ngayNghi;
	}

	public void setNgayNghi(String ngayNghi) {
		this.ngayNghi = ngayNghi;
	}

	public String getTenNgayNghi() {
		return tenNgayNghi;
	}

	public void setTenNgayNghi(String tenNgayNghi) {
		this.tenNgayNghi = tenNgayNghi;
	}
}