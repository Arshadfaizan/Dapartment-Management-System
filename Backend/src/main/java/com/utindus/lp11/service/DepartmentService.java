package com.utindus.lp11.service;

import com.utindus.lp11.entity.Department;
import com.utindus.lp11.error.DepartementNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);
   public  List<Department> fetchDepartmentList();
   public  Department fetchDepartmentById(long departmentId) throws DepartementNotFoundException;
   public Department updateDepartment( Department department);
   public Department fetchDepartmentByName(String departmentName);
   public Department fetchDepartmentByCode(String departmentCode);
   public boolean deleteDepartmentById(Long departmentId);
}
