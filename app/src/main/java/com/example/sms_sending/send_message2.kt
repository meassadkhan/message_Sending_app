package com.example.sms_sending

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat

class send_message2 : AppCompatActivity() {
    lateinit var phoneNo : String
    lateinit var message : String
    lateinit var ed_message : EditText
    lateinit var ed_phone_number : EditText
    lateinit var btn_send: Button
    var request_code = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         ed_message = findViewById<EditText>(R.id.ed_message)
         ed_phone_number = findViewById<EditText>(R.id.ed_phone_number)
        btn_send = findViewById<Button>(R.id.btn_send)




        btn_send.setOnClickListener {
            if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED){
                sendMessage()
            }
        }

    }

    fun sendMessage(){
        phoneNo = ed_phone_number.getText().toString();
        message = ed_message.getText().toString();

        if(!phoneNo.equals("")&&!message.equals("")){

            var smsManager = SmsManager.getDefault()
            smsManager.sendTextMessage(phoneNo,null,message,null,null)
            Toast.makeText(this, "Message sent", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, "Message sending failed", Toast.LENGTH_SHORT).show()
        }

    }
}