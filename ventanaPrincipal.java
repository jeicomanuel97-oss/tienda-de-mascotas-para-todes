/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Servicio.CarritoCompraMascota;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import modelo.Cliente;
import modelo.Pedido;
import modelo.ProductoParaMascota;
import pago.Pago;
import pago.Pagoenefectivo;
import pago.PagoporTarjetadecredito;

/**
 *
 * @author HP
 */
public class ventanaPrincipal extends JFrame{
   private CarritoCompraMascota carritoCompra;
   private String nombreDelUsuario;
   
    public ventanaPrincipal() {
                carritoCompra = new CarritoCompraMascota();
               File archivo = new File("usuario.txt");

if(archivo.exists()){

    try{

        Scanner leer = new Scanner(archivo);

        String usuarioGuardado =
                leer.nextLine();

        leer.close();

        int opcion = JOptionPane.showConfirmDialog(
                this,
                "¿Desea continuar como "
                + usuarioGuardado
                + "?",
                "Usuario guardado",
                JOptionPane.YES_NO_OPTION
        );

        if(opcion == JOptionPane.YES_OPTION){

            nombreDelUsuario =
                    usuarioGuardado;

            JOptionPane.showMessageDialog(
                    this,
                    "Bienvenido nuevamente "
                    + nombreDelUsuario
            );

        }else{

            JTextField campoUsuario =
                    new JTextField(15);

            campoUsuario.setPreferredSize(
                new Dimension(150,25)
            );

            JPanel panelLogin =
                    new JPanel();

            panelLogin.add(
                    new JLabel("Usuario:")
            );

            panelLogin.add(campoUsuario);

            JOptionPane.showConfirmDialog(
                    this,
                    panelLogin,
                    "Nuevo usuario",
                    JOptionPane.OK_CANCEL_OPTION
            );

            nombreDelUsuario =
                    campoUsuario.getText();
        }

    }catch(Exception ex){

        nombreDelUsuario =
                JOptionPane.showInputDialog(
                        this,
                        "Ingrese su usuario"
                );

    }

}else{

    JTextField campoUsuario =
            new JTextField(15);

    campoUsuario.setPreferredSize(
        new Dimension(150,25)
    );

    JPanel panelLogin =
            new JPanel();

    panelLogin.add(
            new JLabel("Usuario:")
    );

    panelLogin.add(campoUsuario);

    JOptionPane.showConfirmDialog(
            this,
            panelLogin,
            "Ingreso al sistema",
            JOptionPane.OK_CANCEL_OPTION
    );

    nombreDelUsuario =
            campoUsuario.getText();
}
                 
                
   

    

        setTitle("Tienda de Mascota para Todes");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout(10, 10));

        

        

      JLabel titulo = new JLabel(
        " Tienda de Mascota para Todes",
        JLabel.CENTER
);

titulo.setFont(
        new Font("Arial", Font.BOLD, 30)
);

JLabel usuarioInfo = new JLabel(
    " Usuario: "
    + nombreDelUsuario
   
  
);

usuarioInfo.setFont(
    new Font("Arial", Font.PLAIN, 18)
);

JPanel superiorTitulo = new JPanel(
    new GridLayout(2,1)
);

superiorTitulo.add(titulo);

superiorTitulo.add(usuarioInfo);

add(superiorTitulo, BorderLayout.NORTH);
       

