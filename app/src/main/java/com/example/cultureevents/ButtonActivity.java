package com.example.cultureevents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ButtonActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        mFirebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
        if (mFirebaseUser != null) {
            if (mFirebaseUser.equals("eventsproject2020@gmail.com")) {
                button.findViewById(R.id.button2).setVisibility(button.VISIBLE);
            }
        } else {
            button.findViewById(R.id.button2).setVisibility(button.INVISIBLE);
        }
    }


}