package anhthanhtung.thoikhoabieuthanhtung.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import anhthanhtung.thoikhoabieuthanhtung.model.PhongHoc;
@Repository
public interface  PhongHocRepository extends JpaRepository <PhongHoc , Long>{

}