        JPanel panelSuperior = new JPanel();
panelSuperior.setLayout(new BorderLayout());




JPanel buscadorPanel = new JPanel();

JTextField buscar = new JTextField(20);

JButton buscarBtn = new JButton("Buscar");

buscarBtn.setBackground(Color.ORANGE);

buscarBtn.setFocusPainted(false);

String[] categorias = {
    "Comida",
    "Accesorios",
    "Higiene",
    "Juguetes"
};

JComboBox<String> combo =
        new JComboBox<>(categorias);

combo.setBackground(Color.PINK);

buscadorPanel.add(new JLabel(" Buscar:"));
buscadorPanel.add(buscar);
buscadorPanel.add(buscarBtn);
buscadorPanel.add(combo);




JPanel promoPanel = new JPanel();

promoPanel.setLayout(new GridLayout(4,1));

JLabel promociones = new JLabel(
    " PROMOCIONES ",
    JLabel.CENTER
);

promociones.setFont(
    new Font("Arial", Font.BOLD, 22)
);

JLabel oferta1 = new JLabel(
    " 20% descuento en juguetes los viernes ",
    JLabel.CENTER
);

JLabel oferta2 = new JLabel(
    "Compra Dog Chow y gana puntos",
    JLabel.CENTER
);

JLabel oferta3 = new JLabel(
    "Envíos gratis desde $50.000",
    JLabel.CENTER
);

oferta1.setFont(new Font("Arial", Font.BOLD, 16));
oferta2.setFont(new Font("Arial", Font.BOLD, 16));
oferta3.setFont(new Font("Arial", Font.BOLD, 16));

promoPanel.add(promociones);
promoPanel.add(oferta1);
promoPanel.add(oferta2);
promoPanel.add(oferta3);




panelSuperior.add(
    buscadorPanel,
    BorderLayout.NORTH
);

panelSuperior.add(
    promoPanel,
    BorderLayout.CENTER
);
        add(panelSuperior, BorderLayout.WEST);
        JTextArea carrito = new JTextArea();

carrito.setFont(new Font("Monospaced", Font.PLAIN, 16));

carrito.setBackground(new Color(245,245,245));

carrito.setEditable(false);

JScrollPane scrollCarrito = new JScrollPane(carrito);

scrollCarrito.setPreferredSize(
        new Dimension(300, 0));

JLabel carritoTitulo =
        new JLabel(
            " CARRITO DE COMPRAS",
            JLabel.CENTER
        );

carritoTitulo.setFont(
    new Font("Arial", Font.BOLD, 18)
);

JPanel panelCarrito = new JPanel();

panelCarrito.setLayout(
    new BorderLayout()
);

panelCarrito.add(
    carritoTitulo,
    BorderLayout.NORTH
);

panelCarrito.add(
    scrollCarrito,
    BorderLayout.CENTER
);

add(panelCarrito, BorderLayout.EAST);

        
        

        JLabel total =
                new JLabel("TOTAL: $0");

        total.setFont(
                new Font("Arial", Font.BOLD, 20)
        );

        
        ProductoParaMascota p1 =
                new ProductoParaMascota(
                        1,
                        "Dog Chow",
                        25000,
                        10
                );

        ProductoParaMascota p2 =
                new ProductoParaMascota(
                        2,
                        "Pelota",
                        8000,
                        15
                );

        ProductoParaMascota p3 =
                new ProductoParaMascota(
                        3,
                        "Shampoo",
                        12000,
                        8
                );

        ProductoParaMascota p4 =
                new ProductoParaMascota(
                        4,
                        "Correa",
                        18000,
                        10
                );

        ProductoParaMascota p5 =
                new ProductoParaMascota(
                        5,
                        "Cama",
                        60000,
                        5
                );

        ProductoParaMascota p6 =
                new ProductoParaMascota(
                        6,
                        "Vitaminas",
                        20000,
                        12
                );
        
ProductoParaMascota p7 =new ProductoParaMascota( 7, "Pedigree", 30000, 16);

ProductoParaMascota p8 =new ProductoParaMascota(8, "Chunky", 28000,9);
ProductoParaMascota p9 =
        new ProductoParaMascota(
                9,
                "Hueso",
                10000,
                20
        );

ProductoParaMascota p10 =
        new ProductoParaMascota(
                10,
                "Mordedor",
                15000,
                15
        );

ProductoParaMascota p11 =
        new ProductoParaMascota(
                11,
                "Cepillo",
                12000,
                10
        );

ProductoParaMascota p12 =
        new ProductoParaMascota(
                12,
                "Toallas",
                9000,
                18
        );

ProductoParaMascota p13 =
        new ProductoParaMascota(
                13,
                "Collar",
                22000,
                7
        );
        JPanel productos = new JPanel();

