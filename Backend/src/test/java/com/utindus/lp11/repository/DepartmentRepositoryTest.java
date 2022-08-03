package com.utindus.lp11.repository;

import com.utindus.lp11.entity.Department;
import com.utindus.lp11.error.DepartementNotFoundException;
import com.utindus.lp11.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;
    @BeforeEach
      void setup(){
        Department department= Department.builder()
                .departmentName("Ece")
                .departmentCode("ee001")
                .departmentAddress("hyd")
//                .departmentId(1L)
                .build();
                entityManager.persist(department);
    }

// @Test
//    public void  whenFindById_thenReturnDepartment() throws DepartementNotFoundException {
//        String code="ee001"
//        Department department=departmentRepository.findByID(1L).get();
//        assertEquals(department.getDepartmentId(),1L);
//
//    }
}