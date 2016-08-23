package com.worklab.myannotation;

import java.util.List;

/**
 * Created by skywander on 8/23/16.
 */
public class MockDataDepartment implements MockData{
    private String name;
    private List<MockData> mockDataEmployees;

    public MockDataDepartment() {
    }

    public MockDataDepartment(String name, List<MockData> mockDataEmployees) {
        this.name = name;
        this.mockDataEmployees = mockDataEmployees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MockData> getMockDataEmployees() {
        return mockDataEmployees;
    }

    public void setMockDataEmployees(List<MockData> mockDataEmployees) {
        this.mockDataEmployees = mockDataEmployees;
    }
}
