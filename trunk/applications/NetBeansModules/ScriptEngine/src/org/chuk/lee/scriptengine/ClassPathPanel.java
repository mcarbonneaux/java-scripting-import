/*
Copyright � 2006 Sun Microsystems, Inc., 4150 Network Circle, Santa  Clara, California
95054, U.S.A. All rights reserved.U.S. Government Rights - Commercial software.
Government users are subject to the Sun Microsystems, Inc. standard license agreement
and applicable provisions of the FAR and its supplements.  Use is subject to license
terms.  Sun, Sun Microsystems,  the Sun logo,  Java and  Jini are trademarks or registered
trademarks of Sun Microsystems, Inc. in the U.S. and other countries. This product is
covered and controlled by U.S. Export Control laws and may be subject to the export or import
laws in other countries.  Nuclear, missile, chemical biological weapons or nuclear maritime 
end uses or end users, whether direct or indirect, are strictly prohibited. Export or reexport
to countries subject to U.S. embargo or to entities identified on U.S. Export exclusion lists,
including, but not limited to, the denied persons and specially designated nationals lists is
strictly prohibited.

Copyright � 2006 Sun Microsystems, Inc., 4150 Network Circle, Santa Clara,  California 95054,
Etats-Unis. Tous droits r�serv�s.L'utilisation est soumise aux termes de la Licence.Sun, Sun
Microsystems,  le logo Sun,  Java et  Jini sont des  marques de fabrique ou des marques 
d�pos�es de Sun Microsystems, Inc. aux Etats-Unis et dans d'autres pays.Ce produit est soumis
� la l�gislation am�ricaine en mati�re de contr�le des exportations et peut �tre soumis � la 
r�glementation en vigueur dans d'autres pays dans le domaine des exportations et importations.
Les utilisations, ou utilisateurs finaux, pour des armes nucl�aires,des missiles, des armes 
biologiques et chimiques ou du nucl�aire maritime, directement ou indirectement, sont 
strictement interdites. Les exportations ou r�exportations vers les pays sous embargo 
am�ricain, ou vers des entit�s figurant sur les listes d'exclusion d'exportation am�ricaines,
y compris, mais de mani�re non exhaustive, la liste de personnes qui font objet d'un ordre de
ne pas participer, d'une fa�on directe ou indirecte, aux exportations des produits ou des 
services qui sont r�gis par la l�gislation am�ricaine en mati�re de contr�le des exportations
et la liste de ressortissants sp�cifiquement d�sign�s, sont rigoureusement interdites.
*/
/*
 * ClassPathPanel.java
 *
 * Created on June 28, 2006, 10:00 PM
 */

package org.chuk.lee.scriptengine;

import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.*;

/**
 *
 * @author  projects
 */
public class ClassPathPanel extends javax.swing.JPanel {
    
    public static final String NEWLINE = System.getProperty("line.separator");
    
    public JFileChooser chooser = null;
    
    /** Creates new form ClassPathPanel */
    public ClassPathPanel() {
        initComponents();
    }
    
    public String getClassPath() {
        return (jTextArea1.getText().trim().replaceAll(NEWLINE, File.pathSeparator));
        
    }
    public void setClassPath(String s) {
        if ((s == null) || (s.trim().length() <= 0))
            return;
        for (String cp: s.split(File.pathSeparator))
            jTextArea1.append(cp.trim() + NEWLINE);
    }
    
    private File[] browse() {
        
        if (chooser == null) {
            chooser = new JFileChooser();
            chooser.setMultiSelectionEnabled(true);
            chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
                public boolean accept(File pathname) {
                    String fn = pathname.getName();
                    return (fn.endsWith(".zip") || fn.endsWith(".jar") || pathname.isDirectory());
                }
                public String getDescription() { return "Script Engine JAR"; }
            });
        }
        
        if (chooser.showOpenDialog(this) != JFileChooser.APPROVE_OPTION)
            return (new File[0]);
        
        return (chooser.getSelectedFiles());
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Dialog", 0, 10));
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel1.setText(org.openide.util.NbBundle.getMessage(ClassPathPanel.class, "ClassPathPanel.jLabel1.text")); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 2, 10));
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText(org.openide.util.NbBundle.getMessage(ClassPathPanel.class, "ClassPathPanel.jLabel2.text")); // NOI18N

        jButton1.setFont(new java.awt.Font("Dialog", 1, 10));
        jButton1.setText(org.openide.util.NbBundle.getMessage(ClassPathPanel.class, "ClassPathPanel.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
        File[] list = browse();
        
        for (File f: list)
            jTextArea1.append(f.getAbsolutePath() + NEWLINE);
    }//GEN-LAST:event_jButton1ActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
    
}