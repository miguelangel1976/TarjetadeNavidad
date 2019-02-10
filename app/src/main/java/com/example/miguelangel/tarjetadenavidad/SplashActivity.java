package com.example.miguelangel.tarjetadenavidad;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity implements Animation.AnimationListener {

    //Se imprementa un interfaz para poner a la escucha las Animaciones
    //Como se implementa una interfaz, hay que definir sus métodos: `por lo menos escribirlos


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Ocultar la Barra ActionBar y Ocultarla
        getSupportActionBar().hide();

        //Fuente
        Typeface myFont = Typeface.createFromAsset(getAssets(),"timetoparty.ttf");

        //Etiqueta

        TextView texto = (TextView) findViewById(R.id.textoSplash);

        //Hacer que se conozcan la Fuente y la Etiqueta: Asignar a la Etiqueta la Fuente

        texto.setTypeface(myFont);





        //Asignar el Texto del Splash con la animación

        //1.Se crea el objeto de la slideUp
        Animation animacionSplash = AnimationUtils.loadAnimation(this,R.anim.splash);

        //2. Las cajas de texto se accede por su identificador.

        TextView texto_splash = (TextView)findViewById(R.id.textoSplash); //Identificador: (id)



        //3. Asignar a las Etiquetas el objeto de animacionSplash

        //Asignar a cada texto con su correspondiente animacion.
        //Diferentes Views o Componentes pueden compartir la misma Animacion.

        texto_splash.startAnimation(animacionSplash);



        //Hay que indicar el OBJETO que se encuentra a la ESCUCHA DE LA INTERFACE

        // Es la propia clase que está implementando el "AnimationListener"
        //Hay que pasarle la clase que implementa la interface, en este caso es la
        //propia clase, por lo que se pasa: THIS
        //debido a que THIS es el objeto de la clase SplashActivity

        animacionSplash.setAnimationListener(this);

    }

    //Métodos de la Interface Animation.AnimationListener
    @Override
    public void onAnimationStart(Animation animation) {

    }

    //Método que indica el Final de la Animación
    @Override
    public void onAnimationEnd(Animation animation) {
        //Se desea que cuando termine la animación del Splash
        // se realize el cambio de Actividad

        // Para cambiar una actividad a otra, hay que crear un intent,
        // que es un camino para indicar el inicio y el final.

        //Se le indica el camino, el inicio es SplashActivity el destino es MainActivity
        Intent intent = new Intent(SplashActivity.this,MainActivity.class);

        //Que empieze la ruta, a moverse, pasar de una actividad a otra

        startActivity(intent);

        finish();//Finalizar el Splash

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
