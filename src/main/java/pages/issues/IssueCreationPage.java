package pages.issues;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.List;

public class IssueCreationPage extends BasePage {

    private final static String TITLE = "Страница создания задачи";

    public IssueCreationPage(WebDriver driver) {
        super(driver, TITLE);
    }

    private final By issueTitleField = By.id("issue_title");
    private final By issueBodyField = By.id("issue_body");
    private final By issueCreationButton = By.xpath("//button[@class = 'btn btn-primary']");
    private final By issueLabels = By.xpath("//div[@class = 'css-truncate']");

    public IssueInfoPage createNewIssue(String title, String body){
        log.info("Создаём новую задачу");
        Assert.assertTrue(driver.findElement(issueTitleField).isDisplayed());
        driver.findElement(issueTitleField).sendKeys(title);
        Assert.assertTrue(driver.findElement(issueBodyField).isDisplayed());
        driver.findElement(issueBodyField).sendKeys(body);
        Assert.assertTrue(driver.findElement(issueCreationButton).isDisplayed());
        driver.findElement(issueCreationButton).click();
        log.info("Задача создана");


        List<WebElement> labels = driver.findElements(issueLabels);
        for (WebElement label : labels){
            Assert.assertTrue(label.isDisplayed());
            label.click();
        }

        return new IssueInfoPage(driver);
    }
}
