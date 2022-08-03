package com.utindus.lp11.repository;


import com.utindus.lp11.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    public Department findByDepartmentName(String departmentName);
    public Department findByDepartmentNameIgnoreCase(String departmentName);
    public Department findByDepartmentId(Long departmentId);
    public Department findByDepartCode(String code);

//    public Department deleteByDepartmentId(Long departmentId);
}
