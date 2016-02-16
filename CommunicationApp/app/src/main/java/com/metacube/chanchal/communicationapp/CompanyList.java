package com.metacube.chanchal.communicationapp;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CompanyList extends AppCompatActivity {

    ListView list;
    Toolbar toolbar;
    Button btnAddCompany;
    @Override
    @TargetApi(21)
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_list);

        final LayoutInflater inflater = getLayoutInflater();

        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Company List");
        // Enable the Up button
        actionBar.setDisplayHomeAsUpEnabled(true);

        final String companies[] = {
                "Google",
                "Microsoft",
                "Apple",
                "Samsung",
                "Motorola",
                "LG",
                "XOLO",
                "Sony"
        };
        list = (ListView)findViewById(R.id.companyList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,companies){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text = (TextView) view.findViewById(android.R.id.text1);
                text.setTextColor(Color.BLACK);
                return view;
            }
        };
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentShowIndex = new Intent(getApplicationContext(), ShowListIndex.class);
                intentShowIndex.putExtra("index", position);
                intentShowIndex.putExtra("company names", companies);
                startActivity(intentShowIndex);
            }
        });

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder dialogDelete = new AlertDialog.Builder(CompanyList.this);
                // Setting Dialog Title
                dialogDelete.setTitle("Confirm Delete...");

                // Setting Dialog Message
                dialogDelete.setMessage("Are you sure you want to Delete the Company?");

                // Setting Icon to Dialog
                dialogDelete.setIcon(R.mipmap.delete);

                dialogDelete.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to invoke YES event
                        Toast.makeText(getApplicationContext(), "You clicked on YES", Toast.LENGTH_SHORT).show();
                    }
                });

                // Setting Negative "NO" Button
                dialogDelete.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to invoke NO event
                        Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });

                // Showing Alert Message
                dialogDelete.show();
                return true;
            }
        });
        btnAddCompany = (Button) findViewById(R.id.btn_addcompany);

       /* btnAddCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogAdd = new AlertDialog.Builder(getApplicationContext());
                //dialogAdd.setTitle("Add new Company...");

                dialogAdd.setView(inflater.inflate(R.layout.dialog_add_form,null))
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to invoke YES event
                        Toast.makeText(getApplicationContext(), "Add new", Toast.LENGTH_SHORT).show();
                    }
                })

                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to invoke YES event
                        Toast.makeText(getApplicationContext(), "Adding Cancelled", Toast.LENGTH_SHORT).show();
                    }
                });
                dialogAdd.show();
            }
        });*/
    }
}
