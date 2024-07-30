package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

public class WikiTests extends TestBase {

    @Test
    @Tag("android")
    @DisplayName("Check successful search case")
    void successfulSearchTest() {
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Verify content found", () -> $$(id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @Tag("android")
    @DisplayName("Check voice search button")
    void checkVoiceSearchTest() {
        step("Click on voice search button", () -> {
            $(id("org.wikipedia.alpha:id/voice_search_button")).click();
        });
        step("Check voice search is available", () -> {
            $(id("com.google.android.tts:id/transcription_mic_image_indicator")).shouldBe(visible);
            $(id("com.google.android.tts:id/transcription_intent_api_text")).shouldHave(text("Try saying something"));
        });
    }

    @Test
    @Tag("android")
    @DisplayName("Check open article")
    void successfulOpenArticleTest() {
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys(" QA");
        });
        step("Open article", () -> $(id("org.wikipedia.alpha:id/page_list_item_title")).click());
        step("Check article", () -> $(xpath("//android.widget.TextView[@text='QA']")).shouldBe(visible));
    }
}

