package com.worklab.myannotation;

import java.util.List;

/**
 * Created by skywander on 8/23/16.
 */
public class MockDataCompany implements MockData{
    private String name;
    private List<MockData> mockDataDepartments;

    public MockDataCompany() {
    }

    public MockDataCompany(String name) {
        this.name = name;
    }

    public MockDataCompany(String name, List<MockData> mockDataDepartments) {
        this.name = name;
        this.mockDataDepartments = mockDataDepartments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MockData> getMockDataDepartments() {
        return mockDataDepartments;
    }

    public void setMockDataDepartments(List<MockData> mockDataDepartments) {
        this.mockDataDepartments = mockDataDepartments;
    }
}
