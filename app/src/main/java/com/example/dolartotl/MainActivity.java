package com.example.dolartotl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.style.QuoteSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dolartotl.data.RetrofitBuilder;
import com.example.dolartotl.data.Service;
import com.example.dolartotl.model.Model;

import java.text.DecimalFormat;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button btnHesapla;
    RadioButton btnDolar,btnTl;
    EditText etGiris;
    TextView tvSonuc;

    Service service;

    float donusumDegeri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHesapla = findViewById(R.id.btnHesapla);
        btnDolar = findViewById(R.id.btnDolar);
        btnTl = findViewById(R.id.btnTl);
        etGiris = findViewById(R.id.etGiris);
        tvSonuc = findViewById(R.id.tvSonuc);

        service = RetrofitBuilder.getClient().create(Service.class);

        Call<Model> call = service.getRepo();

        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                donusumDegeri =response.body().getQuotes().getUSDTRY();
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
            }
        });

        btnHesapla.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Double girilenDeger = 0.0;
                if (!etGiris.getText().toString().equals("")) {
                    try {
                        String deger = etGiris.getText().toString();
                        girilenDeger = donustur(deger);
                    }catch (Exception e ){
                        Toast.makeText(MainActivity.this, "Hatalı karakter girdiniz", Toast.LENGTH_SHORT).show();
                    }


                }else {
                    Toast.makeText(MainActivity.this,"Boş bırakılamaz",Toast.LENGTH_SHORT).show();
                }


                if (btnDolar.isChecked()) {
                    //tvSonuc.setText(String.valueOf(girilenDeger* donusumDegeri));
                    String sonuc = (girilenDeger * donusumDegeri) + "TL";
                    tvSonuc.setText(new DecimalFormat("##.##").format(girilenDeger* donusumDegeri));

                }else if (btnTl.isChecked()) {
                    tvSonuc.setText(new DecimalFormat("##.##").format(girilenDeger/ donusumDegeri));
                }else{
                    Toast.makeText(MainActivity.this, "Dolar veya Tl seçimi yapınız", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    public Double donustur(String deger) {
        Double donecekDeger = 0.0;
        if (deger != null && deger.length() > 0) {
            donecekDeger = Double.parseDouble(deger);
        }
        return donecekDeger;
    }

}