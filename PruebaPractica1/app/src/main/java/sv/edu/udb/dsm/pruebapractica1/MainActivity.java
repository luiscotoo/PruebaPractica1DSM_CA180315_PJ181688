package sv.edu.udb.dsm.pruebapractica1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etUsuario, etContra;
    TextView tvTitulo, tvValidacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsuario = (EditText) findViewById(R.id.etUsuario);
        etContra = (EditText) findViewById(R.id.etContra);
        tvValidacion = (TextView) findViewById(R.id.tvValidacion);
    }


    public void guardarPreferencias(View v){

        SharedPreferences preferences=getSharedPreferences
                ("credenciales", Context.MODE_PRIVATE);
        String usuario = etUsuario.getText().toString();
        String contra = etContra.getText().toString();

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("usuario", usuario);
        editor.putString("contraseña", contra);

        editor.commit();

        Intent llamar = new Intent(this,MenuPrincipal.class);
        startActivity(llamar);
        etUsuario.setText("");
        etContra.setText("");
    }



}