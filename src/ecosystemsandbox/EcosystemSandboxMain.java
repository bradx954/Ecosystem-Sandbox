/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecosystemsandbox;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bbaago
 */
public class EcosystemSandboxMain extends java.awt.Frame {

    private Ecosystem ecosystem;
    /**
     * Creates new form EcosystemSandboxMain with given ecosystem.
     * @param ecosystem
     */
    public EcosystemSandboxMain(Ecosystem ecosystem) {
        initComponents();
        this.ecosystem = ecosystem;
        this.slidClone.setValue(this.ecosystem.getClone());
        this.updateLabels();
        this.updateList();
    }
    private void updateList()
    {
        this.listSpecimens.removeAll();
        this.listNewSpecimens.removeAll();
        this.listDeadSpecimens.removeAll();
        this.ecosystem.getSpecimens().stream().forEach((specimen) -> {
            this.listSpecimens.add(specimen.getClass().getSimpleName()+": "+Integer.toString(specimen.getID()));
        });
        this.ecosystem.getNewSpecimens().stream().forEach((specimen) -> {
            try {
                this.listNewSpecimens.add(specimen.getClass().getSimpleName()+": "+Integer.toString(specimen.getID()));
            } catch (NullPointerException ex) {
                Logger.getLogger(Ecosystem.class.getName()).log(Level.SEVERE, "Ignored empty species.", ex);
            }
        });
        this.ecosystem.getDeadSpecimens().stream().forEach((specimen) -> {
            try {
                this.listDeadSpecimens.add(specimen.getClass().getSimpleName()+": "+Integer.toString(specimen.getID()));
            } catch (NullPointerException ex) {
                Logger.getLogger(Ecosystem.class.getName()).log(Level.SEVERE, "Ignored empty species.", ex);
            }
        });
    }
    private void updateLabels()
    {
        this.lblAreaValue.setText(Integer.toString(this.ecosystem.getArea()));
        this.lblHeightValue.setText(Integer.toString(this.ecosystem.getAtmosphere().getArea()/this.ecosystem.getArea()));
        this.lblCarbonDioxideValue.setText(Double.toString(this.ecosystem.getAtmosphere().getCarbonDioxide()));
        this.lblOxygenValue.setText(Double.toString(this.ecosystem.getAtmosphere().getOxygen()));
        this.lblNitrogenValue.setText(Double.toString(this.ecosystem.getAtmosphere().getNitrogen()));
        this.lblTemperatureValue.setText(Double.toString(this.ecosystem.getAtmosphere().getTemperature()));
        this.lblTicksValue.setText(Integer.toString(this.ecosystem.getTicks()));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        plDetails = new java.awt.Panel();
        lblEcosystem = new java.awt.Label();
        lblArea = new java.awt.Label();
        lblAreaValue = new java.awt.Label();
        lblHeight = new java.awt.Label();
        lblHeightValue = new java.awt.Label();
        lblOxygen = new java.awt.Label();
        lblOxygenValue = new java.awt.Label();
        lblCarbonDioxide = new java.awt.Label();
        lblCarbonDioxideValue = new java.awt.Label();
        lblNitrogen = new java.awt.Label();
        lblNitrogenValue = new java.awt.Label();
        lblTemperature = new java.awt.Label();
        lblTemperatureValue = new java.awt.Label();
        lblTicks = new javax.swing.JLabel();
        lblTicksValue = new javax.swing.JLabel();
        slidClone = new javax.swing.JSlider();
        lblClone = new javax.swing.JLabel();
        btnCycle = new java.awt.Button();
        txtDetails = new java.awt.TextArea();
        tabSpecimens = new javax.swing.JTabbedPane();
        listSpecimens = new java.awt.List();
        listNewSpecimens = new java.awt.List();
        listDeadSpecimens = new java.awt.List();
        menuBar1 = new java.awt.MenuBar();
        File = new java.awt.Menu();
        newSpecimen = new java.awt.MenuItem();
        Edit = new java.awt.Menu();

        setMinimumSize(new java.awt.Dimension(800, 600));
        setSize(new java.awt.Dimension(800, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        plDetails.setLayout(new java.awt.GridBagLayout());

        lblEcosystem.setText("Ecosystem Details");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        plDetails.add(lblEcosystem, gridBagConstraints);

        lblArea.setText("Area (m2)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        plDetails.add(lblArea, gridBagConstraints);

        lblAreaValue.setAlignment(java.awt.Label.RIGHT);
        lblAreaValue.setText("label");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        plDetails.add(lblAreaValue, gridBagConstraints);

        lblHeight.setText("Height (m)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        plDetails.add(lblHeight, gridBagConstraints);

        lblHeightValue.setAlignment(java.awt.Label.RIGHT);
        lblHeightValue.setText("label1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        plDetails.add(lblHeightValue, gridBagConstraints);

        lblOxygen.setText("Oxygen(grams per m3)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        plDetails.add(lblOxygen, gridBagConstraints);

        lblOxygenValue.setAlignment(java.awt.Label.CENTER);
        lblOxygenValue.setPreferredSize(new java.awt.Dimension(200, 19));
        lblOxygenValue.setText("big double value");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        plDetails.add(lblOxygenValue, gridBagConstraints);

        lblCarbonDioxide.setText("CarbonDioxide(grams per m3)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        plDetails.add(lblCarbonDioxide, gridBagConstraints);

        lblCarbonDioxideValue.setAlignment(java.awt.Label.CENTER);
        lblCarbonDioxideValue.setPreferredSize(new java.awt.Dimension(200, 19));
        lblCarbonDioxideValue.setText("big double value");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        plDetails.add(lblCarbonDioxideValue, gridBagConstraints);

        lblNitrogen.setText("Nitrogen(grams per m3)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        plDetails.add(lblNitrogen, gridBagConstraints);

        lblNitrogenValue.setAlignment(java.awt.Label.CENTER);
        lblNitrogenValue.setPreferredSize(new java.awt.Dimension(200, 19));
        lblNitrogenValue.setText("big double value");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        plDetails.add(lblNitrogenValue, gridBagConstraints);

        lblTemperature.setText("Temperature(Celsius)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 2;
        plDetails.add(lblTemperature, gridBagConstraints);

        lblTemperatureValue.setAlignment(java.awt.Label.CENTER);
        lblTemperatureValue.setPreferredSize(new java.awt.Dimension(200, 19));
        lblTemperatureValue.setText("big double value");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 2;
        plDetails.add(lblTemperatureValue, gridBagConstraints);

        lblTicks.setText("Ticks:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        plDetails.add(lblTicks, gridBagConstraints);

        lblTicksValue.setText("ticks");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        plDetails.add(lblTicksValue, gridBagConstraints);

        slidClone.setMajorTickSpacing(1);
        slidClone.setMaximum(10);
        slidClone.setMinimum(1);
        slidClone.setPaintLabels(true);
        slidClone.setPaintTicks(true);
        slidClone.setValue(1);
        slidClone.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slidCloneStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        plDetails.add(slidClone, gridBagConstraints);

        lblClone.setText("Reproduction Chance(1 in x)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        plDetails.add(lblClone, gridBagConstraints);

        add(plDetails, java.awt.BorderLayout.WEST);

        btnCycle.setLabel("Next Tic");
        btnCycle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCycleActionPerformed(evt);
            }
        });
        add(btnCycle, java.awt.BorderLayout.SOUTH);

        txtDetails.setEditable(false);
        add(txtDetails, java.awt.BorderLayout.EAST);

        tabSpecimens.setPreferredSize(new java.awt.Dimension(300, 143));

        listSpecimens.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                listSpecimensItemStateChanged(evt);
            }
        });
        listSpecimens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listSpecimensActionPerformed(evt);
            }
        });
        tabSpecimens.addTab("Specimens", listSpecimens);

        listNewSpecimens.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                listNewSpecimensItemStateChanged(evt);
            }
        });
        tabSpecimens.addTab("New", listNewSpecimens);

