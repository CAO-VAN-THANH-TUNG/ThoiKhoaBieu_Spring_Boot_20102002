package anhthanhtung.thoikhoabieuthanhtung.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import anhthanhtung.thoikhoabieuthanhtung.model.NgayNghi;
@Repository
public interface  NgayNghiRepository extends JpaRepository <NgayNghi , Long>{

}
