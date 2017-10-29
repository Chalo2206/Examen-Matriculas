package go.Grupo.Matricula.ui;

import go.Grupo.Matricula.Impl.AlumnoImpl;
import go.Grupo.Matricula.Modelo.Alumno;
import go.Grupo.Matricula.Modelo.CursoMatricula;
import go.Grupo.Matricula.dao.AlumnoDao;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class FrmAlumno extends javax.swing.JFrame {
    
    List<CursoMatricula> matricula;
    private AlumnoDao alumnoDao;
    ListSelectionModel LisAlumno;
    List<Alumno> alumno;
    public static final int CREAR=0;
    public static final int MODIFICAR=1;
    private int operacion;
    public static String gDato;

    public FrmAlumno() {
        initComponents();
        setLocationRelativeTo(this);
        this.operacion=operacion;
        alumnoDao = new AlumnoImpl();
        CargarAlumnos();
    }
    
    public void Limpiar(){
        txtCodigo.setText("");
        txtNombre.setText("");
        txtapPaterno.setText("");
        txtapMaterno.setText("");
    }   
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtapPaterno = new javax.swing.JTextField();
        txtapMaterno = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnMatricula = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlumno = new javax.swing.JTable();
        btnCursos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Alumnos");

        jLabel1.setText("Codigo");

        jLabel2.setText("Nombres");

        jLabel3.setText("ap Paterno");

        jLabel4.setText("ap Materno");

        txtCodigo.setToolTipText("");

        txtNombre.setToolTipText("");

        txtapPaterno.setToolTipText("");

        txtapMaterno.setToolTipText("");

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevo);

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar);

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBorrar);

        btnMatricula.setText("Curso Matriculas");
        btnMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatriculaActionPerformed(evt);
            }
        });
        jPanel1.add(btnMatricula);

        tblAlumno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombres", "ap Paterno", "ap Materno"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAlumnoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAlumno);

        btnCursos.setText("Gestionar Cursos");
        btnCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCursosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtapMaterno))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtapPaterno, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                            .addComponent(txtCodigo)
                            .addComponent(txtNombre))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCursos)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtapPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtapMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCursos)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        if(operacion  == CREAR){            
            Alumno alumno = new Alumno(txtCodigo.getText(), txtNombre.getText(), txtapPaterno.getText(), txtapMaterno.getText());
            AlumnoDao alumnoDao = new AlumnoImpl();
            alumnoDao.guardar(alumno);
            Limpiar();
            CargarAlumnos();            
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if(operacion != MODIFICAR){         
            Alumno alumno = new Alumno(txtCodigo.getText(),txtNombre.getText(), txtapPaterno.getText(),txtapMaterno.getText());
            AlumnoDao alumnoDao = new AlumnoImpl();
            alumnoDao.modificar(alumno);
            Limpiar();
            CargarAlumnos();
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void tblAlumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAlumnoMouseClicked
        int seleccion =tblAlumno.rowAtPoint(evt.getPoint());
        txtCodigo.setText(String.valueOf(tblAlumno.getValueAt(seleccion, 0)));
        txtNombre.setText(String.valueOf(tblAlumno.getValueAt(seleccion, 1)));
        txtapPaterno.setText(String.valueOf(tblAlumno.getValueAt(seleccion, 2)));
        txtapMaterno.setText(String.valueOf(tblAlumno.getValueAt(seleccion, 3)));
        gDato = txtCodigo.getText();
    }//GEN-LAST:event_tblAlumnoMouseClicked

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        int resultado = JOptionPane.showConfirmDialog(this,"¿desea borrar al Autor", "Confirmacion",JOptionPane.YES_NO_CANCEL_OPTION);
        if(resultado == JOptionPane.YES_OPTION){
            int posicion = tblAlumno.getSelectedRow();
            DefaultTableModel modelo = (DefaultTableModel)tblAlumno.getModel();
            Alumno alumno = new Alumno((String)modelo.getValueAt(posicion, 0));
            alumnoDao.borrar(alumno); 
            Limpiar();
            CargarAlumnos();
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCursosActionPerformed
        DlgCurso dlgCurso = new DlgCurso(this, true);
        dlgCurso.setVisible(true);
    }//GEN-LAST:event_btnCursosActionPerformed

    private void btnMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatriculaActionPerformed
        DlgMatricula dlgMatricula = new DlgMatricula(this, true);
        dlgMatricula.setVisible(true);
    }//GEN-LAST:event_btnMatriculaActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCursos;
    private javax.swing.JButton btnMatricula;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAlumno;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtapMaterno;
    private javax.swing.JTextField txtapPaterno;
    // End of variables declaration//GEN-END:variables

    private void CargarAlumnos() {       
        alumno = alumnoDao.listar();
        DefaultTableModel modelo=(DefaultTableModel)tblAlumno.getModel();
        modelo.getDataVector().clear();
        for(int i =0;i<alumno.size();i++){
            modelo.addRow(new Object[]{alumno.get(i).getCodigo(), alumno.get(i).getNombres(), alumno.get(i).getApPaterno(), alumno.get(i).getApMaterno()});            
        }
    }
}
