package anhthanhtung.thoikhoabieuthanhtung.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "nguoidung")
public class NguoiDung {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "tennguoidung")
	private String tenNguoiDung;
	
	@Column(name = "matkhau")
	private String matKhau;
	
	@Column(name = "quyenhan")
    private String quyenHan;

	public NguoiDung() {
		super();
	}

	public NguoiDung(String tenNguoiDung, String matKhau, String quyenHan) {
		super();
		this.tenNguoiDung = tenNguoiDung;
		this.matKhau = matKhau;
		this.quyenHan = quyenHan;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTenNguoiDung() {
		return tenNguoiDung;
	}

	public void setTenNguoiDung(String tenNguoiDung) {
		this.tenNguoiDung = tenNguoiDung;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getquyenHan() {
		return quyenHan;
	}

	public void setquyenHan(String quyenHan) {
		this.quyenHan = quyenHan;
	}
}

