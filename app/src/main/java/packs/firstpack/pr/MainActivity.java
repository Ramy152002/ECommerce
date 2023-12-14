package packs.firstpack.pr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email,pass;
    Button log, signup;
    CheckBox rem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    email=findViewById(R.id.email);
    pass=findViewById(R.id.pass);
    log=findViewById(R.id.log);
    signup = findViewById(R.id.sign);
    rem=findViewById(R.id.Remember);

    log.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           // Toast.makeText(MainActivity.this, "login", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(MainActivity.this,welcome.class);
            startActivity(i);
        }
    });

    signup.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           // Toast.makeText(MainActivity.this, "sing up", Toast.LENGTH_SHORT).show();
        String e=email.getText().toString();
        String p = pass.getText().toString();
           // User u =new User(e,p);
            //DBConnect d =new DBConnect(MainActivity.this);
            //d.addUser(u);
            Intent i=new Intent(MainActivity.this,Regester.class);
            startActivity(i);
        }
    });
rem.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Toast.makeText(MainActivity.this, "Remember", Toast.LENGTH_SHORT).show();
    }
});

    }
}