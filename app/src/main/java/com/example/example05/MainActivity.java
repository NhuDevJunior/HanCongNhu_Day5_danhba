package com.example.example05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Contact>contactList;
    RecyclerView recyclerView;
    ContactAdapter contactAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rvlist);
        contactList=new ArrayList<>();
        contactList.add(new Contact("MRA","di động","1111111111","12/09/2019",false));
        contactList.add(new Contact("MRB","điện thoại","2222222222","12/09/2019",true));
        contactList.add(new Contact("MRC","di động","333333333","12/09/2019",true));
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getBaseContext(),LinearLayoutManager.VERTICAL,false);
        contactAdapter=new ContactAdapter(contactList);
        contactAdapter.setIonClickContact(new IonClickContact() {
            @Override
            public void onClickName(Contact contact) {
                Intent intent=new Intent(getBaseContext(),Detail.class);
                intent.putExtra("object",contact);
                startActivity(intent);
            }

            @Override
            public void onClickphone(Contact contact) {
                  // chuyen 1 object
                Intent intent=new Intent(getBaseContext(),Detail.class);
                intent.putExtra("object",contact);
                startActivity(intent);
            }
        });
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(contactAdapter);
    }

}
