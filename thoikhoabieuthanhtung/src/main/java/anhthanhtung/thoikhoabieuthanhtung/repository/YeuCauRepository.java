package anhthanhtung.thoikhoabieuthanhtung.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import anhthanhtung.thoikhoabieuthanhtung.model.YeuCau;
@Repository
public interface  YeuCauRepository extends JpaRepository <YeuCau , Long>{

}
