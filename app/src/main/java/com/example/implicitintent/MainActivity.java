package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button dial,sms,email,share;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dial = findViewById(R.id.dial);
        sms = findViewById(R.id.sms);
        email = findViewById(R.id.email);
        share = findViewById(R.id.share);

        dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iDial = new Intent(Intent.ACTION_DIAL);
                iDial.setData(Uri.parse("tel: 9014498206"));
                startActivity(iDial);
            }
        });

        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent isms = new Intent(Intent.ACTION_SENDTO);
                isms.setData(Uri.parse("smsto: "+Uri.encode("9014498206")));
                isms.putExtra("sms_body","please solve this issue asap");
                startActivity(isms);
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iemail = new Intent(Intent.ACTION_SEND);
                iemail.setType("message/rfc822");
                iemail.putExtra(Intent.EXTRA_EMAIL,new String[]{"guthaumeshreddy@gmail.com","xyz@gmail.com"});
                iemail.putExtra(Intent.EXTRA_SUBJECT,"Queries");
                iemail.putExtra(Intent.EXTRA_TEXT,"please enter your issue");
                startActivity(Intent.createChooser(iemail,"Email via"));
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ishare = new Intent(Intent.ACTION_SEND);
                ishare.setType("text/plain");
                ishare.putExtra(Intent.EXTRA_TEXT,"download this amazing app");
                startActivity(Intent.createChooser(ishare,"Share via"));
            }
        });
    }
}