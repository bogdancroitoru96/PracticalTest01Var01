package ro.pub.cs.systems.eim.practicaltest01var01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var01MainActivity extends AppCompatActivity {
    private Button northButton;
    private Button eastButton;
    private Button westButton;
    private Button southButton;
    private Button navigateButton;
    private EditText textField;
    private int count;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.northButton:
                    textField.setText(textField.getText() + "," + "North");
                    break;
                case R.id.eastButton:
                    textField.setText(textField.getText() + "," + "East");
                    break;
                case R.id.westButton:
                    textField.setText(textField.getText() + "," + "West");
                    break;
                case R.id.southButton:
                    textField.setText(textField.getText() + "," + "South");
                    break;
                case R.id.navigateButton:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var01SecondaryActivity.class);
                    String actions = textField.getText().toString();
                    intent.putExtra("actions", actions);
                    startActivityForResult(intent, 1);
                    textField.setText("");
                    count = 0;
                    break;
            }
            count++;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        northButton = (Button) findViewById(R.id.northButton);
        northButton.setOnClickListener(buttonClickListener);
        eastButton = (Button) findViewById(R.id.eastButton);
        eastButton.setOnClickListener(buttonClickListener);
        westButton = (Button) findViewById(R.id.westButton);
        westButton.setOnClickListener(buttonClickListener);
        southButton = (Button) findViewById(R.id.southButton);
        southButton.setOnClickListener(buttonClickListener);
        textField = (EditText) findViewById(R.id.textField);
        navigateButton = (Button) findViewById(R.id.navigateButton);
        navigateButton.setOnClickListener(buttonClickListener);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("count", String.valueOf(count));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("count")) {
            count = Integer.parseInt(savedInstanceState.getString("count"));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK)
                Toast.makeText(this, "Register", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this, "Cancel", Toast.LENGTH_LONG).show();

        }
    }
}
