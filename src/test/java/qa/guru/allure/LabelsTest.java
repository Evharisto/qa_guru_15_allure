package qa.guru.allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LabelsTest {

    @Test
    @Feature("Issue in repository")
    @Story("Create Issue")
    @Owner("eroshenkoam")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://github.com/")
    @DisplayName("Create issue for authorized user")
    public void testStaticLabels() {


    }

    @Test
    public void testDynamicLabels() {
     Allure.getLifecycle().updateTestCase(
             t -> t.setName("Create issue for authorized user")
     );
     Allure.feature("Issue in repository");
     Allure.story("Create Issue");
     Allure.label("owner", "eroshenkoam");
     Allure.label("severity", SeverityLevel.CRITICAL.value());
     Allure.link("Testing", "https://github.com/");
    }

}
