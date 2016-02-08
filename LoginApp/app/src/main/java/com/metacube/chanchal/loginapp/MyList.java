package com.metacube.chanchal.loginapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import static android.app.PendingIntent.getActivity;

public class MyList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);

        String brands[]={"Apple","Samsung","LG"};
        Integer imgid[]={
                R.mipmap.apple,
                R.mipmap.samsung,
                R.mipmap.lg
        };
        final String descriptions[]={
                "Apple Inc. is an American multinational technology company headquartered in Cupertino, California, that designs, develops, and sells consumer electronics, computer software, and online services.",
                "Samsung was founded by Lee Byung-chul in 1938 as a trading company. Over the next three decades, the group diversified into areas including food processing, textiles, insurance, securities and retail.",
                "LG Corporation  formerly Lucky Goldstar (Korean: Leokki Geumseong  ) is a South Korean multinational conglomerate corporation."
        };
        String time_posts[]={
                "Yesterday",
                "4.15 PM",
                "SEP 22",
                "OCT 31"
        };
        final ListView list = (ListView) findViewById(R.id.listView);
        CustomListAdapter ad = new CustomListAdapter(this,brands,imgid,descriptions,time_posts);
        list.setAdapter(ad);
        registerForContextMenu(list);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MyList.this,"Item "+position+" pressed.",Toast.LENGTH_SHORT).show();
                Intent expandable = new Intent(getApplicationContext(), MyExpandableList.class);
                expandable.putExtra("id", position);
                startActivity(expandable);
            }
        });
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ViewDialog alert = new ViewDialog();
                alert.showDialog(MyList.this, descriptions[position]);
                return true;
            }
        });
    }
    /*@Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
             super.onCreateContextMenu(menu, v, menuInfo);
            //Toast.makeText(this,"Inside",Toast.LENGTH_SHORT).show();

    }*/

}
class ViewDialog {

    public void showDialog(Activity activity, String msg){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.popup_menu_dialog);

        TextView text = (TextView) dialog.findViewById(R.id.popuptext);
        text.setText(msg);

        Button dialogButton = (Button) dialog.findViewById(R.id.popupbtn);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
