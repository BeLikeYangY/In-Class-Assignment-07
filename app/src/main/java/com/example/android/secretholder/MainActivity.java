package com.example.android.secretholder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void save(View view) {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("secret");

        EditText secrets = (EditText)findViewById(R.id.editText);
        String secret = secrets.getText().toString();

        myRef.setValue(secret);
    }

    public void reveal(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);

    }
}
