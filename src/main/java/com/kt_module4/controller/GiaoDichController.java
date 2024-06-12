package com.kt_module4.controller;

import com.kt_module4.model.GiaoDich;
import com.kt_module4.model.KhachHang;
import com.kt_module4.service.GiaoDichService;
import com.kt_module4.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GiaoDichController {
    @Autowired
    private GiaoDichService giaoDichService;

    @Autowired
    private KhachHangService khachHangService;

    @GetMapping("/")
    public String index(Model model, @RequestParam(value = "query", required = false) String query) {
        List<GiaoDich> transactions;
        if (query != null && !query.isEmpty()) {
            transactions = giaoDichService.findByLoaiDichVuContainingOrKhachHang_TenKhachHangContaining(query,query);
        } else {
            transactions = giaoDichService.findAll();
        }
        model.addAttribute("transactions", transactions);
        return "index";
    }

    @GetMapping("/transaction/{id}")
    public String transactionDetail(@PathVariable Long id, Model model) {
        GiaoDich transaction = giaoDichService.findById(id);
        model.addAttribute("transaction", transaction);
        return "transaction_detail";
    }

    @GetMapping("/add_transaction")
    public String addTransactionForm(Model model) {
        List<KhachHang> customers = khachHangService.findAll();
        model.addAttribute("customers", customers);
        return "add_transaction";
    }

    @PostMapping("/add_transaction")
    public String addTransaction(@ModelAttribute GiaoDich giaoDich) {
        giaoDichService.save(giaoDich);
        return "redirect:/";
    }
    @GetMapping("/delete_transaction/{id}")
    public String deleteTransaction(@PathVariable Long id) {
        giaoDichService.remove(id);
        return "redirect:/";
    }
}
