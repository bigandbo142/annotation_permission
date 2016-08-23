package com.worklab.myannotation;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skywander on 8/22/16.
 */
public class CompanyInfoAdapter extends RecyclerView.Adapter<CompanyInfoAdapter.ItemViewHolder> {

    private Context mContext;
    private List<MockData> mData;

    public class ItemViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_name;
        private RecyclerView rv_child_list;
        private CompanyInfoAdapter mAdapter;
        private boolean isExpanded = false;
        private MockData data;

        public ItemViewHolder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.name);
            rv_child_list = (RecyclerView) itemView.findViewById(R.id.rv_child_list);
            rv_child_list.setLayoutManager(new LinearLayoutManager(mContext));

            tv_name.setOnClickListener(view -> {

                Log.d("TEST", "expanded " + isExpanded);
                if(!isExpanded) {
                    expandChildList();
                }else{
                    collapseChildList();
                }
                isExpanded = !isExpanded;
            });
        }

        public void bindData(MockData pData){
            data = pData;
            if(data instanceof MockDataCompany){
                tv_name.setText(((MockDataCompany)data).getName());
            }else if(data instanceof MockDataDepartment){
                tv_name.setText(((MockDataDepartment)data).getName());
            }else{
                tv_name.setText(((MockDataEmployee)data).getName());
            }
        }

        private void expandChildList(){
            if(mAdapter == null){
                mAdapter = new CompanyInfoAdapter(mContext);
            }

            rv_child_list.setAdapter(mAdapter);
            if(data instanceof MockDataCompany){
                mAdapter.setDatas(((MockDataCompany)data).getMockDataDepartments());
            }else if(data instanceof MockDataDepartment){
                mAdapter.setDatas(((MockDataDepartment)data).getMockDataEmployees());
            }
            Log.d("TEST", "expanded 1 " + isExpanded);
        }

        private void collapseChildList(){
            rv_child_list.setAdapter(null);
            Log.d("TEST", "collapse 1 " + isExpanded);
        }
    }

    public CompanyInfoAdapter(Context pContext) {
        this.mContext = pContext;
        mData = new ArrayList<>();
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.companyinfo_item, parent, false);
        ItemViewHolder holder = new ItemViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.bindData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setDatas(List<MockData> pData){
        mData.clear();
        mData.addAll(pData);
        notifyDataSetChanged();
    }
}
