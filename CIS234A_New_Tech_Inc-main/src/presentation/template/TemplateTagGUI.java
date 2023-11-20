package presentation.template;

import logic.template.TemplateTag;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static logic.template.TemplateTag.getTemplateTag;



/**
 * GUI program for the Food Pantry Notification System project.
 * This class displays a simple GUI for creating and using
 * template tags.
 *
 * @author Anteneh Demissie
 * @version 2023.05.10
 */


public class TemplateTagGUI {
    private JPanel rootPanel;
    private JComboBox tagComboBox;
    private JButton selectButton;
    private JButton cancelButton;


    public TemplateTagGUI() {
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(rootPanel);
                frame.dispose();
            }
        });
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedTag = (String) tagComboBox.getSelectedItem();
                String tag = selectedTag.toString();
                tag = TemplateTag.setTag(tag);
                TemplateCreationGUI.addTags(tag);

            }
        });

    }

    public void templateTagCombo() {
        ArrayList<String> templateTags = getTemplateTag();
        for (String tag : templateTags) {
            tagComboBox.addItem(tag);
        }
    }

    public JPanel getRootPanel() {
        templateTagCombo();
        return rootPanel;
    }
}
