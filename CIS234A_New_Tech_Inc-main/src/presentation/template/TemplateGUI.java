package presentation.template;

import logic.template.TemplateName;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * GUI program for the Food Pantry Notification System project.
 * This class displays a simple GUI for using and creating templates.
 *
 * @author Anteneh Demissie
 * @version 2023.05.03
 */

public class TemplateGUI {
    private JPanel rootPanel;
    private JComboBox templateNameCombo;
    private JButton createNewTemplateButton;
    private JButton useSelectedTemplateButton;
    private JButton cancelButton;

    public TemplateGUI() {
        createNewTemplateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame newFrame = new JFrame("Food Pantry Notification System");

                newFrame.getContentPane().add(new TemplateCreationGUI().getRootPanel());

                newFrame.pack();
                newFrame.setLocationRelativeTo(null);
                newFrame.setVisible(true);
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(rootPanel);
                frame.dispose();
            }
        });
        useSelectedTemplateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(rootPanel, "Not Yet Implemented");
            }
        });
    }

    //This method fills the ComboBox with the data from the templateName column.
    public void templateNameCombo(){
        ArrayList<TemplateName> templateNames = TemplateName.getTemplateName();
        for (TemplateName name : templateNames){
           templateNameCombo.addItem(name.getName());
        }

    }

    public JPanel getRootPanel() {
        templateNameCombo();
        return rootPanel;
    }
}
