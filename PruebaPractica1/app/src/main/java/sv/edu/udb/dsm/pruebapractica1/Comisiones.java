package sv.edu.udb.dsm.pruebapractica1;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Comisiones extends AppCompatActivity {
    TextView Nombre, Codigo, Mes, Totalven, Porcomision, TotalCom, tvSaludo;
    ImageView Foto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comisiones);

        tvSaludo = (TextView) findViewById(R.id.textUser);
        Nombre=findViewById(R.id.txtNombre);
        Codigo=findViewById(R.id.txtCodigo);
        Mes=findViewById(R.id.txtMes);
        Totalven=findViewById(R.id.txtTotalv);
        Porcomision=findViewById(R.id.txtcomision);
        TotalCom=findViewById(R.id.txtTotalc);
        Foto=findViewById(R.id.idfoto);

        cargarPreferencias();

        //Extrayendo los datos del Bundle que viene de la activity Ejercicio 1
        Bundle datos = getIntent().getExtras();
        String nombre = datos.getString("Name");
        String Cod = datos.getString("Codigo");
        Double TotalV = datos.getDouble("Tot");
        String Mess = datos.getString("Mes");
        Double comicion, Totalcomi;

        Nombre.setText(nombre);
        Codigo.setText(Cod);
        Mes.setText(Mess);
        Totalven.setText(String.valueOf("$ "+TotalV));
        DecimalFormat formato = new DecimalFormat("#.00");
        //Calculado % de comision y total de comision
        if(TotalV<500){

            comicion=0.0;
            Porcomision.setText(comicion*100+" %");
            Totalcomi=TotalV*comicion;
            TotalCom.setText(String.valueOf("$ "+formato.format(Totalcomi)));
        }else
        if (TotalV>=500 && TotalV<1000){
            comicion=0.05;
            Porcomision.setText(comicion*100+" %");
            Totalcomi=TotalV*comicion;
            TotalCom.setText(String.valueOf("$ "+formato.format(Totalcomi)));}
        else
        if(TotalV>=1000 && TotalV<2000){
            comicion=0.1;
            Porcomision.setText(comicion*100+" %");
            Totalcomi=TotalV*comicion;
            TotalCom.setText(String.valueOf("$ "+formato.format(Totalcomi)));
        }
        else
        if(TotalV>=2000 && TotalV<3000){
            comicion=0.15;
            Porcomision.setText(comicion*100+" %");
            Totalcomi=TotalV*comicion;
            TotalCom.setText(String.valueOf("$ "+formato.format(Totalcomi)));
        }
        else
        if(TotalV>=3000 && TotalV<4000){
            comicion=0.2;
            Porcomision.setText(comicion*100+" %");
            Totalcomi=TotalV*comicion;
            TotalCom.setText(String.valueOf("$ "+formato.format(Totalcomi)));
        }
        else{
            comicion=0.3;
            Porcomision.setText(comicion*100+" %");
            Totalcomi=TotalV*comicion;
            TotalCom.setText(String.valueOf("$ "+formato.format(Totalcomi)));
        }
        Uri pathImag=getIntent().getData();
        Foto.setImageURI(pathImag);
    }
    public void cargarPreferencias(){
        SharedPreferences preferences=getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        String usuario = preferences.getString("usuario","No existe un usuario");
        String contra = preferences.getString("contraseña","No existe una contraseña");
        tvSaludo.setText( "Sesión Iniciada: "+ usuario);
    }


    public void finalizarActividad(View v){finish();}


}