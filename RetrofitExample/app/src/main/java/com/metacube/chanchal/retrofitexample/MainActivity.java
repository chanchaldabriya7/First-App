package com.metacube.chanchal.retrofitexample;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.metacube.chanchal.retrofitexample.API.MyAPI;
import com.metacube.chanchal.retrofitexample.model.Example;
import com.metacube.chanchal.retrofitexample.model.Item;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    static final String BASE_URL = "https://api.stackexchange.com/";
    Toolbar toolbar;
    ListView listView;
    List<String> ques,links;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.my_actiontoolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Retrofit Example");

        ques = new ArrayList<String>();
        links = new ArrayList<String>();

        listView = (ListView) findViewById(R.id.list_questions);
        CustomListAdapterQuestions adapter = new CustomListAdapterQuestions(this,ques.toArray(new String[ques.size()]),links.toArray(new String[links.size()]));
        listView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btn_call_api:
                getResultFromAPI();
                return true;
            case R.id.btn_timer:
                Intent timerIntent = new Intent(getApplicationContext(),ActivityCountDownTimer.class);
                startActivity(timerIntent);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void getResultFromAPI() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MyAPI service = retrofit.create(MyAPI.class);
        Call<Example> call = service.getItems("stackoverflow", "android");

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if (response.isSuccess()) {
                    Example result = response.body();
                    List<Item> items = result.getItems();
                    for (int i = 0; i < items.size(); i++) {
                        Item temp = items.get(i);
                        ques.add(temp.getTitle());
                        links.add(temp.getLink());
                    }
                    refreshList();
                } else {
                    System.out.println("Call failed in else");
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                System.out.println("Call failed in onFailure");
            }
        });
    }
    private void refreshList() {
        listView.setAdapter(new CustomListAdapterQuestions(this,ques.toArray(new String[ques.size()]),links.toArray(new String[links.size()])));
    }
}
