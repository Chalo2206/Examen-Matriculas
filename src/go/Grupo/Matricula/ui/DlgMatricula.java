package go.Grupo.Matricula.ui;

import go.Grupo.Matricula.Impl.AlumnoImpl;
import go.Grupo.Matricula.Impl.MatriculaImpl;
import go.Grupo.Matricula.Modelo.Curso;
import go.Grupo.Matricula.Modelo.CursoMatricula;
import go.Grupo.Matricula.dao.CursoMatriculaDao;
import go.Grupo.Matricula.jdbc.ConexionSingleton;
import static go.Grupo.Matricula.ui.FrmAlumno.gDato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DlgMatricula extends javax.swing.JDialog {
    
    private CursoMatriculaDao matriculaDao;
    public static final int CREAR=0;
    public static final int MODIFICAR=1;
    private int operacion;
    public static int Seleccion;
    

    public DlgMatricula(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(this);
        this.operacion=operacion;
        matriculaDao = new MatriculaImpl();
        CargarMatriculas();
        Curso curso = new Curso();
        curso.MostarCliente(cboCurso);
        lblId.setVisible(false);
    }
    public void Limpiar(){
        txtCiclo.setText("");
        txtCalificacion.setText("");
    }   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboCurso = new javax.swing.JComboBox<>();
        txtCiclo = new javax.swing.JTextField();
        txtCalificacion = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCurso = new javax.swing.JTable();
        lblId = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cursos Matriculados");
        setResizable(false);

        jLabel1.setText("Curso");

        jLabel2.setText("Ciclo");

        jLabel3.setText("Calificacion");
        jLabel3.setToolTipText("");

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

        tblCurso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblCurso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCursoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCurso);

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cboCurso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCiclo, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                    .addComponent(txtCalificacion))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblId)))
                        .addGap(0, 85, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        if(operacion  == CREAR){ 
            int cur = cboCurso.getItemAt(cboCurso.getSelectedIndex()).getIdCurso();
            try {
                Connection conn = ConexionSingleton.getConnection();
                PreparedStatement ps = conn.prepareStatement("INSERT INTO CursoMatricula VALUES (null,?,?,?,?)");
                ps.setString(1, txtCiclo.getText());
                ps.setString(2, txtCalificacion.getText());
                ps.setInt(3, cur);
                ps.setString(4, gDato);
                ps.executeUpdate();
                CargarMatriculas();
            } catch (Exception e) {
                Logger.getLogger(DlgMatricula.class.getName()).log(Level.SEVERE,null,e);
            }     
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void tblCursoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCursoMouseClicked
        Seleccion = tblCurso.rowAtPoint(evt.getPoint());  
        lblId.setText(String.valueOf(tblCurso.getValueAt(Seleccion, 0)));
        txtCiclo.setText(String.valueOf(tblCurso.getValueAt(Seleccion, 1)));
        txtCalificacion.setText(String.valueOf(tblCurso.getValueAt(Seleccion, 2)));
    }//GEN-LAST:event_tblCursoMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if(operacion != MODIFICAR){
            int cur = cboCurso.getItemAt(cboCurso.getSelectedIndex()).getIdCurso();
            int Id =  Integer.parseInt(lblId.getText());
            CursoMatricula matricula = new CursoMatricula(Id, txtCiclo.getText(), txtCalificacion.getText(), cur , gDato);
            CursoMatriculaDao matriculaDao = new MatriculaImpl();
            matriculaDao.modificar(matricula);
            Limpiar();
            CargarMatriculas();
        }        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        int resultado = JOptionPane.showConfirmDialog(this,"¿desea borrar al Autor", "Confirmacion",JOptionPane.YES_NO_CANCEL_OPTION);
        if(resultado == JOptionPane.YES_OPTION){
            int Id =  Integer.parseInt(lblId.getText());
            CursoMatricula matricula = new CursoMatricula(Id);
            matriculaDao.borrar(matricula); 
            Limpiar();
            CargarMatriculas();
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<Curso> cboCurso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblId;
    private javax.swing.JTable tblCurso;
    private javax.swing.JTextField txtCalificacion;
    private javax.swing.JTextField txtCiclo;
    // End of variables declaration//GEN-END:variables

    private void CargarMatriculas() {
        try {
            String [] titulos = {"idMatricula","Ciclo","Calificacion","Curso"};
            String [] Registros = new String[4];
            DefaultTableModel model = new DefaultTableModel(null,titulos);
            Connection conn = ConexionSingleton.getConnection();
            String cons = "SELECT * FROM Curso c INNER JOIN CursoMatricula m ON c.idCurso = m.idCurso INNER JOIN Alumno a ON a.codigo = m.codigo WHERE a.codigo = " +gDato+ " GROUP BY m.idMatricula";
            Statement st = conn.createStatement();
            ResultSet rs= st.executeQuery(cons);
            while(rs.next()){
                Registros[0] = rs.getString("idMatricula");
                Registros[1] = rs.getString("ciclo");
                Registros[2] = rs.getString("calificacion");
                Registros[3] = rs.getString("denominacion");
                model.addRow(Registros);
            }
            tblCurso.setModel(model);
        } catch (Exception e) {
            Logger.getLogger(DlgMatricula.class.getName()).log(Level.SEVERE,null,e);
        }
    }
}
