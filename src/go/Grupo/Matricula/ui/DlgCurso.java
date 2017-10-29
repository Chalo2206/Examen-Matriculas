package go.Grupo.Matricula.ui;

import go.Grupo.Matricula.Impl.CursoImpl;
import go.Grupo.Matricula.Modelo.Curso;
import go.Grupo.Matricula.dao.CursoDao;
import go.Grupo.Matricula.dao.CursoMatriculaDao;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class DlgCurso extends javax.swing.JDialog {
    
    private CursoDao cursoDao;
    private CursoMatriculaDao MatriculaDao;
    ListSelectionModel ListCurso;
    List<Curso> curso;
    public static final int CREAR=0;
    public static final int MODIFICAR=1;
    private int operacion;
    
    public DlgCurso(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        this.operacion=operacion;
        cursoDao = new CursoImpl();
        CargarCursos();
    }
    
    public void Limpiar(){        
        txtNombre.setText("");        
    } 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        Modificar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCurso = new javax.swing.JTable();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cursos");

        jLabel1.setText("Nombre");

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevo);

        Modificar.setText("Modificar");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });
        jPanel1.add(Modificar);

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
                "Id", "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombre)
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(6, 164, Short.MAX_VALUE)
                        .addComponent(btnCerrar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        if(operacion  == CREAR){            
            Curso curso = new Curso(0, txtNombre.getText());
            CursoDao cursoDao = new CursoImpl();
            cursoDao.guardar(curso);
            Limpiar();
            CargarCursos();            
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
         if(operacion != MODIFICAR){
            int posicion = tblCurso.getSelectedRow();
            DefaultTableModel modelo = (DefaultTableModel)tblCurso.getModel();
            Curso curso = new Curso((int)modelo.getValueAt(posicion, 0), txtNombre.getText());
            CursoDao cursoDao = new CursoImpl();
            cursoDao.modificar(curso);
            Limpiar();
            CargarCursos();
        }
    }//GEN-LAST:event_ModificarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        int resultado = JOptionPane.showConfirmDialog(this,"¿desea borrar al Autor", "Confirmacion",JOptionPane.YES_NO_CANCEL_OPTION);
        if(resultado == JOptionPane.YES_OPTION){
            int posicion = tblCurso.getSelectedRow();
            DefaultTableModel modelo = (DefaultTableModel)tblCurso.getModel();
            Curso curso = new Curso((int)modelo.getValueAt(posicion, 0));
            cursoDao.borrar(curso); 
            Limpiar();
            CargarCursos();
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void tblCursoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCursoMouseClicked
        int seleccion =tblCurso.rowAtPoint(evt.getPoint());       
        txtNombre.setText(String.valueOf(tblCurso.getValueAt(seleccion, 1)));        
    }//GEN-LAST:event_tblCursoMouseClicked

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Modificar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCurso;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    private void CargarCursos() {
        curso = cursoDao.listar();
        DefaultTableModel modelo=(DefaultTableModel)tblCurso.getModel();
        modelo.getDataVector().clear();
        for(int i =0;i<curso.size();i++){
            modelo.addRow(new Object[]{curso.get(i).getIdCurso(), curso.get(i).getDenominacion()});            
        }
    }
}
