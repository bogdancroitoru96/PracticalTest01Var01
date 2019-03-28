package ro.pub.cs.systems.eim.practicaltest01var01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        northButton = (Button) findViewById(R.id.northButton);
        eastButton = (Button) findViewById(R.id.eastButton);
        westButton = (Button) findViewById(R.id.westButton);
        southButton = (Button) findViewById(R.id.southButton);
        textField = (EditText) findViewById(R.id.textField);
        navigateButton = (Button) findViewById(R.id.navigateButton);
    }
}
