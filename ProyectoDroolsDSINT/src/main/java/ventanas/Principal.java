package ventanas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.Controlador;

public class Principal {
	
	private JPanel contentPane;
	private JFrame frameMain;
    private JButton btnCargar;
    private JButton btnLanzarVeredicto;
    private JTextField txtEstado;
    
	public Principal() {
		iniciar();
		mostrarVentana();
	}
	
	public void cerrar() {
		this.frameMain.dispose();
	}
	
	public void mostrarVentana() {
		frameMain.setLocationRelativeTo(null);
		frameMain.setVisible(true);
	}
	
	public void iniciar() {
		 // Crear ventana principal
        frameMain = new JFrame("Registro ECG");
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMain.setSize(400, 150);

        // Crear panel de contenido
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(10, 10));
        frameMain.setContentPane(contentPane);

        // Crear bot�n
        btnCargar = new JButton("Cargar RegistroECG (.ecg)");
        btnLanzarVeredicto = new JButton("Pedir Resultados");

        // Crear campo de texto vac�o
        txtEstado = new JTextField();
        txtEstado.setEditable(false); // el usuario no puede escribir
        txtEstado.setText(""); // inicialmente vac�o

        // A�adir observador (listener) al bot�n
        btnCargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Circunstancia: se pulsa el bot�n
                System.out.println("Boton pulsado. Procesando archivo ECG...");
                new VentanaFicheros();
                // Simular que ocurre la circunstancia deseada
                txtEstado.setText("Procesando archivo ECG...");
            }
        });
        
        btnLanzarVeredicto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int opcion = JOptionPane.showConfirmDialog(
			            null,
			            "¿Estás seguro que quieres lanzar la sesión y acceder a los resultados?\n" +
			            "Asegúrate de haber introducido todos los registros (.ecg) para hacer los resultados acordes a ellos,\n" + 
			            "ya que la aplicación se cerrará una vez lanzada la sesión.",
			            "Confirmación",
			            JOptionPane.YES_NO_OPTION,
			            JOptionPane.WARNING_MESSAGE
			        );

			        if (opcion == JOptionPane.YES_OPTION) {
			        	Controlador.INSTANCE.crearSesion();
			        	cerrar();
			        }
				
			}
			
        });

        // A�adir componentes al panel
        contentPane.add(btnCargar, BorderLayout.NORTH);
        contentPane.add(txtEstado, BorderLayout.CENTER);
        contentPane.add(btnLanzarVeredicto, BorderLayout.SOUTH);
	}
	
}
