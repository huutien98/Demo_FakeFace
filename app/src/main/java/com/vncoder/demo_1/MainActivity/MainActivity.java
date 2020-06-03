package com.vncoder.demo_1.MainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.vncoder.demo_1.R;

public class MainActivity extends AppCompatActivity {
    Button button;
    ImageButton btn_back;
    EditText editTextmail;
    EditText editText2;
    String mailLogin;
    String passwordLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        btn_back = findViewById(R.id.btn_back);
        editTextmail = (EditText) findViewById(R.id.editTextmail);
        editText2 = (EditText) findViewById(R.id.editText2);

        Intent intent = getIntent();
        final String mail = intent.getStringExtra("mailInput");
        final String password = intent.getStringExtra("passwordInput");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                   startActivity(intent);
//                mailLogin = editTextmail.getText().toString();
//                passwordLogin = editText2.getText().toString();
//
//                if (mail.equals(mailLogin)&&password.equals(passwordLogin)){
//                    Intent intent = new Intent(MainActivity.this, Main3Activity.class);
//                    startActivity(intent);
//                }else {
//                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                    builder.setTitle("ERROR");
//                    builder.setMessage("mail,password incorrect");
//                    builder.setCancelable(false);
//                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            Toast.makeText(MainActivity.this, "\n" +
//                                    "mail,password incorrect", Toast.LENGTH_SHORT).show();
//                        }
//                    });
//                    AlertDialog alertDialog = builder.create();
//                    alertDialog.show();
//                }
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.super.onBackPressed();
            }
        });
    }
}
