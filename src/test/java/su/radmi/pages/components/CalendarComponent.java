package su.radmi.pages.components;

import static com.codeborne.selenide.Selenide.$;


public class CalendarComponent {

    public CalendarComponent setDate() {
       // $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();
        $("td[data-month='10'][data-year='2022']>a").click();
        return this;
    }

}
