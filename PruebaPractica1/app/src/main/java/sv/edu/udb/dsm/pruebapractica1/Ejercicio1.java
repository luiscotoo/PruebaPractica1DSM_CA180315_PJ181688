package sv.edu.udb.dsm.pruebapractica1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.constraint.solver.widgets.analyzer.Direct;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class Ejercicio1 extends AppCompatActivity {
    EditText Nombre, Id, Total;
    ImageView imagen;
    Spinner Meses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);

        imagen=findViewById(R.id.IdImag);
    }
        public void Calcular(View view) {
            Nombre = findViewById(R.id.txtName);
            Id = findViewById(R.id.txtId);
            Total = findViewById(R.id.txtTotal);
            Meses = findViewById(R.id.ListMes);

            if(TextUtils.isEmpty(Nombre.getText()) && TextUtils.isEmpty(Id.getText()) && TextUtils.isEmpty(Total.getText())){
                Nombre.setError("Campo Vacio");
                Id.setError("Campo Vacio");
                Total.setError("Campo Vacio");
            }else if(TextUtils.isEmpty(Id.getText().toString()) && TextUtils.isEmpty(Total.getText())){
                Id.setError("Campo Vacio");
                Total.setError("Campo Vacio");
            }else if(TextUtils.isEmpty(Total.getText().toString())&& TextUtils.isEmpty(Nombre.getText())){
                Total.setError("Campo Vacio");
                Nombre.setError("Campo Vacio");
            }else if(TextUtils.isEmpty(Nombre.getText().toString())&& TextUtils.isEmpty(Id.getText())){
                Id.setError("Campo Vacio");
                Nombre.setError("Campo Vacio");
            }
            else if (TextUtils.isEmpty(Nombre.getText())){
                Nombre.setError("Campo Vacio");
            }else if (TextUtils.isEmpty(Id.getText())){
                Id.setError("Campo Vacio");
            }else if (TextUtils.isEmpty(Total.getText())){
                Total.setError("Campo Vacio");
            }else
                {CargarImagen();}
        }
    public void finalizarActividad(View v){finish();}

    public void CargarImagen() {
        Intent intent= new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(intent.createChooser(intent,"Selecione la aplicacion:"),10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            Uri path=data.getData();
            imagen.setImageURI(path);
            Intent intent = new Intent(this, Comisiones.class);
            intent.putExtra("Name", Nombre.getText().toString());
            intent.putExtra("Codigo",Id.getText().toString() );
            intent.putExtra("Tot",Double.valueOf(Total.getText().toString()));
            intent.putExtra("Mes", Meses.getSelectedItem().toString());
            intent.setData(path);
            startActivity(intent);
        }
    }
}