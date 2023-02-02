package com.ph13919.asm_java5.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
 @RequestMapping("/admin")
public class AuthController {

  @GetMapping("/login")
  public String login(Model model ) {
    return "admin/auth/login";
  }
    @GetMapping("/reset-password")
    public String resetPassword(Model model ) {
        return "admin/auth/resetPassword";
    }

    @GetMapping("/change-password")
    public String changePassword(Model model ) {
        return "admin/auth/changePassword";
    }
}
