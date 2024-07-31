package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class ListsOfReadingPage {

    private static final SelenideElement

            continueButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")),
            skipButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button"));

    @Step("Tap Continue button")
    public void clickContinueButton() {
        continueButton.click();
    }

    @Step("Check Skip button is visible and clickable")
    public ListsOfReadingPage checkSkipButton() {
        skipButton.shouldBe(visible);
        return this;
    }
}
