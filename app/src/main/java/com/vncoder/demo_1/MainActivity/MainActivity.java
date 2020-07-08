package com.vncoder.demo_1.MainActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.vncoder.demo_1.Model.User;
import com.vncoder.demo_1.R;
import com.vncoder.demo_1.data.UserDao;
import com.vncoder.demo_1.data.UserDataBase;

public class MainActivity extends AppCompatActivity {
    Button button;
    ImageButton btn_back;
    EditText editTextmail;
    EditText editText2;
    TextView tv_forgotPassword;
    TextView tv_signup;

    UserDao db;
    UserDataBase dataBase;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        btn_back = findViewById(R.id.btn_back);
        editTextmail = (EditText) findViewById(R.id.editTextmail);
        editText2 = (EditText) findViewById(R.id.editText2);
        tv_signup = (TextView) findViewById(R.id.tv_signup);
        tv_forgotPassword = (TextView) findViewById(R.id.tv_forgotPassword);

        user = (User) getIntent().getSerializableExtra("User");
        if (user != null) {
            editTextmail.setText(user.getMail());
            editText2.setText(user.getPassword());
        }

        dataBase = Room.databaseBuilder(this, UserDataBase.class,"account.db")
                .allowMainThreadQueries()
                .build();

        db =dataBase.getUserDao();


        tv_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSignUp = new Intent(getBaseContext(),Main2Activity.class);
                startActivity(intentSignUp);
                finish();
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }
        });

        tv_forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.google.com.vn";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);

            }
        });



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = editTextmail.getText().toString().trim();
                String password = editText2.getText().toString().trim();

                User user = db.getUser(mail,password);
                if (user != null){
                    Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(getBaseContext(),"mail or password not correct",Toast.LENGTH_LONG).show();
                }
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();

            }
        });
    }

    @Override
    public void onBackPressed() {
        showAlertDialog();

    }

    public void showAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Monstarlab lifeTime");
        builder.setMessage("Do you want exit app?");
        builder.setCancelable(false);
        builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "thank you", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"see you again",Toast.LENGTH_LONG).show();
                dialogInterface.dismiss();
                System.exit(0);
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
