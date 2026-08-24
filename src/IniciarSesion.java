import javax.swing.*;
import java.awt.*;

public  class IniciarSesion {

       public void inicio () {
           JFrame ventana = new JFrame("Inicio de sesion");
           ventana.setSize(350, 300);
           ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
           ventana.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));

           JLabel labelMatricula = new JLabel("Matrícula:");
           JTextField cajaMatricula = new JTextField(20);

           JButton botonIngresar = new JButton("Ingresar");
           // BOTÓN
           botonIngresar.addActionListener(e -> {

               // 1. Extraemos el texto
               String textoMatricula = cajaMatricula.getText().trim();

               // 2. Llamamos al cerebro (Controlador) y le pasamos los datos
               RegistroDeLogin controlador2 = new RegistroDeLogin();
               controlador2.procesarLogin(ventana, textoMatricula);

           });
           ventana.add(labelMatricula);
           ventana.add(cajaMatricula);
           ventana.add(botonIngresar);

           ventana.setVisible(true);
       }
}
