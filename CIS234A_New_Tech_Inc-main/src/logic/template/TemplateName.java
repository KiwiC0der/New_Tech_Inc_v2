package logic.template;

import data.template.Database;
import presentation.template.TemplateCreationGUI;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

/**
 * GUI program for the Food Pantry Notification System project.
 * This class stores the template names.
 *
 * @author Anteneh Demissie
 * @version 2023.05.03
 */
public class TemplateName {
    private final String templateName;

    public TemplateName(String n){
        templateName = n;
    }

    //This method makes an arraylist from the Template name data.
    public static ArrayList<TemplateName> getTemplateName(){
        return Database.getTemplateName();
    }
    public String getName() {
        return templateName;
    }

}
