package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.*;

public class LanguagePage {

    private static final SelenideElement

            addDeleteLanguageButton = $(id("org.wikipedia.alpha:id/addLanguageButton")),
            continueButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")),
            skipButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button"));


    @Step("Check Language button")
    public LanguagePage checkLanguageButton() {
        addDeleteLanguageButton.shouldBe(visible);
        return this;
    }

    @Step("Tap Continue button")
    public void clickContinueButton() {
        continueButton.click();
    }

//    @Step("Check Skip button is visible")
    public LanguagePage checkSkipButton() {
        skipButton.shouldBe(visible);
        return this;
    }
}