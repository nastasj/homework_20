package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.ExplorePage;
import pages.LanguagePage;
import pages.ListsOfReadingPage;
import pages.PrivacyPage;

public class OnboardingTests extends TestBase {

    @Test
    @Tag("android")
    @DisplayName("Check onboarding screens")
    void checkOnboardingScreensTest() {

        LanguagePage languagePage = new LanguagePage();
        ExplorePage explorePage = new ExplorePage();
        ListsOfReadingPage listsOfReadingPage = new ListsOfReadingPage();
        PrivacyPage privacyPage = new PrivacyPage();

        languagePage.checkSkipButton()
                .checkLanguageButton()
                .clickContinueButton();

        explorePage.checkSkipButton()
                .clickContinueButton();

        listsOfReadingPage.checkSkipButton()
                .clickContinueButton();

        privacyPage.checkSkipButton()
                .clickStartButton();
    }
}
