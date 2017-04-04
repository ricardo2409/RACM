package itesm.mx.racm;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import itesm.mx.racm.datos.Contacto;

public class ContactoAdapter extends ArrayAdapter<Contacto>{

    LinearLayout ll;
    Contacto contacto;

    public ContactoAdapter(Context context, ArrayList<Contacto> contactos) {
        super(context, 0, contactos);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

            contacto = getItem(position);

            if(convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_contact, parent, false);
            }

            ll= (LinearLayout)  convertView.findViewById(R.id.linear_Row);
            TextView tvNombre = (TextView) convertView.findViewById(R.id.text_nombreCC);
            TextView tvTelefono = (TextView) convertView.findViewById(R.id.text_telefonoCC);
            ImageView ivFoto = (ImageView) convertView.findViewById(R.id.photo_contact);

            tvNombre.setText(contacto.getNombre());
            tvTelefono.setText(contacto.getTelefono());

           // Bitmap foto = decodeBase64(contacto.getFoto());
           // ivFoto.setImageBitmap(foto);

        cambiarColor();

            return convertView;
        }

    private void cambiarColor() {

        switch (contacto.getCategoria()){

            case 0:
                ll.setBackgroundColor(Color.parseColor("#2244aa"));//Azul #000000
                break;
            case 1:
                ll.setBackgroundColor(Color.parseColor("#f28500"));//Naranja
                break;
            case 2:
                ll.setBackgroundColor(Color.parseColor("#fdc8b1"));//Rosadito
                break;
            case 3:
                ll.setBackgroundColor(Color.parseColor("#e10000"));//Rojo
                break;
            case 4:
                ll.setBackgroundColor(Color.parseColor("#e300ff"));//Morado
                break;
        }

    }

    public static Bitmap decodeBase64(String input) {
            byte[] decodedByte = Base64.decode(input, 0);
            return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
        }
}