        productos.setLayout(
               new GridLayout(0, 3, 20, 20)
        );

       

        JButton btn1 = new JButton("Agregar");
        btn1.setPreferredSize(
        new Dimension(90,30)
);

        btn1.addActionListener(e -> {

            carritoCompra.agregarProducto(p1);

            carrito.append(
                    p1.getNombre()
                    + " - $"
                    + p1.getPrecio()
                    + "\n"
            );

            total.setText(
                    "TOTAL: $"
                    + carritoCompra.calcularTotal()
            );

        });

        JPanel card1 = new JPanel();

        card1.setLayout(new GridLayout(4, 1));

        card1.add(new JLabel(" Dog Chow"));
        card1.add(new JLabel("Precio: $25000"));
        card1.add(new JLabel("Stock: 10"));
        card1.add(btn1);

       

        JButton btn2 = new JButton("Agregar");
        btn2.setPreferredSize(
        new Dimension(90,30)
);

        btn2.addActionListener(e -> {

            carritoCompra.agregarProducto(p2);

            carrito.append(
                    p2.getNombre()
                    + " - $"
                    + p2.getPrecio()
                    + "\n"
            );

            total.setText(
                    "TOTAL: $"
                    + carritoCompra.calcularTotal()
            );

        });

        JPanel card2 = new JPanel();

        card2.setLayout(new GridLayout(4, 1));

        card2.add(new JLabel(" Pelota"));
        card2.add(new JLabel("Precio: $8000"));
        card2.add(new JLabel("Stock: 15"));
        card2.add(btn2);

      

        JButton btn3 = new JButton("Agregar");
        btn3.setPreferredSize( new Dimension(90,30));

        btn3.addActionListener(e -> {

            carritoCompra.agregarProducto(p3);

            carrito.append(
                    p3.getNombre()
                    + " - $"
                    + p3.getPrecio()
                    + "\n"
            );

            total.setText(
                    "TOTAL: $"
                    + carritoCompra.calcularTotal()
            );

        });

        JPanel card3 = new JPanel();

        card3.setLayout(new GridLayout(4, 1));

        card3.add(new JLabel("Shampoo"));
        card3.add(new JLabel("Precio: $12000"));
        card3.add(new JLabel("Stock: 8"));
        card3.add(btn3);

        

        JButton btn4 = new JButton("Agregar");
        btn4.setPreferredSize( new Dimension(90,30));

        btn4.addActionListener(e -> {

            carritoCompra.agregarProducto(p4);

            carrito.append(
                    p4.getNombre()
                    + " - $"
                    + p4.getPrecio()
                    + "\n"
            );

            total.setText(
                    "TOTAL: $"
                    + carritoCompra.calcularTotal()
            );

        });

        JPanel card4 = new JPanel();

        card4.setLayout(new GridLayout(4, 1));

        card4.add(new JLabel(" Correa"));
        card4.add(new JLabel("Precio: $18000"));
        card4.add(new JLabel("Stock: 10"));
        card4.add(btn4);

       

        JButton btn5 = new JButton("Agregar");
        btn5.setPreferredSize(  new Dimension(90,30));

        btn5.addActionListener(e -> {

            carritoCompra.agregarProducto(p5);

            carrito.append(
                    p5.getNombre()
                    + " - $"
                    + p5.getPrecio()
                    + "\n"
            );

            total.setText(
                    "TOTAL: $"
                    + carritoCompra.calcularTotal()
            );

        });

        JPanel card5 = new JPanel();

        card5.setLayout(new GridLayout(4, 1));

        card5.add(new JLabel("cama"));
        card5.add(new JLabel("Precio: $60000"));
        card5.add(new JLabel("Stock: 5"));
        card5.add(btn5);

        

