package com.example.contractorcalculator;

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
        initDisplayButton();
    }

    public static final double tax_percentage = 5;

    private void initDisplayButton(){
        Button displayButton = findViewById(R.id.calculate);
        displayButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                EditText editLabor = findViewById(R.id.editLabor);
                EditText editMaterials = findViewById(R.id.editMaterials);

                double labor = Double.parseDouble(editLabor.getText().toString());
                double materials = Double.parseDouble(editMaterials.getText().toString());
                double subtotal = labor + materials;
                double tax = subtotal * (tax_percentage/100.00);
                double total = subtotal + tax;

                String subtotals = String.valueOf(subtotal);
                String taxes = String.valueOf(tax);
                String totals = String.valueOf(total);

                TextView displaySubtotal = findViewById(R.id.viewSubtotal);
                TextView displayTax = findViewById(R.id.viewTax);
                TextView displayTotal = findViewById(R.id.viewTotal);

                displaySubtotal.setText(subtotals);
                displayTax.setText(taxes);
                displayTotal.setText(totals);
            }
        });
    }
}