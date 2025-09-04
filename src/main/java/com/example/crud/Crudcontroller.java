package com.example.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class Crudcontroller {

    @Autowired
    crudrepository repository;

    // Get all employees
    
    @GetMapping("/home/new")
    public String gohome(Model model) {
    	
    	model.addAttribute("employee", new Module());
    	return "new";
    	
    }
    
    @PostMapping("/enter")
    public String goenter(Model model,@ModelAttribute("employee") Module module) {
    	repository.save(module);
    	return "redirect:/home";
    }
    
    @GetMapping("/home")
    public String gorelate(Model model) {
    	model.addAttribute("employee",repository.findAll());
    	return "employer";
    	
    }
    @GetMapping("/update/{id}")
    public String goVAriant(Model model,@PathVariable Long id) {
    	model.addAttribute("model", repository.findById(id).get());
    	return "edit";
    	
    }
   
    @PostMapping("/edit/{id}")
    public String goedit(@ModelAttribute("model") Module module,@PathVariable Long id) {
    	Module modules=repository.findById(id).get();
    	modules.setE_dept(module.getE_dept());
    	modules.setE_name(module.getE_name());
    	modules.setE_salary(module.getE_salary());
    	repository.save(modules);
    	return "redirect:/home";
    }
    @GetMapping("/delete/{id}")
    public String godelete(@PathVariable Long id) {
    	repository.deleteById(id);
    	return "redirect:/home";
    }
    
}
