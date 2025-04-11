package com.example.orders_osipov;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void AlertDialog(String title, String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setNegativeButton("ОК", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {dialog.cancel();}
                });

        AlertDialog alter = builder.create();
        alter.show();
    }

    public EditText fio;
    public EditText phone;
    public EditText adress;
    public void OnArrange(View view)
    {
        fio = findViewById(R.id.fio);
        phone = findViewById(R.id.phone);
        adress = findViewById(R.id.adress);

        if(fio.getText().length() == 0) AlertDialog("Уведомление", "Пожалуйста, укажите Фамилию, Имя и Отчество.");
        else if(phone.getText().length() == 0) AlertDialog("Уведомление", "Пожалуйста, укажите номер телефона.");
        else if(adress.getText().length() == 0) AlertDialog("Уведомление", "Пожалуйста, укажите адрес доставки.");
        else {
            AlertDialog("Уведомление", "Заказ оформлен.");
        }
    }
}