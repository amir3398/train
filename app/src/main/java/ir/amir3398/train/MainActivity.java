package ir.amir3398.train;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ir.amir3398.train.data.RetrofitClient;
import ir.amir3398.train.model.JsonResponseModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText user,pass;
    private Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        user=findViewById(R.id.main_username);
        pass=findViewById(R.id.main_password);
        login=findViewById(R.id.main_login);
        clicks();
    }

    private void clicks() {
        login.setOnClickListener(view -> {
            String u=user.getText().toString();
            String p=pass.getText().toString();

            RetrofitClient.getInstance(this).getApi().loginUser(u,p)
                    .enqueue(new Callback<JsonResponseModel>() {
                        @Override
                        public void onResponse(Call<JsonResponseModel> call, Response<JsonResponseModel> response) {
                            if(response.isSuccessful()){

                            }else
                                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<JsonResponseModel> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_SHORT).show();
                        }
                    });

        });
    }
}
