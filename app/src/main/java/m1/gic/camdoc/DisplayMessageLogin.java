package m1.gic.camdoc;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayMessageLogin extends AppCompatActivity implements View.OnClickListener {

    Button bu_sign;
    EditText ed_username, ed_password;
    TextView t_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ed_username = (EditText) findViewById(R.id.ed_username);
        ed_password = (EditText) findViewById(R.id.ed_password);
        bu_sign = (Button) findViewById(R.id.bu_sign);
        bu_sign.setOnClickListener(this);
        t_register = (TextView) findViewById(R.id.t_register);
       t_register.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bu_sign :
            break;
            case R.id.t_register:
                startActivity(new Intent(this ,DisplayMessageRegister.class));

        }

    }
}