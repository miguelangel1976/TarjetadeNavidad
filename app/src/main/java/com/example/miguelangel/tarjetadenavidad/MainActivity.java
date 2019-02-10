package com.example.miguelangel.tarjetadenavidad;

import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MediaPlayer cancion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Crear un Objeto "miFuente" para asociar el nuevo tipo de Letra Descargado.
        //Método getAssets: Obtener los recursos de Assets e indicar el "nombre del recurso o archivo" que se desea utilizar.
        Typeface miFuente = Typeface.createFromAsset(getAssets(), "Beauty and the Beast Sample.ttf");

        //Crear un objeto de clase TextView para cada una de las Etiquetas de la Aplicación.
        TextView texto1 = (TextView)findViewById(R.id.textView1);
        TextView texto2 = (TextView)findViewById(R.id.textView2);
        TextView texto3 = (TextView)findViewById(R.id.textView3);

        //Asociar el Tipo de Letra a las Etiquetas de Texto de la Aplicación:
        //Para ello se asocian los objetos de Texto con el de TipoLetra.
        texto1.setTypeface(miFuente);
        texto2.setTypeface(miFuente);
        texto3.setTypeface(miFuente);





        //Asignar la Primera Animación
        Animation animacionTexto1y2 = AnimationUtils.loadAnimation(this,R.anim.animacion1);

        texto1.startAnimation(animacionTexto1y2);
        texto2.startAnimation(animacionTexto1y2);

        //Asignar la Segunda Animación
        Animation animacionTexto3 = AnimationUtils.loadAnimation(this,R.anim.animacion2);

        texto3.startAnimation(animacionTexto3);






        //Música: Para asociar el Archivo de MP3

         cancion = MediaPlayer.create(this,R.raw.jingle_bells);

        cancion.start();  //Comenzar a reproducir la música.
    }

//Si la Aplicación realiza un: Stop, Pausa, o finaliza, se detiene

    protected void onDestroy() {
        super.onDestroy();
        cancion.stop();//Quitar la música al cerrar la Aplicación

    }

    protected void onStop() {
        super.onStop();
        cancion.stop();//Quitar la música al cerrar la Aplicación

    }

    protected void onPause() {

        super.onPause();
        cancion.stop();//Quitar la música al cerrar la Aplicación

    }

}
