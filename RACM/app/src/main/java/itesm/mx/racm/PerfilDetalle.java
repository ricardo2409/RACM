package itesm.mx.racm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ImageView;

import itesm.mx.racm.datos.ContactoOperations;
import itesm.mx.racm.datos.Perfil;
import itesm.mx.racm.datos.PerfilOperations;

public class PerfilDetalle extends AppCompatActivity implements View.OnClickListener {

    ImageView ivFotoPD;
    MenuFragment fragmentoMenu;

    TextView tvNombre;
    TextView tvTelefono;
    TextView tvCelular;
    TextView tvDireccion;

    String nombre;
    Perfil perfilPrueba;
    long idPerfil;
    PerfilOperations dao_Perfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_detalle);

        fragmentoMenu = (MenuFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_menu);

        ivFotoPD= (ImageView) findViewById(R.id.image_fotoPD);
        ivFotoPD.setOnClickListener(this);

        tvNombre = (TextView) findViewById(R.id.text_nombrePD);
        tvTelefono = (TextView) findViewById(R.id.text_telefonoPD);
        tvDireccion = (TextView) findViewById(R.id.text_DireccionPD);
        tvCelular = (TextView) findViewById(R.id.text_celularPD);

        dao_Perfil = new PerfilOperations(this);
        dao_Perfil.open();

        perfilPrueba = new Perfil(1,"PruebaNom", "81111111", "82222222", "direccion de prueba", "la ubicacion de prueba", null);
        tvNombre.setText(perfilPrueba.getNombre());
        tvCelular.setText(perfilPrueba.getCelular());
        tvTelefono.setText(perfilPrueba.getTelefonoFIjo());
        tvDireccion.setText(perfilPrueba.getDireccion());
/*
        perfilPrueba = dao_Perfil.findPerfil();

        tvNombre.setText(perfilPrueba.getNombre());
        tvTelefono.setText(perfilPrueba.getCelular());
        tvDireccion.setText(perfilPrueba.getDireccion());
*/
        ImageButton ibModificarPD= (ImageButton) findViewById(R.id.image_modificarPD);
        ibModificarPD.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_modificarPD:
                Intent  intentModify= new Intent(this,EditarPerfil.class);
                intentModify.putExtra("perfil", perfilPrueba);
                startActivity(intentModify);
                break;

            case R.id.image_fotoPD:
                Intent  intentFoto= new Intent(this,VerFoto.class);
                startActivity(intentFoto);
                break;
        }
    }
}
