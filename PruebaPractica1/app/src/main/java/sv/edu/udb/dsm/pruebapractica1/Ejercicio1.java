package sv.edu.udb.dsm.pruebapractica1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class Ejercicio1 extends AppCompatActivity {
    EditText Nombre, Id, Total;
    Spinner Meses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);
        Nombre = findViewById(R.id.txtName);
        Id = findViewById(R.id.txtId);
        Total = findViewById(R.id.txtTotal);
        Meses = findViewById(R.id.ListMes);
    }
        public void Calcular(View view) {
            String Name= Nombre.getText().toString();
            String Codigo= Id.getText().toString();
            Double Tot= Double.valueOf(Total.getText().toString());
            String Mes= Meses.getSelectedItem().toString();
            Intent intent = new Intent(this,Comisiones.class);
            intent.putExtra("Name",Name);
            intent.putExtra("Codigo",Codigo);
            intent.putExtra("Tot",Tot);
            intent.putExtra("Mes",Mes);
            startActivity(intent);
        }
    public void finalizarActividad(View v){finish();}


}