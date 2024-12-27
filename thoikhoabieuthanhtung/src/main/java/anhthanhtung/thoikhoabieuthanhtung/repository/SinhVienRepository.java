















package anhthanhtung.thoikhoabieuthanhtung.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import anhthanhtung.thoikhoabieuthanhtung.model.SinhVien;
@Repository
public interface  SinhVienRepository extends JpaRepository <SinhVien , Long>{

}