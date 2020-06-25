package com.mjrs.conversor_monetario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editValue = findViewById(R.id.edit_value);
        this.mViewHolder.text_dolar = findViewById(R.id.text_dolar);
        this.mViewHolder.text_euro = findViewById(R.id.text_euro);
        this.mViewHolder.button_calculate = findViewById(R.id.button_calculate);

        this.mViewHolder.button_calculate.setOnClickListener(this);

        this.clearValues();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button_calculate){
            String value = this.mViewHolder.editValue.getText().toString();
            if("".equals(value)){
                //mostra a mensagem para o usuário
                Toast.makeText(this, this.getString(R.string.informe_valor), Toast.LENGTH_LONG).show();
            } else{
                Double real = Double.valueOf(value);

                this.mViewHolder.text_dolar.setText("R$ " + String.format("%.2f", (real/5.3)));
                this.mViewHolder.text_euro.setText("R$ " + String.format("%.2f", (real/6)));
            }
        }
    }

    private void clearValues(){
        this.mViewHolder.text_dolar.setText("");
        this.mViewHolder.text_euro.setText("");
    }

    private static class ViewHolder{
        EditText editValue;
        TextView text_dolar;
        TextView text_euro;
        Button button_calculate;
    }
}
