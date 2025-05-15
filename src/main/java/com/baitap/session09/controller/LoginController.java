package com.baitap.session09.controller;

import com.baitap.session09.Service.CustomerServiceImp;
import com.baitap.session09.modal.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class LoginController {
    public CustomerServiceImp customerService = new CustomerServiceImp();

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("customer", new Customer());
        return "login";
    }
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {

        List<Customer> customers = customerService.getCustomers();
        System.out.println(customers + "123123123");
        if (customers == null) {
            customers = new ArrayList<>();
        }
        if (username.isEmpty() || password.isEmpty()) {
            model.addAttribute("error", "Thông tin đăng nhập không được để trống");
            return "login";
        }
        for (Customer customer : customers) {
            System.out.println(customer.getUsername());
        }
        Optional<Customer> isCheck = customers.stream()
                .filter(c -> c.getUsername().equals(username))
                .findFirst();
        if (isCheck.isPresent() && password.equals(isCheck.get().getPassword())) {
            model.addAttribute("error", "Đăng nhập thành công");
        } else {
            model.addAttribute("error", "Tài khoản hoặc mật khẩu không đúng");
        }

        return "login";
    }
}
