package ir.amir3398.train;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import ir.amir3398.train.myClass.mySharedPrefrence;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class HomeActivity extends AppCompatActivity {
    private Button permission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
    }

    private void init() {
        permission=findViewById(R.id.home_permission);
        permission.setOnClickListener(v->{

           if(checkPermission()!=PackageManager.PERMISSION_GRANTED) {
               if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                   showExplain();
               } else if (!mySharedPrefrence.getInstance(this).getPermission()) {
                   requestPermission();
                   mySharedPrefrence.getInstance(this).setPermission();
               } else {
                   Intent i = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                   Uri uri = Uri.fromParts("package", getPackageName(), null);
                   i.setData(uri);
                   startActivity(i);
               }
           }else
               selectCamera();
        });
    }

    private void selectCamera() {
    }

    private void showExplain() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("مجوز نیاز است");
        builder.setTitle("مجوز");
        builder.setPositiveButton("بله",(v,c)->{
            v.dismiss();
            requestPermission();
        });
        builder.setNegativeButton("خیر",(v,c)->{
            v.dismiss();
        });
        builder.show();
    }

    private int checkPermission() {
      return   ActivityCompat.checkSelfPermission(this, WRITE_EXTERNAL_STORAGE);
    }

    private void  requestPermission(){
        ActivityCompat.requestPermissions(this,new String[]{WRITE_EXTERNAL_STORAGE},111);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==111){
            if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "amir", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
