/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecosystemsandbox;

/**
 *
 * @author bbaago
 */
public class EcosystemSandboxNewSpecimen extends java.awt.Dialog {
    private Ecosystem ecosystem;
    /**
     * Creates new form EcosystemSandboxNewSpecimen
     */
    public EcosystemSandboxNewSpecimen(java.awt.Frame parent, boolean modal, Ecosystem ecosystem) {
        super(parent, modal);
        initComponents();
        this.setTitle("Ecosystem Sandbox - New Specimen");
        this.ecosystem = ecosystem;
        this.cbSpecies.addItem(Plant.class.getSimpleName());
        this.cbSpecies.addItem(Rabbit.class.getSimpleName());
        this.cbSpecies.addItem(Fox.class.getSimpleName());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbSpecies = new javax.swing.JComboBox<>();
        btnSubmit = new java.awt.Button();
        spSpecies = new javax.swing.JSpinner();

        setPreferredSize(new java.awt.Dimension(200, 100));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        add(cbSpecies, java.awt.BorderLayout.CENTER);

        btnSubmit.setLabel("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        add(btnSubmit, java.awt.BorderLayout.SOUTH);

        spSpecies.setValue(1);
        add(spSpecies, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        int x = 0;
        for (x = 0; x < (Integer) this.spSpecies.getValue(); x++) {
            Species newSpecies = null;
            switch (this.cbSpecies.getSelectedItem().toString()) {
                case "Plant":
                    newSpecies = new Plant(this.ecosystem);
                    break;
                case "Rabbit":
                    newSpecies = new Rabbit(this.ecosystem);
                    break;
                case "Fox":
                    newSpecies = new Fox(this.ecosystem);
                    break;
                default:
            }
            this.ecosystem.addSpecies(newSpecies);
        }
        setVisible(false);
        dispose();
    }//GEN-LAST:event_btnSubmitActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnSubmit;
    private javax.swing.JComboBox<String> cbSpecies;
    private javax.swing.JSpinner spSpecies;
    // End of variables declaration//GEN-END:variables
}
