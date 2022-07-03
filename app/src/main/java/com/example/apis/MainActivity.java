package com.example.apis;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.apis.client.RetrofitClient;
import com.example.apis.client.ApiRefran;
import com.example.apis.databinding.ActivityMainBinding;
import com.example.apis.entity.Message;
import com.example.apis.service.RetrofitApiService;
import com.example.apis.service.UsoRefranes;



import java.util.Arrays;
import java.util.List;
import java.util.Random;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {

    private TextView nTextView;
    private ActivityMainBinding binding;
    private RetrofitApiService apiService;
    private UsoRefranes usorefranes;
    private Button nButton, button;
    private final List<Integer> numeros = Arrays.asList(
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10
    );
    public String n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
        initValues();
        nButton = findViewById(R.id.button);
        button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                Random aleatorio = new Random();
                Integer numero = numeros.get(aleatorio.nextInt(numeros.size()));
                getMessage(numero);
            }
        });
         nButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random aleatorio = new Random();
                Integer numero1 = numeros.get(aleatorio.nextInt(numeros.size()));
                getMessage(numero1);
            }
        });
    }

    private void initView() {
        nTextView = binding.textView;
    }

    private void initValues() {
        apiService = RetrofitClient.getApiService();
        usorefranes = ApiRefran.getApiService();
    }
    private void getMessage(int id) {
        if(button.isPressed()) {
            apiService.getMessageId(id).enqueue(new Callback<Message>() {
                @Override
                public void onResponse(Call<Message> call, Response<Message> response) {
                    Message message = response.body();
                    nTextView.setText(message.toString());
                }
                @Override
                public void onFailure(Call<Message> call, Throwable t) {
                    nTextView.setText(t.getMessage());
                }
            });
        }
        else {
                usorefranes.getMessageId1(id).enqueue(new Callback<Message>() {
                    @Override
                    public void onResponse(Call<Message> call, Response<Message> response) {
                        Message Refran = response.body();
                        nTextView.setText(Refran.toString1());

                    }

                    @Override
                    public void onFailure(Call<Message> call, Throwable t) {
                        nTextView.setText(t.getMessage());
                    }
                });
            }
        }
    }
