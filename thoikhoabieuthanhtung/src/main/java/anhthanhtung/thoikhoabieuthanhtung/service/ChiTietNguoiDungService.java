package anhthanhtung.thoikhoabieuthanhtung.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import anhthanhtung.thoikhoabieuthanhtung.model.ChiTietNguoiDung;
import anhthanhtung.thoikhoabieuthanhtung.model.NguoiDung;
import anhthanhtung.thoikhoabieuthanhtung.repository.NguoiDungRepository;

@Service
public class ChiTietNguoiDungService implements UserDetailsService {

    @Autowired
    NguoiDungRepository NguoiDungRepository;

    @Override
    public UserDetails loadUserByUsername(String tenNguoiDung) throws UsernameNotFoundException {
        Optional<NguoiDung> user = NguoiDungRepository.findByTenNguoiDung( tenNguoiDung);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + tenNguoiDung));

        return user.map(ChiTietNguoiDung::new).get();
    }
}