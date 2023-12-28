/**
 * @author Silvia Martinez
 * 
 */


package ventanas;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogGestionRecursosHumanos extends JDialog {
    private JTextField txtCodigoRHumanos;
    private JTextField txtNomApellido;
    private JTextField txtCargo;
    private JTextField txtEspecialidad;
    private JTable tbListaRHumanos;

    public static void main(String[] args) {
        try {
            DialogGestionRecursosHumanos dialog = new DialogGestionRecursosHumanos();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DialogGestionRecursosHumanos() {
        setTitle("GESTION DE RECURSOS HUMANOS");
        setBounds(100, 100, 750, 330);
        getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Datos de Recursos Humanos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(10, 55, 239, 260);
        getContentPane().add(panel);
        panel.setLayout(null);

        txtCodigoRHumanos = new JTextField();
        txtCodigoRHumanos.setBounds(132, 24, 86, 20);
        panel.add(txtCodigoRHumanos);
        txtCodigoRHumanos.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Codigo");
        lblNewLabel_3.setBounds(10, 27, 46, 14);
        panel.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Nombre Apellido");
        lblNewLabel_4.setBounds(10, 68, 112, 14);
        panel.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("Cargo");
        lblNewLabel_5.setBounds(10, 106, 112, 14);
        panel.add(lblNewLabel_5);

        txtNomApellido = new JTextField();
        txtNomApellido.setBounds(132, 65, 86, 20);
        panel.add(txtNomApellido);
        txtNomApellido.setColumns(10);

        txtCargo = new JTextField();
        txtCargo.setBounds(132, 103, 86, 20);
        panel.add(txtCargo);
        txtCargo.setColumns(10);

        JLabel lblNewLabel_6 = new JLabel("Especialidad");
        lblNewLabel_6.setBounds(10, 143, 112, 14);
        panel.add(lblNewLabel_6);

        txtEspecialidad = new JTextField();
        txtEspecialidad.setBounds(132, 140, 86, 20);
        panel.add(txtEspecialidad);
        txtEspecialidad.setColumns(10);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clases.RecursosHumanos objetoRecursosHumanos = new clases.RecursosHumanos();
                objetoRecursosHumanos.setCodigo(txtCodigoRHumanos.getText());
                objetoRecursosHumanos.setNomApellido(txtNomApellido.getText());
                objetoRecursosHumanos.setCargo(txtCargo.getText());
                objetoRecursosHumanos.setEspecialidad(txtEspecialidad.getText());
                objetoRecursosHumanos.agregarRegistrosRHumanos();
                txtCodigoRHumanos.setText("");
                txtNomApellido.setText("");
                txtCargo.setText("");
                txtEspecialidad.setText("");
                objetoRecursosHumanos.mostrarTotalRecursosHumanos(tbListaRHumanos);
            }
        });
        btnGuardar.setBounds(10, 168, 208, 29);
        panel.add(btnGuardar);

        JButton btnEditar = new JButton("Editar");
        btnEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clases.RecursosHumanos objetoRecursosHumanos = new clases.RecursosHumanos();
                if (tbListaRHumanos.getSelectedRow() >= 0) {
                    objetoRecursosHumanos.EditarRecursosHumanos(tbListaRHumanos);
                    objetoRecursosHumanos.mostrarTotalRecursosHumanos(tbListaRHumanos);
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una fila para editar.");
                }
            }
        });
        btnEditar.setBounds(10, 200, 99, 23);
        panel.add(btnEditar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clases.RecursosHumanos objetoRecursosHumanos = new clases.RecursosHumanos();
                objetoRecursosHumanos.EliminarRecursosHumanos(tbListaRHumanos, txtCodigoRHumanos);
            }
        });
        btnEliminar.setBounds(119, 200, 99, 23);
        panel.add(btnEliminar);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null, "Lista de Recursos Humanos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_1.setBounds(275, 54, 430, 215);
        getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 30, 410, 175);
        panel_1.add(scrollPane);

        tbListaRHumanos = new JTable();
        scrollPane.setViewportView(tbListaRHumanos);

        JButton btnCrearArchivoRecursosHumanos = new JButton("Crear Archivo para Recursos Humanos");
        btnCrearArchivoRecursosHumanos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clases.RecursosHumanos objetoRecursosHumanos = new clases.RecursosHumanos();
                objetoRecursosHumanos.crearArchivoRHumanos();
            }
        });
            
               btnCrearArchivoRecursosHumanos.setBounds(10, 21, 255, 23);
        getContentPane().add(btnCrearArchivoRecursosHumanos);

        JButton btnMostrarRHumanos = new JButton("Mostrar Recursos Humanos");
        btnMostrarRHumanos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clases.RecursosHumanos objetoRecursosHumanos = new clases.RecursosHumanos();
                objetoRecursosHumanos.mostrarTotalRecursosHumanos(tbListaRHumanos);
            }
        });
        btnMostrarRHumanos.setBounds(275, 21, 200, 23);
        getContentPane().add(btnMostrarRHumanos);

        JButton btnSeleccionar = new JButton("Seleccionar Recurso Humano");
        btnSeleccionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clases.RecursosHumanos objetoRecursosHumanos = new clases.RecursosHumanos();
                objetoRecursosHumanos.seleccionarRHumanos(tbListaRHumanos);
                txtCodigoRHumanos.setText(objetoRecursosHumanos.getCodigo());
                txtNomApellido.setText(objetoRecursosHumanos.getNomApellido());
                txtCargo.setText(objetoRecursosHumanos.getCargo());
                txtEspecialidad.setText(objetoRecursosHumanos.getEspecialidad());
            }
        });
        btnSeleccionar.setBounds(480, 20, 220, 23);
        getContentPane().add(btnSeleccionar);
    }

    DialogGestionRecursosHumanos(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}


