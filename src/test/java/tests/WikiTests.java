package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class WikiTests extends TestBase {

    @Test
    @DisplayName("Check successful search case")
    void successfulSearchTest() {
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Verify content found", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }


    @Test
    @DisplayName("Check voice search button")
    void checkTest() {
        step("Click on voice search button", () -> {
            $(id("org.wikipedia.alpha:id/voice_search_button")).click();
        });

        step("Check voice search is available", () ->
                $(id("org.wikipedia.alpha:id/transcription_mic_image_indicator_background")).should(exist));
                $(id("org.wikipedia.alpha:id/transcription_intent_api_text"))
                        .shouldHave(text("Try saying something"));
    }
}
