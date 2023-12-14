package packs.firstpack.pr;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class Regester extends AppCompatActivity {
    EditText name,email,pass;
String s;
User user=new User();
    EditText date;
    //lateinit var dateEdt: EditText
    Button reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regester);
    name=findViewById(R.id.editTextTextPersonName);
    email = findViewById(R.id.email);
    pass=findViewById(R.id.pass);
    reg= findViewById(R.id.reg);
    date=findViewById(R.id.Date);
        try (DBConnect dbConnect = new DBConnect(Regester.this)) {

            date.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // on below line we are getting
                    // the instance of our calendar.
                    final Calendar c = Calendar.getInstance();

                    // on below line we are getting
                    // our day, month and year.
                    int year = c.get(Calendar.YEAR);
                    int month = c.get(Calendar.MONTH);
                    int day = c.get(Calendar.DAY_OF_MONTH);

                    // on below line we are creating a variable for date picker dialog.
                    DatePickerDialog datePickerDialog = new DatePickerDialog(
                            // on below line we are passing context.
                            Regester.this,
                            new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker view, int year,
                                                      int monthOfYear, int dayOfMonth) {
                                    // on below line we are setting date to our edit text.
                                    s = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                                    date.setText(s);

                                }
                            },
                            // on below line we are passing year,
                            // month and day for selected date in our date picker.
                            year, month, day);
                    // at last we are calling show to
                    // display our date picker dialog.
                    datePickerDialog.show();

                }
            });

            reg.setOnClickListener(new View.OnClickListener() {

                String n, e, p, b;

                @Override
                public void onClick(View view) {
                    b = date.getText().toString();
                    user.setBirthDay(b);
                    e = email.getText().toString();
                    user.setEmailAddress(e);
                    n = name.getText().toString();
                    user.setName(n);
                    p = pass.getText().toString();
                    user.setPassword(p);
                    if (n.isEmpty() || e.isEmpty() ||
                            p.isEmpty() || b.isEmpty()) {
                        Toast.makeText(Regester.this, "Enter all field please", Toast.LENGTH_SHORT).show();
                    } else {
                        dbConnect.addUser(user);

                        Intent ii = new Intent(Regester.this, welcome.class);
                        startActivity(ii);
                    }
                }
            });
        }

    }
}