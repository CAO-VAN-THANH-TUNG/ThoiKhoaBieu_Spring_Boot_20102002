package anhthanhtung.thoikhoabieuthanhtung.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import anhthanhtung.thoikhoabieuthanhtung.model.KhoaHoc;
@Repository
public interface  KhoaHocRepository extends JpaRepository <KhoaHoc , Long>{

}



