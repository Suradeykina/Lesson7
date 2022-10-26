package su.radmi.tests;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import su.radmi.data.Locale;
import su.radmi.pages.MenuPage;
import su.radmi.pages.PassengersFormPage;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class SearchingTickets {
    PassengersFormPage passengersFormPage = new PassengersFormPage();
    MenuPage menuPage = new MenuPage();

    @CsvSource(value = {
            "Поезда и маршруты, Скоростные поезда, Фирменные поезда, Дневные поезда, Двухэтажные поезда"
    })
    @ParameterizedTest(name = "Check labels menu")
    void labelsMenu(String labelMenu, String labelList1, String labelList2, String labelList3){
        open("https://www.rzd.ru");
        menuPage.checkLabelMenuTrainsAndRoutes(labelMenu)
                .openMenu()
                .checkLabelMenuHighSpeedTrains(labelList1)
                .checkLabelMenuBrandedTrains(labelList2)
                .checkLabelMenuDayTrains(labelList3);

    }

    @ValueSource(strings = {"Санкт-Петербург"})
    @ParameterizedTest(name = "Searching tickets from {0} to Moscow")
    void toMoscowTickets(String testData) {
        open("https://www.rzd.ru");
        String cityTo = "Москва";
        passengersFormPage.setDirectionFrom(testData)
                .setDirectionTo(cityTo)
                .setDate()
                .clickSubmit()
                .checkToCard(testData)
                .checkFromCard(cityTo);
    }

    static Stream<Arguments> ButtonsText(){
        return Stream.of(
                Arguments.of(List.of("Купить билет", "Поезда и маршруты", "Вокзалы", "Тарифы и акции", "Услуги и сервисы", "РЖД Бонус", "Правила", "Информация", "Карта сайта"), Locale.Rus),
                Arguments.of(List.of("Reservation of tickets", "High-speed trains", "Suburban trains", "International routes", "Services", "Search", "Site map"), Locale.Eng)
        );
    }
    @MethodSource("ButtonsText")
    @ParameterizedTest(name = "Check button names {1}")
    void selenideSiteButtonsText(List<String> buttonsTexts, Locale locale) {
        open("https://www.rzd.ru");
        passengersFormPage.selectLanguage(locale.name());
        $$(".header_actions-item__link").shouldHave(CollectionCondition.texts(buttonsTexts));
    }

}
