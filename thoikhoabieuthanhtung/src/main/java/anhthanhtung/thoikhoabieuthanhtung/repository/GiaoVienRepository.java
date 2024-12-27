package anhthanhtung.thoikhoabieuthanhtung.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import anhthanhtung.thoikhoabieuthanhtung.model.GiaoVien;
@Repository
public interface  GiaoVienRepository extends JpaRepository <GiaoVien , Long>{

}
