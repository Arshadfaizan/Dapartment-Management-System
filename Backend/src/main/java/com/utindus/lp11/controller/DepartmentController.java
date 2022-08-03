package com.utindus.lp11.controller;

import com.utindus.lp11.entity.Department;
import com.utindus.lp11.error.DepartementNotFoundException;
import com.utindus.lp11.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER =
            LoggerFactory.getLogger(DepartmentController.class);
    @PostMapping("/departments/add")
    public Department saveDepartment(@Valid @RequestBody Department department){
       // DepartmentService service=new DepartmentService();
        LOGGER.info("Inside saveDepartment of DepartController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments/all")
    public List<Department> fetchDepartmentList()
    {
        LOGGER.info("Inside fetchDepartmentList of DepartController");
    return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentByID( @PathVariable("id") long departmentId)
            throws DepartementNotFoundException {
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/delete/{departmentId}" )
    public boolean  deleteDepartmentById(@PathVariable("departmentId") Long departmentId)
    {
//        departmentService.deleteDepartmentById(departmentId);
        return departmentService.deleteDepartmentById(departmentId);
    }
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> deleteDepartmentById(@PathVariable("id") Long departmentId) {
//        departmentService.deleteDepartmentById(departmentId);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
    @PutMapping("/departments/update")
    public Department updateDepartment( @RequestBody Department department)
    {
        return departmentService.updateDepartment(department);
    }
    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }

}
