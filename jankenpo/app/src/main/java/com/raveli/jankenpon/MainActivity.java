package com.raveli.jankenpon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void rockSelected(View view) {
        startPlay("rock");
    }

    public void paperSelected(View view) {
        startPlay("paper");
    }

    public void scissorsSelected(View view) {
        startPlay("scissors");
    }

    private void startPlay(String userSelection) {
        String[] options = {"rock", "paper", "scissors"};
        String appSelection = options[new Random().nextInt(3)];

        ImageView imageSelectedApp = findViewById(R.id.image_app);

        switch (appSelection) {
            case "rock":
                imageSelectedApp.setImageResource(R.drawable.pedra);
                break;
            case "paper":
                imageSelectedApp.setImageResource(R.drawable.papel);
                break;
            default:
                imageSelectedApp.setImageResource(R.drawable.tesoura);
                break;
        }

        checkResult(appSelection, userSelection);
    }

    private void checkResult (String appSelection, String userSelection) {
        TextView resultText =  findViewById(R.id.text_result);

        if(appSelection.equals(userSelection)) {
            resultText.setText("Draw");
        } else if (appSelection.equals("rock") && Objects.equals(userSelection, "paper")) {
            resultText.setText("You Win!");
        } else if (appSelection.equals("paper") && Objects.equals(userSelection, "scissors")) {
            resultText.setText("You Win!");
        } else if (appSelection.equals("scissors") && Objects.equals(userSelection, "rock")) {
            resultText.setText("You Win!");
        } else {
            resultText.setText("You Lose!");
        }
    }
}