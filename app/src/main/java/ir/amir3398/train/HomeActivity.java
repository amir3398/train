package ir.amir3398.train;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import ir.amir3398.train.myClass.myDialog;
import ir.amir3398.train.myClass.mySharedPrefrence;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.Manifest.permission.CAMERA;

public class HomeActivity extends AppCompatActivity {
    private Button selectPicture;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
    }

    private void init() {
        selectPicture = findViewById(R.id.home_permission);
        img=findViewById(R.id.home_img);

        clicks();
    }

    private void clicks() {

        selectPicture.setOnClickListener(v -> {

            if (checkPermission() == -1) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, CAMERA)) {
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
            } else
                selectPic();
        });

        img.setOnClickListener(v->{
            myDialog dialog = new myDialog(this);
            dialog.show();
        });

    }

    private void selectPic() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("عکس باید انتخاب گردد");
        builder.setTitle("عکس");
        builder.setPositiveButton("دوربین", (v, c) -> {
            selectCamera();
            requestPermission();
        });
        builder.setNegativeButton("گالری", (v, c) -> {
            selectGallery();
            v.dismiss();
        });
        builder.setNeutralButton("بستن", (v, c) -> {
            v.dismiss();
        });
        builder.show();
    }

    private void selectGallery() {
        Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        //startActivityForResult(Intent.createChooser(intent,"کدام برنامه؟"),222);
        startActivityForResult(intent,222);
    }

    private void selectCamera() {

        Toast.makeText(this, "selectCamera", Toast.LENGTH_SHORT).show();
    }

    private void showExplain() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("مجوز نیاز است");
        builder.setTitle("مجوز");
        builder.setPositiveButton("بله", (v, c) -> {
            v.dismiss();
            requestPermission();
        });
        builder.setNegativeButton("خیر", (v, c) -> {
            v.dismiss();
        });
        builder.show();
    }

    private int checkPermission() {
        return ActivityCompat.checkSelfPermission(this, CAMERA);
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{CAMERA}, 111);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 111) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "amir", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode== RESULT_OK){
            if(data!=null && requestCode==222){
                img.setImageURI(data.getData());
                mySharedPrefrence.getInstance(HomeActivity.this).setUri(String.valueOf(data.getData()));
            }
        }

    }
}
