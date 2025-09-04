package com.example.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:3000") // React runs on port 3000
public class Crudcontroller {

    @Autowired
    crudrepository repository;

    // Get all employees
    @GetMapping
    public List<Module> getAllEmployees() {
        return repository.findAll();
    }

    // Get single employee by id
    @GetMapping("/{id}")
    public Module getEmployee(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    // Add employee
    @PostMapping
    public Module addEmployee(@RequestBody Module module) {
        return repository.save(module);
    }

    // Update employee
    @PutMapping("/{id}")
    public Module updateEmployee(@PathVariable Long id, @RequestBody Module module) {
        Module existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setE_name(module.getE_name());
            existing.setE_salary(module.getE_salary());
            existing.setE_dept(module.getE_dept());
            return repository.save(existing);
        }
        return null;
    }

    // Delete employee
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
