package com.example.android.secretholder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
        EditText editText = (EditText)findViewById(R.id.name);
        String str = editText.getText().toString();
        DatabaseReference myRef = database.getReference(str).child("secret");

        EditText secrets = (EditText)findViewById(R.id.editText);
        String secret = secrets.getText().toString();

        editText.setText("");
        secrets.setText("");

        Toast t = Toast.makeText(this, "Secret saved!", Toast.LENGTH_SHORT);
        t.show();
        myRef.setValue(secret);
    }

    public void reveal(View view) {
        EditText editText = (EditText)findViewById(R.id.target);
        String str = editText.getText().toString();

        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("Target",str);
        startActivity(intent);
    }
}
