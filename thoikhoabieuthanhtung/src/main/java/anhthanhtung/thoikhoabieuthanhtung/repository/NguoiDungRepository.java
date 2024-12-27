package anhthanhtung.thoikhoabieuthanhtung.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import anhthanhtung.thoikhoabieuthanhtung.model.NguoiDung;
@Repository
public interface  NguoiDungRepository extends JpaRepository <NguoiDung , Long>{
    Optional<NguoiDung> findByTenNguoiDung(String tenNguoiDung);
}
