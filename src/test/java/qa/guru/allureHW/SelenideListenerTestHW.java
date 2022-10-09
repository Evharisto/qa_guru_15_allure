package qa.guru.allureHW;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideListenerTestHW {

    @Test
    @Feature("Check Issues Tab in Repository")
    @Story("Check Issues Tab")
    @Owner("Evharisto")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Testing", url = "https://github.com/")
    @DisplayName("Check Issues Tab")
    public void testIssueSearchHW() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com/");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("Evharisto/qa_guru_15_allure");
        $(".header-search-input").submit();
        $(linkText("Evharisto/qa_guru_15_allure")).click();
        $(".UnderlineNav-body").shouldHave(Condition.text("Issues"));

    }
}
