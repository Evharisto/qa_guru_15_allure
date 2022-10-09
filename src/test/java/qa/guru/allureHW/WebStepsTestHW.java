package qa.guru.allureHW;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebStepsTestHW {

    @Step("Open main page")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("Search repository {repo}")
    public void searchForRepository(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();
    }

    @Step("Click on the repository link {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Check Issues Tab {issue}")
    public void checkIssuesTab(String issue) {
        $(".UnderlineNav-body").shouldHave(Condition.text(issue));
    }


}
