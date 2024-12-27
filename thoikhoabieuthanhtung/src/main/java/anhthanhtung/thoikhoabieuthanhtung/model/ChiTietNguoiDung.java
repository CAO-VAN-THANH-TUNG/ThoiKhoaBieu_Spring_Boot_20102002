package anhthanhtung.thoikhoabieuthanhtung.model;



import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class ChiTietNguoiDung implements UserDetails {

	private final String tenNguoiDung;
    private final String matKhau;
    private final  List<GrantedAuthority> quyenHan;

    public ChiTietNguoiDung(NguoiDung nguoiDung) {
        this.tenNguoiDung = nguoiDung.getTenNguoiDung();
        this.matKhau = nguoiDung.getMatKhau();
        this.quyenHan = Arrays.stream(nguoiDung.getquyenHan().split(","))
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return quyenHan;
    }

    @Override
    public String getPassword() {
        return matKhau;
    }

    @Override
    public String getUsername() {
        return tenNguoiDung;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

