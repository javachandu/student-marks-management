package com.cibt.app.ecommercesite.Controller;

import com.cibt.app.ecommercesite.Entity.Student;
import com.cibt.app.ecommercesite.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/public")
public class PublicController {
    
    @Autowired
    private StudentRepository studentRepository;


    @GetMapping(value = "/find")
    public String findById(@RequestParam ("rollNo")String rollNo, Model model){
        model.addAttribute("students", studentRepository.findByRollNo(rollNo));
        return "/public/studentDetails";
    }
}