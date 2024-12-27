-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: localhost:3307
-- Thời gian đã tạo: Th12 20, 2024 lúc 05:37 AM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `thoikhoabieudb`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `giaovien`
--

CREATE TABLE `giaovien` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gioi_tinh` varchar(255) DEFAULT NULL,
  `ma_nhan_vien` varchar(255) DEFAULT NULL,
  `mat_khau` varchar(255) DEFAULT NULL,
  `mo_hinh_giang_day` varchar(255) DEFAULT NULL,
  `ngay_sinh` varchar(255) DEFAULT NULL,
  `so_dien_thoai` varchar(255) DEFAULT NULL,
  `ten_dang_nhap` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `giaovien`
--

INSERT INTO `giaovien` (`id`, `email`, `gioi_tinh`, `ma_nhan_vien`, `mat_khau`, `mo_hinh_giang_day`, `ngay_sinh`, `so_dien_thoai`, `ten_dang_nhap`) VALUES
(7, 'tung123@donga.edu.vn', 'male', '1', '123', 'thanhtung', '2024-11-14', '123', 'tung'),
(8, 'caotunh92@gmail.com', 'female', '2002', '12345', 'cao', '2024-11-14', '12345', 'tùng'),
(9, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(10, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(12, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(13, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(14, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khoa_hoc`
--

