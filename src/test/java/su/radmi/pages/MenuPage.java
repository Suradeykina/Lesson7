package su.radmi.pages;

import com.codeborne.selenide.SelenideElement;
import su.radmi.pages.components.CalendarComponent;

import java.util.Collection;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MenuPage {


    private final SelenideElement
            labelMenuTrainsAndRoutes = $("a.header_actions-item__link[href=\"/ru/9316\"]"),
            buttonMenuTrainsAndRoutes = $("a.header_actions-item__link[href=\"/ru/9316\"]+span>span>button"),
    labelMenuHighSpeedTrains = $("a.menu-list-item_link[href=\"/ru/9318\"]>span"),
    labelMenuBrandedTrains = $("a.menu-list-item_link[href=\"/ru/9319\"]>span"),
    labelMenuDayTrains = $("a.menu-list-item_link[href=\"/ru/9320\"]>span");


    public MenuPage openMenu() {
        buttonMenuTrainsAndRoutes.click();
        return this;
    }

    public MenuPage checkLabelMenuTrainsAndRoutes(String value) {
        labelMenuTrainsAndRoutes.shouldHave(text(value));
        return this;
    }

    public MenuPage checkLabelMenuHighSpeedTrains(String value) {
        labelMenuHighSpeedTrains.shouldHave(text(value));
        return this;
    }

    public MenuPage checkLabelMenuBrandedTrains(String value) {
        labelMenuBrandedTrains.shouldHave(text(value));
        return this;
    }

    public MenuPage checkLabelMenuDayTrains(String value) {
        labelMenuDayTrains.shouldHave(text(value));
        return this;
    }


}
