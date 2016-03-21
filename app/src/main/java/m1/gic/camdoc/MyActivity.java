package m1.gic.camdoc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.Query;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;

import m1.gic.camdoc.DisplayMessageActivity;
import m1.gic.camdoc.R;
import com.firebase.client.Firebase;


public class MyActivity extends Activity {


    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";



    public void sendMessage(View view) {
        Intent intent = new Intent(MyActivity.this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.ed_search);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public void sendMessage2(View view) {
        Intent intent = new Intent(MyActivity.this, DisplayMessageLogin.class);
        startActivity(intent);
    }
      public void sendMessage1(View view) {
      Intent intent = new Intent(MyActivity.this, DisplayMessageRegister.class);
      startActivity(intent);}
    public void sendMessage3(View view) {
        Intent intent = new Intent(MyActivity.this, DisplayAbout.class);
        startActivity(intent);
    }




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        Button fab = (Button) findViewById(R.id.bu_search);
        fab.setOnClickListener(new View.OnClickListener()  {

            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent intent = new Intent(MyActivity.this, DisplayMessageActivity.class);
                EditText editText = (EditText) findViewById(R.id.ed_search);
                String message = editText.getText().toString();
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
            }



        });

    }
}