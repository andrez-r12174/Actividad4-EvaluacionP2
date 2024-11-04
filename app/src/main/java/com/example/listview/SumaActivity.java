package com.example.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class SumaActivity extends AppCompatActivity {

    private ListView lvResultados;
    private ArrayAdapter<String> adaptadorResultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        lvResultados = findViewById(R.id.lvResultados);
        Button btnRegresar = findViewById(R.id.btnRegresar);  // Botón para regresar al MainActivity

        // Obtener el historial de resultados pasado desde el MainActivity
        ArrayList<String> historial = getIntent().getStringArrayListExtra("historial");

        // Configurar el adaptador y mostrar el historial en el ListView
        adaptadorResultados = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, historial);
        lvResultados.setAdapter(adaptadorResultados);

        // Configurar el botón de regreso
        btnRegresar.setOnClickListener(this::regresar);
    }

    // Método para regresar a la actividad anterior
    private void regresar(View view) {
        finish(); // Termina la actividad actual y regresa a MainActivity
    }
}
