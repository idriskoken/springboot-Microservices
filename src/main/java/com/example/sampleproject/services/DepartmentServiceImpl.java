package com.example.sampleproject.services;

import com.example.sampleproject.errorHandling.DepartmentNotFoundException;
import com.example.sampleproject.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sampleproject.repository.DepartmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    public DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) throws DepartmentNotFoundException {

        Optional<Department> department = departmentRepository.findById(id);
        if(!department.isPresent()) {
            throw new DepartmentNotFoundException("Department does not exist!!");
        }
        return department.get();
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        Department depexists = departmentRepository.getOne(department.getDepartmentId());

        return null ;
    }

    @Override
    public Department getDepartmentByName(String name) {
        return departmentRepository.findByDepartmentName(name);
    }
}
