package com.utindus.lp11.service;

import com.utindus.lp11.entity.Department;
import com.utindus.lp11.error.DepartementNotFoundException;
import com.utindus.lp11.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(long departmentId) throws DepartementNotFoundException {
        Optional<Department> department=departmentRepository.findById(departmentId);
        if(!department.isPresent())
        {
            throw new DepartementNotFoundException("Department Not available");
        }
        return department.get();

    }

    @Override
    public Department updateDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {

        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }

    @Override
    public Department fetchDepartmentByCode(String departmentCode) {
        return departmentRepository.findByDepartCode(departmentCode);
    }

    @Override
    public boolean deleteDepartmentById(Long departmentId) {
         departmentRepository.deleteById(departmentId);
        return false;
    }

}
