package com.example.samsung.githubapp;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.samsung.githubapp.api.GitHubAPI;
import com.example.samsung.githubapp.model.Usuario;
import com.squareup.picasso.Picasso;

import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    private EditText etName;
    private TextView tvResult;
    private ImageView foto;
    private Button btnBusca;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        etName = (EditText) findViewById(R.id.main_et_name);
        tvResult = (TextView) findViewById(R.id.main_tv_result);
        foto = (ImageView) findViewById(R.id.main_img_foto);
        btnBusca = (Button) findViewById(R.id.main_btn_buscar);

        btnBusca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "Click", Toast.LENGTH_SHORT).show();

                RestAdapter adapter = new RestAdapter.Builder()
                                        .setEndpoint("https://api.github.com")
                                        .build();

                GitHubAPI gitHubAPI = adapter.create(GitHubAPI.class);

                gitHubAPI.getUser(etName.getText().toString(), new retrofit.Callback<Usuario>() {
                    @Override
                    public void success(Usuario usuario, Response response) {
                        //Toast.makeText(context, usuario.toString(), Toast.LENGTH_LONG).show();
                        tvResult.setText(usuario.getName());
                        Picasso.with(getApplication()).load(usuario.getAvatarUrl()).resize(300, 300)
                                .placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
                                .into(foto);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                    }
                });
            }
        });
    }
}
