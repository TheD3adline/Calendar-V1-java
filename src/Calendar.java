/*
    Author: Michael Fessler
    Date: 2023/01/10
    Version: 0.1
    Description:
            Calendar specific methods und functions.
 */
public class Calendar {

    // String Array for the output of the months
    private static final String[] months = {"January", "February", "March", "April", "May", "June", "July",
                                            "August", "September", "October", "November", "December"};

    /**
     * To read given String from textField1, check validity of input, and reformat data according to the task
     * @param input given String from textField1
     * @return String, the reformatted data or error message
     */
    public static String getInput(String input) {
        String r = "Invalid Input";
        StringBuilder outputFormat = new StringBuilder();
        //Checks validity of input
        if(input.length() >= 7) {
            if(isNumeric(input.substring(0, 2)) && isNumeric(input.substring(3, 5)) &&
                    isNumeric(input.substring(6)) && ((input.charAt(2) == '.') && (input.charAt(5) == '.'))) {
                //Reformatting of the data
                int day = Integer.parseInt(input.substring(0, 2));
                int month = Integer.parseInt(input.substring(3, 5));
                int year = Integer.parseInt(input.substring(6));
                //Checks if given data is in accordance with the Gregorian calendar by calling dateIsValid() sub-method
                if(dateIsValid(day, month, year)) {
                    if(day < 10)
                        outputFormat.append("0").append(day).append(".")
                                    .append(months[month - 1]).append(".").append(year);
                    else
                        outputFormat.append(day).append(".").append(months[month - 1]).append(".").append(year);
                    if(year < 0) { //If given year is < 0 appends B.C. to the output
                        outputFormat.append(" B.C.");
                    }
                    //Calls isLeapYear() sub-method to mark a possible leap year with the ":" for the GUI logic
                    if(isLeapYear(year))
                        outputFormat.append(":");
                    r = String.valueOf(outputFormat);
                    r = r.replace("-", "");
                }
            }
        }
        return r;
    }

    /**
     * Checks if given String is numeric
     * @param str given String
     * @return boolean true if String is numeric, false if null or not numeric
     */
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

    /**
     * Method to check if given date is in accordance with the Gregorian calendar, days per month, and 1 to 12 months
     * @param day given int for days
     * @param month given int for months
     * @param year given int for years
     * @return boolean true if given date is in accordance with Gregorian calendar, false if not
     */
    private static boolean dateIsValid(int day, int month, int year) {
        if(((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) ||
                (month == 10) || (month == 12)) && (day >= 1 && day <= 31))
            return true;
        //Calls isLeapYear() sub-method to check if month 2, February, can have 29 days if leap year or 28 if not
        else if(((month == 2) && (isLeapYear(year) && (day >= 1 && day <= 29))) ||
                ((month == 2) && (!isLeapYear(year) && (day >= 1 && day <= 28))))
            return true;
        else return ((month == 4) || (month == 6) || (month == 9) || (month == 11)) && (day >= 1 && day <= 30);
    }

    /**
     * Method to check if given year is a leap year or not according to the definition of the Gregorian calendar
     * @param year given year
     * @return boolean true if given year is a leap year, false if not
     */
    private static boolean isLeapYear(int year) {
        if((year % 4 == 0) && (year % 100 != 0))
            return true;
        return (year % 4 == 0) && (year % 100 == 0) && (year % 400 == 0);
    }
}