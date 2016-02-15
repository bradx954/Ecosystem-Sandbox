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
public class EcosystemSandbox {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws CloneNotSupportedException, InterruptedException {
        EcosystemSandboxNew dialog = new EcosystemSandboxNew(new java.awt.Frame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        dialog.setVisible(true);
    }
    
}
