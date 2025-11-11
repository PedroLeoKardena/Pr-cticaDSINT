package ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.Controlador;

public class Inicio {
	private JPanel contentPane;
	private JFrame frameRegister;
	private JButton aceptarButton;
	private JTextField campoNombre;
	private JTextField campoIdPersona;
	private JTextField campoEdad;
	private JTextField campoSexo;
	
	public Inicio() {
		iniciar();
		mostrarVentana();
	}
	
	public void mostrarVentana() {
		frameRegister.setLocationRelativeTo(null);
		frameRegister.setVisible(true);
	}
	
	public void cerrar() {
		this.frameRegister.dispose();
	}
	
	public void iniciar() {
		frameRegister = new JFrame();
		frameRegister.setTitle("Registro");
		frameRegister.setResizable(false);
		frameRegister.setMinimumSize(new Dimension(400, 300));
		frameRegister.setSize(new Dimension(600, 400));
		frameRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	contentPane = new JPanel();
    	contentPane.setBackground(Color.WHITE); 
		frameRegister.setContentPane(contentPane);
    	
    	GridBagLayout gridBagLay = new GridBagLayout();
    	frameRegister.getContentPane().setLayout(gridBagLay);
    	
    	gridBagLay.columnWidths = new int[]{ 75, 100, 75, 100};  
        gridBagLay.rowHeights = new int[]{ 30, 30, 30, 30};   

        JLabel labelNombre = new JLabel("Nombre Usuario");
        GridBagConstraints constraintsLabelNombre = new GridBagConstraints();
        constraintsLabelNombre.gridx = 0;  
        constraintsLabelNombre.gridy = 0; 
        constraintsLabelNombre.anchor = GridBagConstraints.CENTER; 
        constraintsLabelNombre.insets = new Insets(10, 10, 10, 10);
        contentPane.add(labelNombre, constraintsLabelNombre);

        campoNombre = new JTextField();
        GridBagConstraints constraintsCampoNombre = new GridBagConstraints();
        constraintsCampoNombre.gridx = 1;  
        constraintsCampoNombre.gridy = 0; 
    	constraintsCampoNombre.gridwidth = 3;
        constraintsCampoNombre.fill = GridBagConstraints.HORIZONTAL;
        constraintsCampoNombre.insets = new Insets(10, 10, 10, 10);
        contentPane.add(campoNombre, constraintsCampoNombre);
        
        JLabel labelIdPersona = new JLabel("idPersona");
        GridBagConstraints constraintsLabelidPersona = new GridBagConstraints();
        constraintsLabelidPersona.gridx = 0;  
        constraintsLabelidPersona.gridy = 1; 
        constraintsLabelidPersona.anchor = GridBagConstraints.CENTER; 
        constraintsLabelidPersona.insets = new Insets(10, 10, 10, 10);
        contentPane.add(labelIdPersona, constraintsLabelidPersona);

        campoIdPersona = new JTextField();
        GridBagConstraints constraintsIdPersona = new GridBagConstraints();
        constraintsIdPersona.gridx = 1; 
        constraintsIdPersona.gridy = 1;
        constraintsIdPersona.gridwidth = 3;
        constraintsIdPersona.fill = GridBagConstraints.HORIZONTAL;
        constraintsIdPersona.insets = new Insets(10, 10, 10, 10);
        contentPane.add(campoIdPersona, constraintsIdPersona);
        
        JLabel labelEdad = new JLabel("Edad");
        GridBagConstraints constraintsLabelEdad = new GridBagConstraints();
        constraintsLabelEdad.gridx = 0;  
        constraintsLabelEdad.gridy = 2; 
        constraintsLabelEdad.anchor = GridBagConstraints.CENTER; 
        constraintsLabelEdad.insets = new Insets(10, 10, 10, 10);
        contentPane.add(labelEdad, constraintsLabelEdad);

        campoEdad = new JTextField();
        GridBagConstraints constraintsCampoEdad = new GridBagConstraints();
        constraintsCampoEdad.gridx = 1;  
        constraintsCampoEdad.gridy = 2; 
        constraintsCampoEdad.fill = GridBagConstraints.HORIZONTAL;
        constraintsCampoEdad.insets = new Insets(10, 10, 10, 10);
        contentPane.add(campoEdad, constraintsCampoEdad);
        
        JLabel labelSexo = new JLabel("Sexo (M o F)");
        GridBagConstraints constraintsLabelSexo = new GridBagConstraints();
        constraintsLabelSexo.gridx = 2;  
        constraintsLabelSexo.gridy = 2; 
        constraintsLabelSexo.anchor = GridBagConstraints.CENTER; 
        constraintsLabelSexo.insets = new Insets(10, 10, 10, 10);
        contentPane.add(labelSexo, constraintsLabelSexo);

        campoSexo = new JTextField();
        GridBagConstraints constraintsCampoSexo = new GridBagConstraints();
        constraintsCampoSexo.gridx = 3;  
        constraintsCampoSexo.gridy = 2; 
        constraintsCampoSexo.fill = GridBagConstraints.HORIZONTAL;
        constraintsCampoSexo.insets = new Insets(10, 10, 10, 10);
        contentPane.add(campoSexo, constraintsCampoSexo);
        
        JButton cancelarButton = new JButton("Cancelar");
        cancelarButton.addActionListener(e ->{
        	 int respuesta = JOptionPane.showOptionDialog(
                     null, 
                     "¿Deseas cancelar el registro?", 
                     "Advertencia", 
                     JOptionPane.YES_NO_OPTION, 
                     JOptionPane.WARNING_MESSAGE, 
                     null, 
                     new Object[]{"S�", "No"}, 
                     "No"
             );
        	 if (respuesta == JOptionPane.YES_OPTION) {
        		 //El Usuario desea cancelar el registro de verdad
        		 cerrar();
             }
        });
		cancelarButton.setFont(new Font("Dialog", Font.BOLD, 11));
    	GridBagConstraints constraintsCancelar = new GridBagConstraints();
    	constraintsCancelar.insets = new Insets(10, 10, 10, 10);
    	constraintsCancelar.gridx = 1;
    	constraintsCancelar.gridy = 3;
    	constraintsCancelar.anchor = GridBagConstraints.NORTH;
    	contentPane.add(cancelarButton, constraintsCancelar);
    	
    	//Realiza el registro comprobando que los campos obligatorios estan rellenados 
    	 
    	
		aceptarButton = new JButton("Aceptar");
		aceptarButton.setFont(new Font("Dialog", Font.BOLD, 11));
    	GridBagConstraints constraintsAceptar = new GridBagConstraints();
    	constraintsAceptar.gridx = 2;
    	constraintsAceptar.gridy = 3;
    	constraintsAceptar.insets = new Insets(10, 10, 10, 10);
    	constraintsAceptar.anchor = GridBagConstraints.NORTH;
    	contentPane.add(aceptarButton, constraintsAceptar);
    	crearManejadorBtnAceptar();

	}
	
