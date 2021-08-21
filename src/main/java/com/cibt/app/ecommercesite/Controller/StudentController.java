package com.cibt.app.ecommercesite.Controller;

import com.cibt.app.ecommercesite.Entity.Product;
import com.cibt.app.ecommercesite.Entity.Student;
import com.cibt.app.ecommercesite.Repository.ProductRepository;
import com.cibt.app.ecommercesite.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
    
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping()
    public String index(Model model){
        model.addAttribute("students", studentRepository.findAll());
        return "/student/index";
    }

    @GetMapping(value = "/json")
    @ResponseBody
    public List<Student> json(){
        return studentRepository.findAll();
    }


    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id")int id){
        studentRepository.deleteById(id);
        return "redirect:/product?success";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable("id")int id ,
     Model model){

       model.addAttribute("products", studentRepository.findById(id).get());
        return "/product/edit";
    }

    @PostMapping()
    public String save(Student product){
        studentRepository.save(product);
        return "redirect:/student?success";
    }

    @GetMapping(value = "/create")
    public String create(){
        return "/student/table";
    }

    @GetMapping(value = "/error")
    public String errorpage(){
        return "/student/error";
    }
}