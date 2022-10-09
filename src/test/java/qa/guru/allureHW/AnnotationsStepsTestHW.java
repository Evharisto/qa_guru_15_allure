package qa.guru.allureHW;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class AnnotationsStepsTestHW {

    private static final String REPOSITORY = "Evharisto/qa_guru_15_allure";
    private static final String ISSUE = "Issues";

    @DisplayName("Annotated Search Test")
    @Test
    public void testAnnotatedSearchHW() {
        WebStepsTestHW steps = new WebStepsTestHW();
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.checkIssuesTab(ISSUE);

    }
}
