package kaimon.myapp.week3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    TextView textView;
    Button myBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = findViewById(R.id.textView);
        myBackButton = findViewById(R.id.backButton);

        Intent valueFromIntent = getIntent();
        String value = valueFromIntent.getStringExtra("my_value");
        textView.setText(value +", you made it to the second activity ");

        myBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backIntent = new Intent();
                backIntent.putExtra("key_name", "Value from second activity");
                setResult(SecondActivity.RESULT_OK, backIntent);
                finish();
            }
        });
    }
}