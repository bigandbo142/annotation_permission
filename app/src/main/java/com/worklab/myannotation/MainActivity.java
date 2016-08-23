package com.worklab.myannotation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_company_list;
    private CompanyInfoAdapter mAdatper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_company_list = (RecyclerView) findViewById(R.id.rv_company_list);
        mAdatper = new CompanyInfoAdapter(this);
        rv_company_list.setLayoutManager(new LinearLayoutManager(this));
        rv_company_list.setAdapter(mAdatper);
        mAdatper.setDatas(mockData());
    }

    private List<MockData> mockData(){
        List<MockData> mockDataCompanies = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            List<MockData> mockDataDepartments = new ArrayList<>();
            MockDataCompany newMockCompany = new MockDataCompany();
            newMockCompany.setName("Com " + (i + 1));
            for (int j = 0; j < 10; j++){
                List<MockData> mockDataEmployees = new ArrayList<>();
                MockDataDepartment newMockDepartment = new MockDataDepartment();
                newMockDepartment.setName("Dep " + (j + 1));
                for (int k = 0; k < 10; k++){
                    MockDataEmployee newDataEmployee = new MockDataEmployee("Emp " + (k + 1));
                    mockDataEmployees.add(newDataEmployee);
                }
                newMockDepartment.setMockDataEmployees(mockDataEmployees);
                mockDataDepartments.add(newMockDepartment);

            }
            newMockCompany.setMockDataDepartments(mockDataDepartments);
            mockDataCompanies.add(newMockCompany);
        }

        return mockDataCompanies;
    }
}