        JButton btn6 = new JButton("Agregar");
        btn6.setPreferredSize( new Dimension(90,30));

        btn6.addActionListener(e -> {

            carritoCompra.agregarProducto(p6);

            carrito.append(
                    p6.getNombre()
                    + " - $"
                    + p6.getPrecio()
                    + "\n"
            );

            total.setText(
                    "TOTAL: $"
                    + carritoCompra.calcularTotal()
            );

        });

        JPanel card6 = new JPanel();

        card6.setLayout(new GridLayout(4, 1));

        card6.add(new JLabel(" Vitaminas"));
        card6.add(new JLabel("Precio: $20000"));
        card6.add(new JLabel("Stock: 12"));
        card6.add(btn6);
        JButton btn7 = new JButton("Agregar");
btn7.setPreferredSize(new Dimension(90,30));

btn7.addActionListener(e -> {

    carritoCompra.agregarProducto(p7);

    carrito.append(
        p7.getNombre()
        + " - $"
        + p7.getPrecio()
        + "\n"
    );

    total.setText(
        "TOTAL: $"
        + carritoCompra.calcularTotal()
    );

});

JPanel card7 = new JPanel();

card7.setLayout(new GridLayout(4,1));

card7.add(new JLabel("Pedigree"));
card7.add(new JLabel("Precio: $30000"));
card7.add(new JLabel("Stock: 12"));
card7.add(btn7);




JButton btn8 = new JButton("Agregar");
btn8.setPreferredSize(new Dimension(90,30));

btn8.addActionListener(e -> {

    carritoCompra.agregarProducto(p8);

    carrito.append(
        p8.getNombre()
        + " - $"
        + p8.getPrecio()
        + "\n"
    );

    total.setText(
        "TOTAL: $"
        + carritoCompra.calcularTotal()
    );

});

JPanel card8 = new JPanel();

card8.setLayout(new GridLayout(4,1));

card8.add(new JLabel(" Chunky"));
card8.add(new JLabel("Precio: $28000"));
card8.add(new JLabel("Stock: 9"));
card8.add(btn8);



JButton btn9 = new JButton("Agregar");
btn9.setPreferredSize(new Dimension(90,30));

btn9.addActionListener(e -> {

    carritoCompra.agregarProducto(p9);

    carrito.append(
        p9.getNombre()
        + " - $"
        + p9.getPrecio()
        + "\n"
    );

    total.setText(
        "TOTAL: $"
        + carritoCompra.calcularTotal()
    );

});

JPanel card9 = new JPanel();

card9.setLayout(new GridLayout(4,1));

card9.add(new JLabel(" Hueso"));
card9.add(new JLabel("Precio: $10000"));
card9.add(new JLabel("Stock: 20"));
card9.add(btn9);




JButton btn10 = new JButton("Agregar");
btn10.setPreferredSize(new Dimension(90,30));

btn10.addActionListener(e -> {

    carritoCompra.agregarProducto(p10);

    carrito.append(
        p10.getNombre()
        + " - $"
        + p10.getPrecio()
        + "\n"
    );

    total.setText(
        "TOTAL: $"
        + carritoCompra.calcularTotal()
    );

});

JPanel card10 = new JPanel();

card10.setLayout(new GridLayout(4,1));

card10.add(new JLabel("Mordedor"));
card10.add(new JLabel("Precio: $15000"));
card10.add(new JLabel("Stock: 15"));
card10.add(btn10);




JButton btn11 = new JButton("Agregar");
btn11.setPreferredSize(new Dimension(90,30));

btn11.addActionListener(e -> {

    carritoCompra.agregarProducto(p11);

    carrito.append(
        p11.getNombre()
        + " - $"
        + p11.getPrecio()
        + "\n"
    );

    total.setText(
        "TOTAL: $"
        + carritoCompra.calcularTotal()
    );

});

JPanel card11 = new JPanel();

card11.setLayout(new GridLayout(4,1));

card11.add(new JLabel("Cepillo"));
card11.add(new JLabel("Precio: $12000"));
card11.add(new JLabel("Stock: 10"));
card11.add(btn11);




JButton btn12 = new JButton("Agregar");
btn12.setPreferredSize(new Dimension(90,30));

btn12.addActionListener(e -> {

    carritoCompra.agregarProducto(p12);

    carrito.append(
        p12.getNombre()
        + " - $"
        + p12.getPrecio()
        + "\n"
    );

    total.setText(
        "TOTAL: $"
        + carritoCompra.calcularTotal()
    );

});

JPanel card12 = new JPanel();

card12.setLayout(new GridLayout(4,1));

card12.add(new JLabel(" Toallas"));
card12.add(new JLabel("Precio: $9000"));
card12.add(new JLabel("Stock: 18"));
card12.add(btn12);
JButton btn13 = new JButton("Agregar");
btn13.setPreferredSize(new Dimension(90,30));

btn13.addActionListener(e -> {

    carritoCompra.agregarProducto(p13);

    carrito.append(
        p13.getNombre()
        + " - $"
        + p13.getPrecio()
        + "\n"
    );

    total.setText(
        "TOTAL: $"
        + carritoCompra.calcularTotal()
    );

});

JPanel card13 = new JPanel();

card13.setLayout(new GridLayout(4,1));

card13.add(new JLabel(" Collar"));
card13.add(new JLabel("Precio: $22000"));
card13.add(new JLabel("Stock: 7"));
card13.add(btn13);
      JLabel mensaje =new JLabel(" Tienda de Mascota para Todes ");

mensaje.setFont( new Font("Arial", Font.BOLD, 22));

productos.add(mensaje);

