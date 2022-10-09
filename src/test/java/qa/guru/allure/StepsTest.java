package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE = 80;

    @Test
    public void testLambdaSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Open main page", () -> {
            open("https://github.com/");
        });
        step("Search repository " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });

        step("Click on the repository link " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
            });

        step("Open issue", () -> {
            $("#issues-tab").click();
                });

        step("Check issue " + ISSUE, () -> {
            $(withText("#" + ISSUE)).should(Condition.exist);
        });

    }

    @Test
    public void testAnnotatedSearch() {
      WebStepsTest steps = new WebStepsTest();
      steps.openMainPage();
      steps.searchForRepository(REPOSITORY);
      steps.clickOnRepositoryLink(REPOSITORY);
      steps.openIssuesTab();
      steps.shouldSeeIssueWithNumber(ISSUE);
    }

}