        listDeadSpecimens.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                listDeadSpecimensItemStateChanged(evt);
            }
        });
        tabSpecimens.addTab("Dead", listDeadSpecimens);

        add(tabSpecimens, java.awt.BorderLayout.CENTER);
        tabSpecimens.getAccessibleContext().setAccessibleName("Specimens");
        tabSpecimens.getAccessibleContext().setAccessibleDescription("Specimens");

        File.setLabel("File");

        newSpecimen.setActionCommand("newSpecimen");
        newSpecimen.setLabel("New Specimen");
        newSpecimen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newSpecimenActionPerformed(evt);
            }
        });
        File.add(newSpecimen);

        menuBar1.add(File);

        Edit.setLabel("Edit");
        menuBar1.add(Edit);

        setMenuBar(menuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void btnCycleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCycleActionPerformed
        this.btnCycle.setEnabled(false);
        try {
            this.ecosystem.tick();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(EcosystemSandboxMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(EcosystemSandboxMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.updateLabels();
        this.updateList();
        this.btnCycle.setEnabled(true);
    }//GEN-LAST:event_btnCycleActionPerformed

    private void newSpecimenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newSpecimenActionPerformed
        EcosystemSandboxNewSpecimen dlg = new EcosystemSandboxNewSpecimen(new java.awt.Frame(), true, this.ecosystem);
        dlg.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        dlg.setVisible(true);
        this.updateList();
    }//GEN-LAST:event_newSpecimenActionPerformed

    private void listSpecimensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listSpecimensActionPerformed
        
    }//GEN-LAST:event_listSpecimensActionPerformed

    private void listSpecimensItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listSpecimensItemStateChanged
        int specimenID = Integer.parseInt(this.listSpecimens.getSelectedItem().toString().split(": ")[1]);
        Species selected = null;
        for(Species specimen : this.ecosystem.getSpecimens())
        {
            if(specimenID == specimen.getID())
            {
                selected = specimen;
                break;
            }
        }
        this.txtDetails.setText(selected.toString());
    }//GEN-LAST:event_listSpecimensItemStateChanged

    private void slidCloneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slidCloneStateChanged
        this.ecosystem.setClone(this.slidClone.getValue());
    }//GEN-LAST:event_slidCloneStateChanged

    private void listNewSpecimensItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listNewSpecimensItemStateChanged
        int specimenID = Integer.parseInt(this.listNewSpecimens.getSelectedItem().toString().split(": ")[1]);
        Species selected = null;
        for(Species specimen : this.ecosystem.getNewSpecimens())
        {
            if(specimenID == specimen.getID())
            {
                selected = specimen;
                break;
            }
        }
        this.txtDetails.setText(selected.toString());
    }//GEN-LAST:event_listNewSpecimensItemStateChanged

    private void listDeadSpecimensItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listDeadSpecimensItemStateChanged
        int specimenID = Integer.parseInt(this.listDeadSpecimens.getSelectedItem().toString().split(": ")[1]);
        Species selected = null;
        for(Species specimen : this.ecosystem.getDeadSpecimens())
        {
            if(specimenID == specimen.getID())
            {
                selected = specimen;
                break;
            }
        }
        this.txtDetails.setText(selected.toString());
    }//GEN-LAST:event_listDeadSpecimensItemStateChanged



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Menu Edit;
    private java.awt.Menu File;
    private java.awt.Button btnCycle;
    private java.awt.Label lblArea;
    private java.awt.Label lblAreaValue;
    private java.awt.Label lblCarbonDioxide;
    private java.awt.Label lblCarbonDioxideValue;
    private javax.swing.JLabel lblClone;
    private java.awt.Label lblEcosystem;
    private java.awt.Label lblHeight;
    private java.awt.Label lblHeightValue;
    private java.awt.Label lblNitrogen;
    private java.awt.Label lblNitrogenValue;
    private java.awt.Label lblOxygen;
    private java.awt.Label lblOxygenValue;
    private java.awt.Label lblTemperature;
    private java.awt.Label lblTemperatureValue;
    private javax.swing.JLabel lblTicks;
    private javax.swing.JLabel lblTicksValue;
    private java.awt.List listDeadSpecimens;
    private java.awt.List listNewSpecimens;
    private java.awt.List listSpecimens;
    private java.awt.MenuBar menuBar1;
    private java.awt.MenuItem newSpecimen;
    private java.awt.Panel plDetails;
    private javax.swing.JSlider slidClone;
    private javax.swing.JTabbedPane tabSpecimens;
    private java.awt.TextArea txtDetails;
    // End of variables declaration//GEN-END:variables
}
