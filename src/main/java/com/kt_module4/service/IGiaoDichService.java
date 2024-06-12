package com.kt_module4.service;

import com.kt_module4.model.GiaoDich;

import java.util.List;

public interface IGiaoDichService {
    List<GiaoDich> findAll();
    GiaoDich findById(Long id);
    void save(GiaoDich giaoDich);
    void remove(Long id);
    List<GiaoDich> findByLoaiDichVuContainingOrKhachHang_TenKhachHangContaining(String loaiDichVu, String tenKhachHang);

}
