package ir.amir3398.train.myClass;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import ir.amir3398.train.R;

public class myDialog extends Dialog {
    public myDialog(@NonNull Context context) {
        super(context);
    }

    private Button btn;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog);

        btn=findViewById(R.id.dialog_btn);
        img=findViewById(R.id.dialog_img);

        if(mySharedPrefrence.getInstance(getContext()).getUri()!=null)
            img.setImageURI(Uri.parse(mySharedPrefrence.getInstance(getContext()).getUri()));

        btn.setOnClickListener(v->{
            onBackPressed();
        });

    }
}
