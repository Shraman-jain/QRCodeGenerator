package com.example.qrcodegenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {
    ImageView qrCode;
    Button gen_btn;
    EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        qrCode=findViewById(R.id.showImage);
        gen_btn=findViewById(R.id.btn_gen);
        edt=findViewById(R.id.edt_text);

        gen_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GenerateQRFunction();
            }
        });


    }

    private void GenerateQRFunction() {
        String text=edt.getText().toString().trim();
        try {
            BarcodeEncoder barcodeEncoder=new BarcodeEncoder();
            Bitmap bitmap=barcodeEncoder.encodeBitmap(text, BarcodeFormat.QR_CODE,400,400);
            qrCode.setImageBitmap(bitmap);
        }catch (Exception e){

        }
}
}