CREATE TABLE `khoa_hoc` (
  `id` bigint(20) NOT NULL,
  `ma_khoa_hoc` varchar(255) DEFAULT NULL,
  `ngay_bat_dau` varchar(255) DEFAULT NULL,
  `so_giao_vien` varchar(255) DEFAULT NULL,
  `ten_khoa_hoc` varchar(255) DEFAULT NULL,
  `tong_so_sinh_vien` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `khoa_hoc`
--

INSERT INTO `khoa_hoc` (`id`, `ma_khoa_hoc`, `ngay_bat_dau`, `so_giao_vien`, `ten_khoa_hoc`, `tong_so_sinh_vien`) VALUES
(1, 'KH001', '2024-01-15', '3', 'Lập trình Java', '50'),
(2, 'KH002', '2024-02-01', '2', 'Thiết kế Web', '40'),
(3, 'KH003', '2024-03-10', '4', 'Cơ sở dữ liệu', '45'),
(4, 'KH004', '2024-04-05', '5', 'Khoa học dữ liệu', '60'),
(5, 'KH005', '2024-05-20', '3', 'Học máy và AI', '55');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lop_hoc`
--

CREATE TABLE `lop_hoc` (
  `id` bigint(20) NOT NULL,
  `dia_diem` varchar(255) DEFAULT NULL,
  `hoc_phan` varchar(255) DEFAULT NULL,
  `khoa` varchar(255) DEFAULT NULL,
  `loai_bang_cap` varchar(255) DEFAULT NULL,
  `ngay` varchar(255) DEFAULT NULL,
  `ten_giang_vien` varchar(255) DEFAULT NULL,
  `thoi_gian_bat_dau` varchar(255) DEFAULT NULL,
  `thoi_gian_ket_thuc` varchar(255) DEFAULT NULL,
  `thu` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `lop_hoc`
--

INSERT INTO `lop_hoc` (`id`, `dia_diem`, `hoc_phan`, `khoa`, `loai_bang_cap`, `ngay`, `ten_giang_vien`, `thoi_gian_bat_dau`, `thoi_gian_ket_thuc`, `thu`) VALUES
(9, 'Phòng 303', 'Cơ sở dữ liệu', 'Công Nghệ Thông Tin', 'Cử nhân', '2024-01-17', 'Phạm Văn C', '12:00', '15:00', 'Thứ Tư'),
(10, 'Phòng 404', 'Khoa học dữ liệu', 'Công Nghệ Thông Tin', 'Thạc sĩ', '2024-01-18', 'Lê Thị D', '15:00', '17:00', 'Thứ Năm'),
(11, 'Phòng 505', 'Học máy và AI', 'Công Nghệ Thông Tin', 'Thạc sĩ', '2024-01-19', 'Nguyễn Văn E', '09:00', '11:00', 'Thứ Sáu'),
(14, '11:30', 'trí tuệ nhân tạo ', 'công nghệ thông tin', 'tinhTrangSanSan', '2', 'tùng', '12:30', '', '2'),
(15, '12:30', 'lập trình web1', 'công nghệ thông tin', 'sẵn sàng', '2', 'anh thanh tùng', '12:00', NULL, '2');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ngay_nghi`
--

CREATE TABLE `ngay_nghi` (
  `id` bigint(20) NOT NULL,
  `giao_vien_yeu_cau` varchar(255) DEFAULT NULL,
  `ngay_nghi` varchar(255) DEFAULT NULL,
  `ten_ngay_nghi` varchar(255) DEFAULT NULL,
  `mo_hinh_giang_day` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `ngay_nghi`
--

INSERT INTO `ngay_nghi` (`id`, `giao_vien_yeu_cau`, `ngay_nghi`, `ten_ngay_nghi`, `mo_hinh_giang_day`) VALUES
(1, 'Nguyễn Văn A', '2024-02-10', 'Tết Nguyên Đán', 'Lập trình Java'),
(2, 'Trần Thị B', '2024-04-30', 'Ngày Giải phóng', 'Trí Tuệ Nhân Tạo'),
(3, 'Phạm Văn C', '2024-05-01', 'Ngày Quốc tế Lao động', NULL),
(4, 'Lê Thị D', '2024-09-02', 'Ngày Quốc khánh', NULL),
(5, 'Nguyễn Văn E', '2024-12-31', 'Nghỉ Tết Dương lịch', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nguoidung`
--

CREATE TABLE `nguoidung` (
  `id` bigint(20) NOT NULL,
  `matkhau` varchar(255) DEFAULT NULL,
  `quyenhan` varchar(255) DEFAULT NULL,
  `tennguoidung` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nguoidung`
--

INSERT INTO `nguoidung` (`id`, `matkhau`, `quyenhan`, `tennguoidung`) VALUES
(2, '20102002', 'SinhVien', 'tung101282@donga.edu.vn'),
(6, '20102002', 'giaoVien', 'tung101283@donga.edu.vn'),
(12, '20102002', 'admin', 'tung101284@donga.edu.vn'),
(15, NULL, 'giaoVien', NULL),
(16, NULL, 'giaoVien', NULL),
(17, NULL, 'giaoVien', NULL),
(18, NULL, 'giaoVien', NULL),
(19, NULL, 'giaoVien', NULL),
(20, NULL, 'giaoVien', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phonghoc`
--

CREATE TABLE `phonghoc` (
  `id` bigint(20) NOT NULL,
  `giang_vien_dat` varchar(255) DEFAULT NULL,
  `ngay_dat` varchar(255) DEFAULT NULL,
  `so_phong` varchar(255) DEFAULT NULL,
  `suc_chua_toi_da` varchar(255) DEFAULT NULL,
  `suc_chua_toi_thieu` varchar(255) DEFAULT NULL,
  `tang` varchar(255) DEFAULT NULL,
  `thoi_gian_bat_dau` varchar(255) DEFAULT NULL,
  `thoi_gian_ket_thuc` varchar(255) DEFAULT NULL,
  `tinh_trang_san_sang` varchar(255) DEFAULT NULL,
  `trang_thai` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `phonghoc`
--

INSERT INTO `phonghoc` (`id`, `giang_vien_dat`, `ngay_dat`, `so_phong`, `suc_chua_toi_da`, `suc_chua_toi_thieu`, `tang`, `thoi_gian_bat_dau`, `thoi_gian_ket_thuc`, `tinh_trang_san_sang`, `trang_thai`) VALUES
(1, 'Nguyễn Văn A', '2024-11-15', '101', '50', '20', '1', '08:00', '10:00', 'Sẵn sàng', 'Đang sử dụng'),
(2, 'caovanthanhtung', '29/11/2024', '202', '60', '30', '2', '9', '11', '2', '1'),
(3, 'Lê Thị B', '2024-11-16', '305', '40', '20', '3', '09:00', '12:00', 'Sẵn sàng', 'Đang sử dụng'),
(5, 'Phạm Văn C', '2024-11-17', '403', '35', '15', '4', '14:00', '16:00', 'Sẵn sàng', 'Đang sử dụng'),
(10, 'thanhtung', '', '202', '60', '30', '2', NULL, NULL, 'unavailable', 'booked'),
(12, 'thanhtung', '', '202', '60', '30', '2', NULL, NULL, 'unavailable', 'pending'),
(14, '', '', '202', '60', '30', '2', NULL, NULL, 'unavailable', 'pending'),
(15, '', '2024-11-15', '101', '50', '20', '1', NULL, NULL, 'unavailable', 'booked'),
(16, 'thanhtung', '2024-11-15', '101', '50', '20', '1', NULL, NULL, 'unavailable', 'booked'),
(17, 'tung', '2024-11-15', '101', '50', '20', '1', NULL, NULL, 'unavailable', 'booked'),
(18, 'tung101282@donga.edu.vn', '2024-11-15', '101', '50', '20', '1', NULL, NULL, 'unavailable', 'booked'),
(19, 'tung', '2024-11-15', '105', '50', '20', '1', NULL, NULL, 'unavailable', 'booked'),
(20, 'caotunh@gmail.com', '2024-11-15', '101', '50', '20', '1', NULL, NULL, 'unavailable', 'booked'),
(21, 'caotunh92@gmail.com', '2024-11-15', '101', '50', '20', '1', NULL, NULL, 'unavailable', 'booked'),
(22, 'thanhtung', '2024-11-15', '102', '50', '20', '1', NULL, NULL, 'unavailable', 'pending'),
(23, 'caotunh92@gmail.com', '2024-11-15', '101', '50', '20', '1', NULL, NULL, 'unavailable', 'booked'),
(24, 'caotunh92@gmail.com', '2024-11-15', '101', '50', '20', '1', NULL, NULL, 'unavailable', 'booked'),
(25, 'caotunh@gmail.com', '2024-11-15', '103', '50', '20', '1', NULL, NULL, 'unavailable', 'pending'),
(26, '', '2024-11-15', '101', '50', '20', '1', NULL, NULL, 'unavailable', 'pending'),
(27, 'caotunh92@gmail.com', '2024-11-15', '101', '50', '20', '1', NULL, NULL, 'unavailable', 'pending'),
(28, 'tung101283@donga.edu.vn', '2024-11-15', '101', '50', '20', '1', NULL, NULL, 'unavailable', 'pending');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sinhvien`
--

CREATE TABLE `sinhvien` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gioi_tinh` varchar(255) DEFAULT NULL,
  `khoa_hoc` varchar(255) DEFAULT NULL,
  `ma_sinh_vien` varchar(255) DEFAULT NULL,
  `mat_khau` varchar(255) DEFAULT NULL,
  `ngay_sinh` varchar(255) DEFAULT NULL,
  `so_dien_thoai` varchar(255) DEFAULT NULL,
  `ten_dang_nhap` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `sinhvien`
--

INSERT INTO `sinhvien` (`id`, `email`, `gioi_tinh`, `khoa_hoc`, `ma_sinh_vien`, `mat_khau`, `ngay_sinh`, `so_dien_thoai`, `ten_dang_nhap`) VALUES
(1, 'tung101282@donga.edu.vn', NULL, '', 'thanhtung', '', '2002-09-10', '0932569302', 'thanhtung'),
(2, 'tung101282@donga.edu.vn', 'male', 'tung', 'thanhtung', '20102002', '2024-11-11', '0932569302', 'thanhtung'),
(3, 'tung101282@donga.edu.vn', NULL, '', '', '20102002', '', '', ''),
(4, 'tung101282@donga.edu.vn', NULL, '', '', '20102002', '', '', ''),
(5, 'tung101282@donga.edu.vn', 'male', 'tung', 't', '20102002', '2024-11-12', '42', 't'),
(6, 'tung101282@donga.edu.vn', 'male', 'tung', 'ed', '20102002', '2024-11-14', '33', 'abc');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `yeu_cau`
--

CREATE TABLE `yeu_cau` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `mo_ta` varchar(255) DEFAULT NULL,
  `ten` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `yeu_cau`
--

INSERT INTO `yeu_cau` (`id`, `email`, `mo_ta`, `ten`) VALUES
(1, 'nguyenvana@example.com', 'Yêu cầu hỗ trợ về phòng học.', 'Nguyễn Văn A'),
(2, 'tranthib@example.com', 'Cần phòng học có sức chứa lớn cho buổi hội thảo.', 'Trần Thị B'),
(3, 'levanc@example.com', 'Yêu cầu thay đổi thời gian đặt phòng.', 'Lê Văn C'),
(4, 'phamthid@example.com', 'Hỗ trợ về trang thiết bị trong phòng.', 'Phạm Thị D'),
(5, 'dothane@example.com', 'Cần thêm máy chiếu trong phòng.', 'Đỗ Thanh E'),
(6, '', '', '');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `giaovien`
--
ALTER TABLE `giaovien`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `khoa_hoc`
--
ALTER TABLE `khoa_hoc`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `lop_hoc`
--
ALTER TABLE `lop_hoc`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `ngay_nghi`
--
ALTER TABLE `ngay_nghi`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `nguoidung`
--
ALTER TABLE `nguoidung`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `phonghoc`
--
ALTER TABLE `phonghoc`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `sinhvien`
--
ALTER TABLE `sinhvien`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `yeu_cau`
--
ALTER TABLE `yeu_cau`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `giaovien`
--
ALTER TABLE `giaovien`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `khoa_hoc`
--
ALTER TABLE `khoa_hoc`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `lop_hoc`
--
ALTER TABLE `lop_hoc`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT cho bảng `ngay_nghi`
--
ALTER TABLE `ngay_nghi`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `nguoidung`
--
ALTER TABLE `nguoidung`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT cho bảng `phonghoc`
--
ALTER TABLE `phonghoc`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT cho bảng `sinhvien`
--
ALTER TABLE `sinhvien`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `yeu_cau`
--
ALTER TABLE `yeu_cau`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
