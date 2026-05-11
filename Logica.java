/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author HP
 */
public class Logica extends JFrame{
     public Logica() {
         
        setTitle("Tienda de Mascota para Todes");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout(10, 10));

        JLabel titulo = new JLabel(
                "Tienda de Mascota para Todes",
                JLabel.CENTER
        );

        titulo.setFont(
                new Font("Arial", Font.BOLD, 25)
        );

        add(titulo, BorderLayout.NORTH);

        JPanel formulario = new JPanel();

        formulario.setLayout(
                new GridLayout(4, 1, 10, 10)
        );

        JLabel lblCorreo =
                new JLabel("Usuario:");

        JTextField txtCorreo =
                new JTextField();
        txtCorreo.setPreferredSize(
    new Dimension(180,30)
);

        JLabel lblPassword =
                new JLabel("Contraseña:");

        JPasswordField txtPassword =
                new JPasswordField();
        txtPassword.setPreferredSize(
    new Dimension(180,30)
);

        formulario.add(lblCorreo);
        formulario.add(txtCorreo);

        formulario.add(lblPassword);
        formulario.add(txtPassword);

        add(formulario, BorderLayout.CENTER);

        JButton ingresar =
                new JButton("INGRESAR");

        ingresar.addActionListener(e -> {

            String correo = txtCorreo.getText();

            String password =
                    new String(
                            txtPassword.getPassword()
                    );

            if (!correo.isEmpty()
                    && !password.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Bienvenido a Tienda de Mascota para Todes"
                );

                new ventanaPrincipal();

                dispose();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Complete todos los campos"
                );

            }

        });

        add(ingresar, BorderLayout.SOUTH);

        setVisible(true);
    }

     

        
}
