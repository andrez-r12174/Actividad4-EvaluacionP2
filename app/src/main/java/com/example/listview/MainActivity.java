package com.example.listview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText numero1, numero2;
    private List<String> sumaHistorial = new ArrayList<>();
    private List<String> restaHistorial = new ArrayList<>();
    private List<String> multiplicacionHistorial = new ArrayList<>();
    private List<String> divisionHistorial = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar vistas
        numero1 = findViewById(R.id.numero1);
        numero2 = findViewById(R.id.numero2);
    }

    public void realizarSuma(View view) {
        realizarOperacion("suma");
    }

    public void realizarResta(View view) {
        realizarOperacion("resta");
    }

    public void realizarMultiplicacion(View view) {
        realizarOperacion("multiplicacion");
    }

    public void realizarDivision(View view) {
        realizarOperacion("division");
    }

    private void realizarOperacion(String operacion) {
        String num1Str = numero1.getText().toString();
        String num2Str = numero2.getText().toString();

        if (!num1Str.isEmpty() && !num2Str.isEmpty()) {
            int num1 = Integer.parseInt(num1Str);
            int num2 = Integer.parseInt(num2Str);
            String resultado = "";

            switch (operacion) {
                case "suma":
                    resultado = num1 + " + " + num2 + " = " + (num1 + num2);
                    sumaHistorial.add(resultado);
                    break;
                case "resta":
                    resultado = num1 + " - " + num2 + " = " + (num1 - num2);
                    restaHistorial.add(resultado);
                    break;
                case "multiplicacion":
                    resultado = num1 + " * " + num2 + " = " + (num1 * num2);
                    multiplicacionHistorial.add(resultado);
                    break;
                case "division":
                    if (num2 != 0) {
                        resultado = num1 + " / " + num2 + " = " + (num1 / num2);
                        divisionHistorial.add(resultado);
                    } else {
                        Toast.makeText(this, "No se puede dividir por cero", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    break;
            }

            Toast.makeText(this, "Resultado guardado", Toast.LENGTH_SHORT).show();

            // Limpiar campos de texto
            numero1.setText("");
            numero2.setText("");
        }
    }

    // Métodos para abrir el historial de cada operación
    public void verHistorialSuma(View view) {
        abrirActivityHistorial(SumaActivity.class, sumaHistorial);
    }

    public void verHistorialResta(View view) {
        abrirActivityHistorial(RestaActivity.class, restaHistorial);
    }

    public void verHistorialMultiplicacion(View view) {
        abrirActivityHistorial(MultiplicacionActivity.class, multiplicacionHistorial);
    }

    public void verHistorialDivision(View view) {
        abrirActivityHistorial(DivisionActivity.class, divisionHistorial);
    }

    private void abrirActivityHistorial(Class<?> activityClass, List<String> historial) {
        Intent intent = new Intent(this, activityClass);
        intent.putStringArrayListExtra("historial", new ArrayList<>(historial));
        startActivity(intent);
    }
}
