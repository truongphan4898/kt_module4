package com.kt_module4.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maKhachHang;
    private String tenKhachHang;
    private String soDienThoai;
    private String email;

    @OneToMany(mappedBy = "khachHang", cascade = CascadeType.ALL)
    private List<GiaoDich> giaoDichList;
}