        JScrollPane scrollProductos =
                new JScrollPane(productos);

        add(scrollProductos, BorderLayout.CENTER);
        combo.addActionListener(e -> {
           

    String categoria =
            combo.getSelectedItem().toString();

    productos.removeAll();

     if(categoria.equals("Comida")){

        productos.add(card1);
        productos.add(card7);
        productos.add(card8);

    }

    if(categoria.equals("Juguetes")){

        productos.add(card2);
        productos.add(card9);
        productos.add(card10);

    }

    if(categoria.equals("Higiene")){

        productos.add(card3);
        productos.add(card11);
        productos.add(card12);

    }

    if(categoria.equals("Accesorios")){

        productos.add(card4);
        productos.add(card13);
        productos.add(card5);

    }

    productos.revalidate();
    productos.repaint();


});
        buscarBtn.addActionListener(e -> {

    String texto =
    buscar.getText().toLowerCase();

    productos.removeAll();

    if(
        p1.getNombre().toLowerCase().contains(texto)
        || texto.contains("perro")
    ){
        productos.add(card1);
    }

    if(
        p2.getNombre().toLowerCase().contains(texto)
        || texto.contains("juguete")
    ){
        productos.add(card2);
    }

    if(
        p3.getNombre().toLowerCase().contains(texto)
        || texto.contains("higiene")
    ){
        productos.add(card3);
    }

    if(
        p4.getNombre().toLowerCase().contains(texto)
        || texto.contains("perro")
    ){
        productos.add(card4);
    }

    if(
        p5.getNombre().toLowerCase().contains(texto)
        || texto.contains("gato")
    ){
        productos.add(card5);
    }

    if(
        p6.getNombre().toLowerCase().contains(texto)
        || texto.contains("higiene")
    ){
        productos.add(card6);
    }
    if(p7.getNombre().toLowerCase().contains(texto)){
    productos.add(card7);
}

if(p8.getNombre().toLowerCase().contains(texto)){
    productos.add(card8);
}

if(p9.getNombre().toLowerCase().contains(texto)){
    productos.add(card9);
}

if(p10.getNombre().toLowerCase().contains(texto)){
    productos.add(card10);
}

if(p11.getNombre().toLowerCase().contains(texto)){
    productos.add(card11);
}

if(p12.getNombre().toLowerCase().contains(texto)){
    productos.add(card12);
}

if(p13.getNombre().toLowerCase().contains(texto)){
    productos.add(card13);
}

    productos.revalidate();
    productos.repaint();

});

        

