package com.example.sampleproject.services;


import com.example.sampleproject.errorHandling.DepartmentNotFoundException;
import com.example.sampleproject.entity.Department;

import java.util.List;

public interface DepartmentService {

   public Department saveDepartment(Department department);

   public List<Department> getAllDepartments();

   public Department getDepartmentById(Long id) throws DepartmentNotFoundException;

   public void deleteDepartment(Long id);

   public Department updateDepartment(Long id, Department department);

   public Department getDepartmentByName(String name);


}
