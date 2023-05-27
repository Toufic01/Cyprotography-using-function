package com.example.bookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Struct;

public class MainActivity extends AppCompatActivity {
    Button click;
    EditText editText,decrypted;
    TextView decrypt,encrypte;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        click = findViewById(R.id.click);
        editText = findViewById(R.id.text);
        encrypte = findViewById(R.id.encrypted);
        decrypted = findViewById(R.id.encryptcode);
        decrypt = findViewById(R.id.decryptedcode);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String input = editText.getText().toString();
                String BasicBase64format
                        = Base64.encodeToString(input.getBytes(),1);
                encrypte.setText(BasicBase64format);
                decrypted.setText(BasicBase64format);
                byte[]actualByte = Base64.decode(BasicBase64format,1);
                String actualString = new String(actualByte);
                decrypt.setText(actualString);

            }
        });

    }
}