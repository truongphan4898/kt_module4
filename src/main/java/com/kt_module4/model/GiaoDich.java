package com.kt_module4.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Entity
@Data
public class GiaoDich {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maGiaoDich;

    @ManyToOne
    @JoinColumn(name = "ma_khach_hang")
    private KhachHang khachHang;

    private String ngayGiaoDich;

    private String loaiDichVu;
    @Min(value = 50000, message = "đơn giá phải lớn hơn 50000VND")
    private Double donGia;
    @Min(value = 20, message = "diện tích giao dịch phải lớn hơn 20m2")
    private Double dienTich;
}
