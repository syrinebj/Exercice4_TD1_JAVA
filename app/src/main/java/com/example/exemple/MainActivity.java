package com.example.exemple;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button envoyer;
    EditText num , msg;
    Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            envoyer = findViewById(R.id.envoyer);
            num = findViewById(R.id.numero);
            msg = findViewById(R.id.message);

            envoyer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Send_SMS();
                }
            });
    }
    private void Send_SMS(){
        String numero = num.getText().toString();
        String message = msg.getText().toString();
        Uri uri = Uri.parse("smsto:" +numero);
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra("msg", message);
        try {
            SmsManager smsManager= SmsManager.getDefault();
            smsManager.sendTextMessage(numero,null,message,null,null);
            CharSequence text = "SMS Envoye";
            int duration = Toast.LENGTH_SHORT;
            Toast T = Toast.makeText(context, text, duration);
            T.show();

        }catch (Exception ex){
            CharSequence text = "error";
            int duration = Toast.LENGTH_SHORT;
            Toast T = Toast.makeText(context, text, duration);
            T.show();
            ex.printStackTrace();
        }
    }
    }

    /*

    envoyer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String numero = num.getText().toString();
                    String message = msg.getText().toString();
                    if(numero.length()== 8 && message.length()>0){
                        SmsManager.getDefault().sendTextMessage(numero,null,message,null,null);
                        num.setText("");
                        msg.setText("");
                    }
                    else if(numero.length()!=8) {
                        CharSequence text = "invalide numero";
                        int duration = Toast.LENGTH_SHORT;
                        Toast T = Toast.makeText(context, text, duration);
                        T.show();

                    }
                    else if(message.length()==0){
                        CharSequence text = "Impossible d'envoyer un message vide";
                        int duration = Toast.LENGTH_SHORT;
                        Toast T = Toast.makeText(context, text, duration);
                        T.show();

                    }
                    else{

                    }
                }
            });
    */
