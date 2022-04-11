package qa.guru.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Calendar {

    public static String newYear;
    public static String monthName;
    public static String newDay;
    public static String fullBirthDate;

    // selectors
    SelenideElement yearSelector = $(".react-datepicker__year-select");
    SelenideElement monthSelector = $(".react-datepicker__month-select");
    SelenideElement daySelector(String day) {
        return $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)");
    }

    // actions
    public void setDate(Integer day, Integer month, Integer year) {
        newYear = year.toString();
        yearSelector.selectOption(newYear);
        switch (month) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + month);
        }
        monthSelector.selectOption(monthName);
        if (day < 10) {
            newDay = "0" + day;
        } else {
            newDay = day.toString();
        }
        daySelector(newDay).click();
        fullBirthDate = newDay + " " + monthName + "," + newYear;
    }
}
