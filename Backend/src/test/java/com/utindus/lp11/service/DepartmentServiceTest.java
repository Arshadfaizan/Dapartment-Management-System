package com.utindus.lp11.service;

import com.utindus.lp11.entity.Department;
import com.utindus.lp11.error.DepartementNotFoundException;
import com.utindus.lp11.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;
    @MockBean
    private DepartmentRepository departmentRepository;
    @BeforeEach
    void setUp() throws DepartementNotFoundException {
            Department department=
                    Department.builder()
                            .departmentName("IT")
                            .departmentAddress("hai")
                            .departmentId(1L)
                            .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn(department);

    }
    @Test
    @DisplayName("Get Data based on valid Department Name")
    public void  whenValidDepartmentName_thenDepartmentShouldFound() throws DepartementNotFoundException {
        String  departmentName="IT";
        Department found=departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName,found.getDepartmentName());

    }
}