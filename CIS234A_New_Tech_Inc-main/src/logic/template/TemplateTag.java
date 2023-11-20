package logic.template;

import presentation.template.TemplateCreationGUI;

import java.awt.event.ActionListener;
import java.time.LocalDate;

import java.util.ArrayList;

/**
 * GUI program for the Food Pantry Notification System project.
 * This class stores the template tags.
 *
 * @author Anteneh Demissie
 * @version 2023.05.10
 */

public class TemplateTag {
    private static String templateTag;
    public static String selectedTag;

    public TemplateTag(String tags) {
        templateTag = tags;
    }

    //This method makes an arraylist for the Template tags.
    public static ArrayList<String> getTemplateTag() {
        ArrayList<String> tags = new ArrayList<>();
        tags.add("Date");
        tags.add("Sylvania Address");
        tags.add("Rock Creek Address");
        tags.add("Cascade Address");
        tags.add("SouthEast Address");

        return tags;
    }
    //This method retrieve and processes the selected tag.
    //@Param String n.
    //@Returns String templateTag
    public static String setTag(String n) {

        if (n == "Date"){
            LocalDate date = LocalDate.now();
            templateTag = date.toString();

        }
        if (n == "Sylvania Address"){
            templateTag = "12000 SW 49th Ave, Portland, OR 97219";

        }
        if (n == "Rock Creek Address"){
            templateTag = "17705 NW Springville Rd, Portland, OR 97229";

        }
        if (n == "Cascade Address"){
            templateTag = "705 N Killingsworth St, Portland, OR 97217";

        }
        if (n == "SouthEast Address"){
            templateTag = "2305 SE 82nd Ave, Portland, OR 97216";

        }
        return templateTag;
    }
}


