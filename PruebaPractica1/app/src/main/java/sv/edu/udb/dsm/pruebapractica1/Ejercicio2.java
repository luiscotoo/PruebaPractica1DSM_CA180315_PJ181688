package sv.edu.udb.dsm.pruebapractica1;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Ejercicio2 extends AppCompatActivity {

    TextView tvSaludoEj2, tvX1, tvX2, tvValidacion2;
    EditText etVarA,etVarB,etVarC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);

        tvSaludoEj2 = (TextView) findViewById(R.id.tvSaludoEj2);
        tvX1 = (TextView) findViewById(R.id.tvX1);
        tvX2 = (TextView) findViewById(R.id.tvX2);
        tvValidacion2 = (TextView) findViewById(R.id.tvValidacion2);
        etVarA = (EditText) findViewById(R.id.etVarA);
        etVarB = (EditText) findViewById(R.id.etVarB);
        etVarC = (EditText) findViewById(R.id.etVarC);
        cargarPreferencias();
    }
    public void cargarPreferencias(){
        SharedPreferences preferences=getSharedPreferences
                ("credenciales", Context.MODE_PRIVATE);
        String usuario = preferences.getString("usuario","No existe un usuario");
        String contra = preferences.getString("contraseña","No existe una contraseña");
        tvSaludoEj2.setText( "Bienvenido "+ usuario);
    }

    public void CalcularFormula(View v){

        try{
            double x1, x2;
            double a = Double.parseDouble(etVarA.getText().toString());
            double b = Double.parseDouble(etVarB.getText().toString());
            double c = Double.parseDouble(etVarC.getText().toString());

            double d = ((b*b)-4*a*c);
            if(d<0){
                double Pr, Pi;
                double d2 = abs(d);
                Pr = -b / (2 * a);
                Pi = sqrt(d2) / (2 * a);

                if(Pi<0){
                    tvX1.setText(String.format("X1= %.3f",Pr) + String.format("%.3fi%n",Pi));
                    tvX2.setText(String.format("X2= %.3f",Pr) + String.format("%.3fi%n",Pi));
                }
                else{
                    tvX1.setText(String.format("X1= %.3f+",Pr) + String.format("%.3fi%n",Pi));
                    tvX2.setText(String.format("X2= %.3f+",Pr) + String.format("%.3fi%n",Pi));
                }


            }
            else {
                x1 = ( -b + sqrt(d))/(2*a);
                x2 = ( -b - sqrt(d))/(2*a);
                tvX1.setText(String.format("X1= %.4f",x1));
                tvX2.setText(String.format("X2= %.4f",x2));
            }
            tvValidacion2.setText("");
        }catch (Exception error){
            tvValidacion2.setText("Verificar ingreso de datos");
        }

    }

    public void finalizar(View v){
        finish();
    }
}