package ro.pub.cs.systems.eim.practicaltest01var01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var01SecondaryActivity extends AppCompatActivity {
    private EditText textField;
    private Button registerButton;
    private Button cancelButton;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.register:
                    setResult(RESULT_OK, null);
                    break;
                case R.id.cancel:
                    setResult(RESULT_CANCELED, null);
                    break;
            }
            finish();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var01_secondary);
        textField = findViewById(R.id.textField);
        registerButton = findViewById(R.id.register);
        registerButton.setOnClickListener(buttonClickListener);
        cancelButton = findViewById(R.id.cancel);
        cancelButton.setOnClickListener(buttonClickListener);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("actions")) {
            String numberOfClicks = intent.getStringExtra("actions");
            textField.setText(String.valueOf(numberOfClicks));
        }
    }

}
