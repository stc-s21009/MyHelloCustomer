package jp.suntech.s21009.myhellocustomer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btClick= findViewById(R.id.btClick);//確定ボタン
        HelloListener listener = new HelloListener();//リスナの生成
        btClick.setOnClickListener(listener);//リスナ指定

        Button btClearName= findViewById(R.id.btClearName);//クリアボタン
        btClearName.setOnClickListener(listener);//リスナ指定

        Button btClearLive= findViewById(R.id.btClearLive);//クリアボタン
        btClearLive.setOnClickListener(listener);//リスナ指定
    }
    //listenner Class <= イベントの監視
    private class HelloListener implements View.OnClickListener{
        //eventHandler <=イベント時の処理
        @Override
        public void onClick(View view) {
            EditText inputName = findViewById(R.id.etName);
            EditText inputLive = findViewById(R.id.etLive);
            TextView output = findViewById(R.id.tvOutput);
            int id = view.getId();
            switch(id){
                case R.id.btClick:
                    String inputStrName = inputName.getText().toString();
                    String inputStrLive = inputLive.getText().toString();
                    output.setText( inputStrLive + "にお住いの" + inputStrName + "さん、こんにちは！");
                    break;
                case R.id.btClearName:
                    inputName.setText("");
                    output.setText("");
                    break;
                case R.id.btClearLive:
                    inputLive.setText("");
                    output.setText("");
                    break;
            }
        }
    }
}