	public void crearManejadorBtnAceptar() {
    	aceptarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean OK = false;
				OK = checkFields();
				if(OK) {
					Controlador.INSTANCE.iniciarPersona(
							Integer.parseInt(campoEdad.getText()),
							campoIdPersona.getText(),
							campoNombre.getText(), 
							campoSexo.getText()
					);
					JOptionPane.showMessageDialog(frameRegister, "Usuario Iniciado correctamente.", "Registro",
							JOptionPane.INFORMATION_MESSAGE);
					new Principal();
					cerrar();
				}else {
					String sexo = campoSexo.getText();
					
					if (!sexo.equals("M") && !sexo.equals("F")){
						JOptionPane.showMessageDialog(frameRegister, "No has introducido las opciones \"M\" o \"F\".\n",
								"Registro", JOptionPane.WARNING_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(frameRegister, "Rellene todos los campos de forma correcta.\n",
								"Registro", JOptionPane.WARNING_MESSAGE);
					}
					
				}
			}
    	});
	}
	
	private boolean checkFields() {
		boolean salida = true;
		
		if (campoNombre.getText().trim().isEmpty()) {
			salida = false;
		}
		if (campoIdPersona.getText().trim().isEmpty()) {
		
			salida = false;
		}
		String edad = campoEdad.getText();
		
		int edadNum = 0;
		try {
		    edadNum = Integer.parseInt(edad);
		} catch (NumberFormatException e) {
			salida = false;
		}		
		String sexo = campoSexo.getText();
		
		if (edad.isEmpty() || edadNum < 0) {
			
			salida = false;
		} 
		if (sexo.isEmpty()) {
			
			salida = false;
		} 
		if (!sexo.equals("M") && !sexo.equals("F")) {

			salida = false;
		}
		return salida;
	}
}
