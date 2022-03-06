package sv.edu.udb.dsm.pruebapractica1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MenuPrincipal extends AppCompatActivity {

    TextView tvSaludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        tvSaludo = (TextView) findViewById(R.id.tvSaludo);
        cargarPreferencias();
    }
    public void cargarPreferencias(){
        SharedPreferences preferences=getSharedPreferences
                ("credenciales", Context.MODE_PRIVATE);
        String usuario = preferences.getString("usuario","No existe un usuario");
        String contra = preferences.getString("contraseña","No existe una contraseña");
        tvSaludo.setText( "Bienvenido "+ usuario);
    }
    public void onClickPrimero(View v){
        Intent llamar = new Intent(this,Ejercicio1.class);
        startActivity(llamar);
    }
    public void onClickSegundo(View v){
        Intent llamar = new Intent(this,Ejercicio2.class);
        startActivity(llamar);
    }

    public void CerrarSesion(View v){
        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        preferences.edit().clear().commit();
        finish();
    }
}