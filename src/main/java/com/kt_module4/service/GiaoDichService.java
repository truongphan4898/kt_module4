package com.kt_module4.service;

import com.kt_module4.model.GiaoDich;
import com.kt_module4.repository.GiaoDichRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiaoDichService implements IGiaoDichService{
    @Autowired
    private GiaoDichRepository giaoDichRepository;

    @Override
    public List<GiaoDich> findAll() {
        return giaoDichRepository.findAll();
    }

    @Override
    public GiaoDich findById(Long id) {
        return giaoDichRepository.findById(id).orElse(null);
    }

    @Override
    public void save(GiaoDich giaoDich) {
        giaoDichRepository.save(giaoDich);
    }

    @Override
    public void remove(Long id) {
        giaoDichRepository.deleteById(id);
    }

    @Override
    public List<GiaoDich> findByLoaiDichVuContainingOrKhachHang_TenKhachHangContaining(String loaiDichVu, String tenKhachHang) {
        return giaoDichRepository.findByLoaiDichVuContainingOrKhachHang_TenKhachHangContaining(loaiDichVu,tenKhachHang);
    }
}
