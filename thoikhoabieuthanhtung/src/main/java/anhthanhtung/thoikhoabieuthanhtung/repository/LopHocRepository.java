package anhthanhtung.thoikhoabieuthanhtung.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import anhthanhtung.thoikhoabieuthanhtung.model.LopHoc;
@Repository
public interface  LopHocRepository extends JpaRepository <LopHoc , Long>{

}
