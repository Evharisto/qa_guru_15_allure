package qa.guru.allureHW;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LambdaTestHW {

    private static final String REPOSITORY = "Evharisto/qa_guru_15_allure";

    @DisplayName("Lambda Search Test")
    @Test
    public void testLambdaSearchHW() {
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

        step("Check Issues Tab", () -> {
            $("#issues-tab").should(Condition.exist);
        });
    }
}
