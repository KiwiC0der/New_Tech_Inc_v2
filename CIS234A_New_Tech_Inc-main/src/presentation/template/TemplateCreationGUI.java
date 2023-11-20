package presentation.template;

import data.template.Database;
import logic.template.TemplateName;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * GUI program for the Food Pantry Notification System project.
 * This class displays a simple GUI for creating and saving templates.
 *
 * @author Anteneh Demissie
 * @version 2023.05.10
 */


public class TemplateCreationGUI {

    public JPanel rootPanel;
    private JButton addTagsButton;
    private JButton saveTemplateButton;
    private JButton cancelButton;
    private JTextArea templateContent;
    private JTextField templateName;
    private JTextField templateSubject;


    public TemplateCreationGUI() {
        addTagsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame newFrame = new JFrame("Food Pantry Notification System");
                newFrame.getContentPane().add(new TemplateTagGUI().getRootPanel());
//                newFrame.getContentPane().add(new JScrollPane(templateContent));
                newFrame.pack();
                newFrame.setLocationRelativeTo(null);
                newFrame.setVisible(true);
                newFrame.getContentPane().add(new JScrollPane(templateContent));

            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(rootPanel);
                frame.dispose();
            }

        });
        saveTemplateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = templateName.getText();
                String subject = templateSubject.getText();
                String message = templateContent.getText();

                Database.saveTemplate(name,subject,message);

                JOptionPane.showMessageDialog(rootPanel, "New Template Saved Successfully!");
            }
        });
    }

    public static void addTags(String templateTag) {

        System.out.println("++++++++++++++++++++++");
        // create an instance of MyClass
        TemplateCreationGUI myClassInstance = new TemplateCreationGUI();

        // access the non-static field through the instance
        JTextArea tag = myClassInstance.templateContent;
        String text = tag.getText();

        // pass the non-static field value to the static method
        myClassInstance.addTags2(text, templateTag);

    }

    public void addTags2(String m, String t) {
        templateContent.setText(templateContent.getText() + t);
        //newFrame = getContentPane().add(new JScrollPane(templateContent));
        System.out.println(m + t);
    }

    //This method displays an invalid template name message
    public static void invalidTemplate(){
        JOptionPane.showMessageDialog(new JOptionPane(), "Template Name Already Used", "Invalid Template", JOptionPane.ERROR_MESSAGE);
    }

    //This method saves new template to the database
    public static void saveTemplate(String name, String subject, String message){
        Database.saveTemplate(name, subject, message);
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
