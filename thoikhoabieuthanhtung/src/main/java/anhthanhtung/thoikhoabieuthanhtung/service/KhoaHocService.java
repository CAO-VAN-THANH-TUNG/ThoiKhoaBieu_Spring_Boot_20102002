package anhthanhtung.thoikhoabieuthanhtung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import anhthanhtung.thoikhoabieuthanhtung.model.KhoaHoc;
import anhthanhtung.thoikhoabieuthanhtung.repository.KhoaHocRepository;
@Service
public class KhoaHocService {
@Autowired KhoaHocRepository khoaHocRepository;
    public List<KhoaHoc> findAll(){
  return khoaHocRepository.findAll();
    }
}
