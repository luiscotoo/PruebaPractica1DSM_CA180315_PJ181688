package sv.edu.udb.dsm.pruebapractica1;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Comisiones extends AppCompatActivity {
        TextView Nombre, Codigo, Mes, Totalven, Porcomision, TotalCom;
        ImageView Foto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comisiones);
        Nombre=findViewById(R.id.txtNombre);
        Codigo=findViewById(R.id.txtCodigo);
        Mes=findViewById(R.id.txtMes);
        Totalven=findViewById(R.id.txtTotalv);
        Porcomision=findViewById(R.id.txtcomision);
        TotalCom=findViewById(R.id.txtTotalc);
        Foto=findViewById(R.id.idfoto);



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
        //Calculado % de comision y total de comision
        if(TotalV<500){
        comicion=0.0;
        Porcomision.setText(comicion*100+" %");
            Totalcomi=TotalV*comicion;
            TotalCom.setText(String.valueOf("$ "+Totalcomi));
        }else
            if (TotalV>=500 && TotalV<1000){
            comicion=0.05;
            Porcomision.setText(comicion*100+" %");
            Totalcomi=TotalV*comicion;
            TotalCom.setText(String.valueOf("$ "+Totalcomi));}
            else
                if(TotalV>=1000 && TotalV<2000){
                    comicion=0.1;
                    Porcomision.setText(comicion*100+" %");
                    Totalcomi=TotalV*comicion;
                    TotalCom.setText(String.valueOf("$ "+Totalcomi));
                }
                else
                    if(TotalV>=2000 && TotalV<3000){
                        comicion=0.15;
                        Porcomision.setText(comicion*100+" %");
                        Totalcomi=TotalV*comicion;
                        TotalCom.setText(String.valueOf("$ "+Totalcomi));
                    }
                    else
                        if(TotalV>=3000 && TotalV<4000){
                            comicion=0.2;
                            Porcomision.setText(comicion*100+" %");
                            Totalcomi=TotalV*comicion;
                            TotalCom.setText(String.valueOf("$ "+Totalcomi));
                        }
                        else{
                            comicion=0.3;
                            Porcomision.setText(comicion*100+" %");
                            Totalcomi=TotalV*comicion;
                            TotalCom.setText(String.valueOf("$ "+Totalcomi));
                        }
        Uri pathImag=getIntent().getData();
        Foto.setImageURI(pathImag);
        }

    public void finalizarActividad(View v){finish();}
}