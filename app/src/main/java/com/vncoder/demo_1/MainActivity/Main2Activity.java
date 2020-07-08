package com.vncoder.demo_1.MainActivity;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.service.autofill.UserData;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.vncoder.demo_1.Model.User;
import com.vncoder.demo_1.R;
import com.vncoder.demo_1.data.UserDao;
import com.vncoder.demo_1.data.UserDataBase;

import de.hdodenhof.circleimageview.CircleImageView;

public class Main2Activity extends AppCompatActivity {
    Button btn_sign_up;
    ImageButton img_back;
    CircleImageView btn_profile;
    EditText et_full_name;
    EditText et_emailAddress;
    EditText et_password;
    TextView tv_signin;

    String fullname;
    String emailAddress;
    String password;

    UserDao userDao;


    private Uri imageUri;
     private static final int CAMERA_REQUEST = 1888;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn_sign_up = findViewById(R.id.btn_sign_up);
        img_back = findViewById(R.id.img_back);
        btn_profile = findViewById(R.id.btn_profile);
        et_full_name = findViewById(R.id.full_name);
        et_emailAddress = findViewById(R.id.mail_Address);
        et_password = findViewById(R.id.password);
        tv_signin = findViewById(R.id.tv_signin);

        userDao = Room.databaseBuilder(this,UserDataBase.class,"account.db")
                .allowMainThreadQueries()
                .build()
                .getUserDao();

        btn_profile.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                {
                    if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
                    {
                        requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_PERMISSION_CODE);
                    }
                    else
                    {
                        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(cameraIntent, CAMERA_REQUEST);
                    }
                }
            }
        });

        tv_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentSignIn = new Intent(getBaseContext(),MainActivity.class);
                startActivity(intentSignIn);
                finish();
            }
        });

        btn_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fullname = et_full_name.getText().toString().trim();
                emailAddress = et_emailAddress.getText().toString().trim();
                password = et_password.getText().toString().trim();

                String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
                if (fullname.isEmpty()&&emailAddress.isEmpty()&&password.isEmpty()&&password.matches(pattern)==false){
                    AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
                    builder.setTitle("ERROR");
                    builder.setMessage("User Name,mail,password Can't Is Empty!");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(Main2Activity.this, "\n" +
                                    "You need to enter enough information", Toast.LENGTH_SHORT).show();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }else {
                    User user =new User(fullname,password,emailAddress);
                    userDao.insert(user);
                    Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                    intent.putExtra("User",user);
                    startActivity(intent);
                }
            }
        });

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_CAMERA_PERMISSION_CODE)
        {
            if (grantResults[0] == PackageManager.PERMISSION_DENIED)
            {
                Toast.makeText(this, "camera permission granted", Toast.LENGTH_LONG).show();
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
            else
            {
                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();
            }
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            btn_profile.setImageBitmap(photo);
        }
    }

//    public void showAlertDialog(){
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Monstarlab lifeTime");
//        builder.setMessage("Do you want exit app?");
//        builder.setCancelable(false);
//        builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Toast.makeText(Main2Activity.this, "Không thoát được", Toast.LENGTH_SHORT).show();
//            }
//        });
//        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                dialogInterface.dismiss();
//                System.exit(0);
//            }
//        });
//        AlertDialog alertDialog = builder.create();
//        alertDialog.show();
//    }
//
//    @Override
//    public void onBackPressed() {
//        showAlertDialog();
//    }
}
