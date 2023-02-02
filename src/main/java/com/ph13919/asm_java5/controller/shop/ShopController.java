package com.ph13919.asm_java5.controller.shop;

import com.ph13919.asm_java5.entity.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ShopController {

  @GetMapping("/")
  public String home(Model model ) {
    model.addAttribute("hello","kakakkakfdjfdhfdfd");
    Customer customer =  Customer.builder().address("hihi").build();
    return "shop/home";
  }
  @GetMapping("/about")
  public String about() {
    return "shop/about";
  }
  @GetMapping("/contact")
  public String contact() {
    return "shop/contact";
  }
  @GetMapping("/size")
  public String size() {
    return "shop/size";
  }
  @GetMapping("/cart")
  public String cart() {
    return "shop/cart";
  }
  @GetMapping("/account")
  public String account() {
    return "shop/account";
  }


}
