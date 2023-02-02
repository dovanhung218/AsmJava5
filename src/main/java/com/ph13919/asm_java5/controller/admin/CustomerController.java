package com.ph13919.asm_java5.controller.admin;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.ph13919.asm_java5.entity.Customer;
import com.ph13919.asm_java5.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
 @RequestMapping("/admin/customer")
@RequiredArgsConstructor
public class CustomerController {

     public final CustomerService customerService;

  @GetMapping("/list")
  public String list(Model model ) {
      model.addAttribute("customerList",customerService.getAll());
      return "admin/customer/index";
  }



    @GetMapping("/add")
    public String getAdd(Model model) {
      model.addAttribute("customer",new Customer());
        return "admin/customer/add";
    }
    @PostMapping("/add")
    public String add(@Valid  @ModelAttribute("customer") Customer customer, BindingResult result) {
        System.out.println("result");
        if (result.hasErrors()){
            return "admin/customer/add";
        }
        customerService.add(customer);
        return "redirect:/admin/customer/list";
    }



    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id,Model model) {
        model.addAttribute("customer",customerService.getById(id));
        return "admin/customer/detail";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id,Model model) {
      customerService.delete(id);
              return "redirect:/admin/customer/list";

    }
    @GetMapping("/searchByCode")
    public String SearchByCode(@ModelAttribute("code") String code,Model model ) {
        model.addAttribute("customerList",customerService.searchByCode(code));
        return "admin/customer/index";

    }

    @PostMapping("/update")
    public String update(@ModelAttribute("customer") Customer customer) {
         Customer entity = customerService.getByCode(customer.getCode());
        customer.setId(entity.getId());
        customerService.update(customer);
        return "redirect:/admin/customer/list";
    }



}



//
//
//
//
//    @GetMapping("/")
//    public String viewHomePage(Model model) {
//        model.addAttribute("listEmployees", employeeService.getAllEmployees());
//        return "index";
//    }
//
//    @GetMapping("/showNewEmployeeForm")
//    public String showNewEmployeeForm(Model model) {
//        // create model attribute to bind form data
//        Employee employee = new Employee();
//        model.addAttribute("employee", employee);
//        return "new_employee";
//    }
//
//    @PostMapping("/saveEmployee")
//    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
//        // save employee to database
//        employeeService.saveEmployee(employee);
//        return "redirect:/";
//    }
//
//    @GetMapping("/showFormForUpdate/{id}")
//    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
//
//        // get employee from the service
//        Employee employee = employeeService.getEmployeeById(id);
//
//        // set employee as a model attribute to pre-populate the form
//        model.addAttribute("employee", employee);
//        return "update_employee";
//    }
//
//    @GetMapping("/deleteEmployee/{id}")
//    public String deleteEmployee(@PathVariable(value = "id") long id) {
//
//        // call delete employee method
//        this.employeeService.deleteEmployeeById(id);
//        return "redirect:/";
//    }