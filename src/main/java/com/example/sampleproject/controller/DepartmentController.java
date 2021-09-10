package com.example.sampleproject.controller;

import com.example.sampleproject.errorHandling.DepartmentNotFoundException;
import com.example.sampleproject.entity.Department;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.sampleproject.services.DepartmentService;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    public DepartmentService departmentService;

    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(DepartmentController.class);

    @GetMapping()
    public List<Department> getAlldepartment(){
        LOGGER.info("All departments will be fetched from the Database");
        return departmentService.getAllDepartments();
    }

    @PostMapping()
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("All departments will be saved in the Database");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.getDepartmentById(departmentId);
    }

    @GetMapping("/{name}")
    public Department getDepartmentByName(@PathVariable("name") String name){
        return departmentService.getDepartmentByName(name);
    }
    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable("id") Long id) {
        departmentService.deleteDepartment(id);
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        return departmentService.updateDepartment(id, department);
    }
}