        JPanel inferior = new JPanel();

        JButton vaciar = new JButton("Vaciar carrito");

        JButton comprar =new JButton("Confirmar compra");
        JButton cancelar= new JButton("Cancelar Compra");

        String[] pagos = {
            "Seleccione Metodo de pago",
            "Tarjeta",
            "Efectivo"
        };

        JComboBox<String> metodoPago =
                new JComboBox<>(pagos);
vaciar.addActionListener(e -> {

    carrito.setText("");

    total.setText("TOTAL: $0");

    JOptionPane.showMessageDialog(
            this,
            "Carrito vaciado"
    );

});




cancelar.addActionListener(e -> {

    int opcion = JOptionPane.showConfirmDialog(
            this,
            "¿Seguro que desea cancelar el pedido?",
            "Cancelar pedido",
            JOptionPane.YES_NO_OPTION
    );

    if(opcion == JOptionPane.YES_OPTION){

        carrito.setText("");

        total.setText("TOTAL: $0");

        JOptionPane.showMessageDialog(
                this,
                "Pedido cancelado"
        );
    }

});




comprar.addActionListener(e -> {

    if (carritoCompra.calcularTotal() == 0) {

        JOptionPane.showMessageDialog(
                this,
                "El carrito está vacío"
        );

        return;
    }
    
if(metodoPago.getSelectedIndex() == 0){

    JOptionPane.showMessageDialog(
            this,
            "Seleccione un método de pago"
    );

    return;
}


    Pedido pedido =
            carritoCompra.generarPedido(1);

    Pago pago;

    if (metodoPago
            .getSelectedItem()
            .equals("Tarjeta")) {

        pago =
                new PagoporTarjetadecredito(
                        pedido.getTotal()
                );

    } else {

        pago =
                new Pagoenefectivo(
                        pedido.getTotal()
                );

    }

    pago.pagar();
String factura =
"====================================\n"
+ "        Factura Tienda de Mascota para Todes\n"
+ "====================================\n\n"

+ " Cliente: "
+ nombreDelUsuario
+ "\n"



+ "PRODUCTOS COMPRADOS:\n\n"

+ carrito.getText()

+ "\n------------------------------------\n"

+ " TOTAL FINAL: $"
+ pedido.getTotal()

+ "\n\n Método de pago: "
+ metodoPago.getSelectedItem()

+ "\n\n====================================\n"
+ " ¡Gracias por comprar en Tienda de Mascota de Todes\n"
+ "====================================";

JOptionPane.showMessageDialog(
    this,
    factura
);

            carrito.setText("");

            total.setText("TOTAL: $0");

        });

        inferior.add(total);
        inferior.add(metodoPago);
        inferior.add(vaciar);
        inferior.add(cancelar);
        inferior.add(comprar);

        add(inferior, BorderLayout.SOUTH);

        setVisible(true);
        addWindowListener(new WindowAdapter() {

    @Override
    public void windowClosing(WindowEvent e) {

        int opcion = JOptionPane.showConfirmDialog(
                null,
                "¿Desea guardar los datos antes de salir?",
                "Salir",
                JOptionPane.YES_NO_CANCEL_OPTION
        );

        if(opcion == JOptionPane.YES_OPTION){

            try{

                PrintWriter guardar =
                        new PrintWriter(
                                new FileWriter("usuario.txt")
                        );

                guardar.println(nombreDelUsuario);

                guardar.close();

                JOptionPane.showMessageDialog(
                        null,
                        "Datos guardados correctamente"
                );

            }catch(Exception ex){

                JOptionPane.showMessageDialog(
                        null,
                        "Error al guardar"
                );

            }

            System.exit(0);

        }

        else if(opcion == JOptionPane.NO_OPTION){

            System.exit(0);

        }

    }

});

    }

    

        
        
}
