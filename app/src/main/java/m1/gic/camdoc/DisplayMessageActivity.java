package m1.gic.camdoc;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.GenericTypeIndicator;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.lang.String;


public class DisplayMessageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);

        final ListViewAdapter listViewAdapter = new ListViewAdapter();
        final ListView listView = (ListView) findViewById(R.id.list_view);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        final TextView edit = (TextView) findViewById(R.id.ed_view);
        String str = edit.getText().toString();
        String str1 = getIntent().getStringExtra(MyActivity.EXTRA_MESSAGE);
       edit.setText(str + str1);
        final Firebase myFirebaseRef = new Firebase("https://scorching-heat-7800.firebaseio.com/");

//        Query query = myFirebaseRef.child("Document").orderByChild("name");

        myFirebaseRef.child("Document").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot snapshot) {
//                edit.setText("you search : " + snapshot.getValue().toString());  //prints "Do you have data? You'll love Firebase."
                GenericTypeIndicator<ArrayList<Document>> t = new GenericTypeIndicator<ArrayList<Document>>() {
                };
                ArrayList<Document> data = snapshot.getValue(t);

                listViewAdapter.setData(data, DisplayMessageActivity.this);
                listView.setAdapter(listViewAdapter);

            }

            @Override
            public void onCancelled(FirebaseError error) {
            }

        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                File outputDir = DisplayMessageActivity.this.getCacheDir(); // context being the Activity pointer

                Document document = (Document) listView.getAdapter().getItem(position);
//                String pdf = document.getImage();
                int bookId = document.getBookId();

                myFirebaseRef.child("Book").child(bookId+"").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        String pdf = dataSnapshot.getValue().toString();

                        try {
//                    File outputFile = File.createTempFile("prefix", ".pdf", outputDir);
                            File outputFile = new File("/mnt/sdcard/download/Base64.pdf");
                            byte[] pdfAsBytes = Base64.decode(pdf, 0);
                            FileOutputStream os;
                            os = new FileOutputStream(outputFile, false);
                            os.write(pdfAsBytes);
                            os.flush();
                            os.close();
                            Intent target = new Intent(Intent.ACTION_VIEW);
                            target.setDataAndType(Uri.fromFile(outputFile), "application/pdf");
                            target.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

                            Intent intent = Intent.createChooser(target, "Open File");
                            try {
                                startActivity(intent);
                            } catch (ActivityNotFoundException e) {
                                // Instruct the user to install a PDF reader here, or something
                            }


                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });



            }
        });
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

}
