package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class PrivacyPage {

    private static final SelenideElement

            startButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_done_button")),
            skipButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button"));

    @Step("Tap Start button")
    public void clickStartButton() {
        startButton.click();
    }

    @Step("Check Skip button is not visible and not clickable")
    public PrivacyPage checkSkipButton() {
        skipButton.shouldNotBe(visible);
        return this;
    }
}
