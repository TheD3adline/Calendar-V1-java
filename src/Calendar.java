/*
    Author: Michael Fessler
    Date: 2023/01/10
    Version: 0.1
    Description:
            Class with calendar specific methods und functions.
 */
public class Calendar {

    private static String day;
    private static String month;
    private static String year;
    private static final String[] months = {"January", "February", "March", "April", "May", "June", "July",
                                            "August", "September", "October", "November", "December"};

    public static String getInput(String input) {
        String r = "Invalid Input";
        if(input.length() == 10) {
            if(isNumeric(input.substring(0, 2)) && isNumeric(input.substring(3, 5)) &&
                    isNumeric(input.substring(6))) {
                int day = Integer.parseInt(input.substring(0, 2));
                int month = Integer.parseInt(input.substring(3, 5));
                int year = Integer.parseInt(input.substring(6));
                if(dateIsValid(day, month, year)) {

                }
            }
        }
        return r;
    }

    private static boolean isNumeric(String str) {
        if(str == null)
            return false;
        try {
            Integer.parseInt(str);
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static boolean dateIsValid(int day, int month, int year) {
        if(((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) ||
                (month == 10) || (month == 12)) && (day >= 1 && day <= 31))
            return true;
        else if(((month == 2) && (isLeapYear(year) && (day >= 1 && day <= 29))) ||
                ((month == 2) && (!isLeapYear(year) && (day >= 1 && day <= 28))))
            return true;
        else return ((month == 4) || (month == 6) || (month == 9) || (month == 11)) && (day >= 1 && day <= 30);
    }

    private static boolean isLeapYear(int year) {
        if((year % 4 == 0) && (year % 100 != 0))
            return true;
        return (year % 4 == 0) && (year % 100 == 0) && (year % 400 == 0);
    }
}