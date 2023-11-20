package logic.template;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TemplateNameTest {

    @org.junit.jupiter.api.Test
    void getValidTemplateName() {
        ArrayList<TemplateName> templateNames =TemplateName.getTemplateName();
        assertEquals(673, templateNames.size());
    }

    @org.junit.jupiter.api.Test
    void getName() {
        TemplateName templateName = new TemplateName("template");
        assertEquals("template", templateName.getName());
    }
}