package com.metacube.chanchal.communicationapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.TreeSet;

public class CompanyList extends MainActivity implements View.OnClickListener {

    ListView list;
    Toolbar toolbar;
    Button btnAddCompany;
    String companyCategory;
    View view;
    TreeSet<String> companies;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_list);
        //Setting up Action Bar
        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Company List");
        // Enable the Up button
        actionBar.setDisplayHomeAsUpEnabled(true);

        initializeCompanyList();

        list = (ListView)findViewById(R.id.companyList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1, companies.toArray(new String[companies.size()]) ){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text = (TextView) view.findViewById(android.R.id.text1);
                text.setTextColor(Color.BLACK);
                return view;
            }
        };
        list.setAdapter(adapter);
        //Defining on click on list item and passing index to next activity
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentShowIndex = new Intent(getApplicationContext(), ShowListIndex.class);
                intentShowIndex.putExtra("index", position);
                intentShowIndex.putExtra("company names", companies.toArray(new String[companies.size()]));
                startActivity(intentShowIndex);
            }
        });
        //Dialog with two buttons for delete list item on long item click
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder dialogDelete = new AlertDialog.Builder(CompanyList.this);
                // Setting Dialog Title
                dialogDelete.setTitle("Confirm Delete...");

                // Setting Dialog Message
                dialogDelete.setMessage("Are you sure you want to Delete the Company?");

                // Setting Icon to Dialog
                dialogDelete.setIcon(R.mipmap.delete);

                dialogDelete.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to invoke YES event
                        String currentCompany = companies.toArray(new String[companies.size()])[position];
                        Toast.makeText(getApplicationContext(), currentCompany.substring(0,currentCompany.indexOf("("))+" Deleted", Toast.LENGTH_SHORT).show();
                        companies.remove(currentCompany);
                        resetList();
                    }
                });

                // Setting Negative "NO" Button
                dialogDelete.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to invoke NO event
                        Toast.makeText(getApplicationContext(), "Delete Cancelled", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });

                // Showing Alert Message
                dialogDelete.show();
                return true;
            }
        });

        btnAddCompany = (Button) findViewById(R.id.btn_addcompany);
        btnAddCompany.setOnClickListener(this);     //go to onclick for add company
    }

    private void initializeCompanyList() {
        companies = new TreeSet<String>();
        //Creating initial Company List
        final String names[] = {
                "Google",
                "Microsoft",
                "Apple",
                "Samsung",
                "LG",
                "XOLO",
                "Sony",
                "Ferrari",
                "Twitter",
                "Harley Davidson"
        };
        final String categories[] = {
                "IT",
                "IT",
                "IT",
                "Electronics",
                "Mobile",
                "Mobile",
                "Electronics",
                "Car",
                "Social Network",
                "Bike"
        };
        for(int temp=0;temp<categories.length;temp++)
            companies.add(names[temp]+"("+categories[temp]+")");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.btn_addcompany:
                addCompanyDialog();       //calls method for add company form in a dialog box
                break;
            case R.id.btn_add_category:
                addCategoryDialog();
                break;
        }
    }
    //method for add company form dialog box
    public void addCompanyDialog() {
        final LayoutInflater inflater = getLayoutInflater();
        AlertDialog.Builder dialogAdd = new AlertDialog.Builder(CompanyList.this);
        dialogAdd.setTitle("Add new Company...");
        view = inflater.inflate(R.layout.dialog_add_form, null);

        dialogAdd.setView(view);

        Button categorySelect = (Button) view.findViewById(R.id.btn_add_category);
        setView(view);        //sets the add company form dialog box view to class variable view to make it accessible to add category dialog box
        categorySelect.setOnClickListener(this);
        dialogAdd.setView(view);            //set add company form dialog box view to dialog box message field as a custom layout

        final EditText companyTxt = (EditText) getView().findViewById(R.id.add_company_name);
        final EditText categoryTxt = (EditText) getView().findViewById(R.id.add_company_category);

        dialogAdd.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                if(validateAll(companyTxt,categoryTxt)) {
                    Toast.makeText(getApplicationContext(), companyTxt.getText().toString()+" added", Toast.LENGTH_SHORT).show();
                    companies.add(companyTxt.getText().toString() + "(" + categoryTxt.getText().toString() + ")");
                    System.out.println(companies);
                    resetList();
                }
                else
                    Toast.makeText(getApplicationContext(), "Field cannot be empty", Toast.LENGTH_SHORT).show();
            }
        });

        dialogAdd.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Adding Cancelled", Toast.LENGTH_SHORT).show();
            }
        });

        dialogAdd.show();
    }
    public void addCategoryDialog() {

        final String categ[] = {
                "IT",
                "Electronics",
                "Mobile",
                "Car",
                "Social Network",
                "Bike",
                "Food",
                "Travel",
                "Logistics",
                "Tyres",
                "Transportation",
                "Sports Equipment",
                "Water",
                "Electrical Equipments"
        };

        AlertDialog.Builder listDialog = new AlertDialog.Builder(CompanyList.this);
        listDialog.setTitle("Select Category");
        listDialog.setItems(categ, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "You selected " + categ[which], Toast.LENGTH_SHORT).show();
                companyCategory = categ[which];         //setting category String to class variable companyCategory(String)
                EditText categoryTxt = (EditText) getView().findViewById(R.id.add_company_category);
                categoryTxt.setText(companyCategory);       //setting the category to category textbox
            }
        });
        listDialog.show();
    }
    protected void resetList() {
        System.out.println("Inside reset");
        list.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, companies.toArray(new String[companies.size()]))
        {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
               // return super.getView(position, convertView, parent);
                View view = super.getView(position, convertView, parent);
                TextView text = (TextView) view.findViewById(android.R.id.text1);
                text.setTextColor(Color.BLACK);
                return view;
            }
        });
    }
    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
}
