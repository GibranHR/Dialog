package com.itche.gibranhr.dialog;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

    private Button btnAlerta = null;
    private Button btnConfirmacion = null;
    private Button btnSeleccion = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OyenteClic objDetectaClic = new OyenteClic();

        btnAlerta = (Button)findViewById(R.id.BtnAlerta);
        btnAlerta.setOnClickListener(objDetectaClic);

        btnConfirmacion = (Button)findViewById(R.id.BtnConfirmacion);
        btnConfirmacion.setOnClickListener(objDetectaClic);

        btnSeleccion = (Button)findViewById(R.id.BtnSeleccion);
        btnSeleccion.setOnClickListener(objDetectaClic);

    }

    //Metodo de los botones en una clase para todos
    class OyenteClic implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            DialogFragment dialog;

            //Verifica el dialogo
            switch (v.getId()){
                case R.id.BtnAlerta:
                    dialog = new DialogoAlerta();
                    dialog.show(fragmentManager, "tagAlerta");
                    Toast.makeText(MainActivity.this, "Dialog Alerta", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.BtnConfirmacion:
                    dialog= new DialogoConfirmacion();
                    dialog.show(fragmentManager, "tagConfirmacion");
                    Toast.makeText(MainActivity.this, "Dialog Confirmación", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.BtnSeleccion:
                    dialog = new DialogoSeleccion();
                    dialog.show(fragmentManager, "tagSeleccion");
                    Toast.makeText(MainActivity.this, "Dialog Selección", Toast.LENGTH_SHORT).show();
                    break;
            }

        }
    }//OyenteClick

}