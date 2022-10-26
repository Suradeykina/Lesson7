package su.radmi.pages;

import com.codeborne.selenide.SelenideElement;
import su.radmi.pages.components.CalendarComponent;

import java.util.Collection;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PassengersFormPage {

    private CalendarComponent calendarComponent = new CalendarComponent();

    private final SelenideElement
    fieldDirectionForm = $("#direction-from"),
    fieldDirectionTo = $("#direction-to"),
    datepickerFrom = $("#datepicker-from"),
    datepickerTo = $("#datepicker-to"),
    buttonSearch = $(".rzd-button-wrapper"),
    labelButtonLocale = $(".icon-locale span"),
    buttonLocale = $(".locale-switch__li a");

    private final Collection
            buttonNavigation = $$(".header_actions-item__link"),
            labelCardRouteTo = $$("div.card-route__station:nth-child(odd)"),
            labelCardRouteFrom = $$("div.card-route__station:nth-child(even)");

    public PassengersFormPage setDirectionFrom(String value){
        fieldDirectionForm.click();
        fieldDirectionForm.setValue(value);
        return this;
    }

    public PassengersFormPage setDirectionTo(String value) {
        fieldDirectionTo.click();
        fieldDirectionTo.setValue(value);
        return this;
    }

        public PassengersFormPage setDate() {
            datepickerFrom.click();
            calendarComponent.setDate();
            return this;
        }

    public PassengersFormPage clickSubmit() {
        buttonSearch.click();
        return this;
    }

    public PassengersFormPage checkToCard(String value) {
        labelCardRouteTo.contains(text(value));
        return this;
    }

    public PassengersFormPage checkFromCard(String value) {
        labelCardRouteFrom.contains(text(value));
        return this;
    }

    public PassengersFormPage selectLanguage(String value) {
        if (!labelButtonLocale.getOwnText().equals(value)) {
            labelButtonLocale.click();
            buttonLocale.click();
        }
        return this;
    }

}
