package com.kt_module4.repository;

import com.kt_module4.model.GiaoDich;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiaoDichRepository extends JpaRepository<GiaoDich,Long> {
    List<GiaoDich> findByLoaiDichVuContainingOrKhachHang_TenKhachHangContaining(String loaiDichVu, String tenKhachHang);
}
