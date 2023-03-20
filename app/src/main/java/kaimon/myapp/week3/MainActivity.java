package kaimon.myapp.week3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button clickButton,  secondButton;
    EditText nameText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clickButton = findViewById(R.id.ToNewActive);

        nameText = findViewById(R.id.editTextTextPersonName);

        secondButton = findViewById(R.id.button2);



        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputValue = nameText.getText().toString();
                Intent myIntent = new Intent(MainActivity.this, SecondActivity.class);
                myIntent.putExtra("my_value", inputValue);
//                startActivity(myIntent);

                startActivityForResult(myIntent, 1);

            }
        });

        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https//:deakin.edu.au/"));
//                startActivity(i);

                Uri number = Uri.parse("tel:5551234");
                Intent callintent = new Intent(Intent.ACTION_DIAL, number);
                startActivity(callintent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1){
            if (resultCode == RESULT_OK){
                String ValueFromSecondActivity = data.getStringExtra("key_name");
            }
        }
    }
}