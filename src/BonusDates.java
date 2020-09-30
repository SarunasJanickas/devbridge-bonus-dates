public class BonusDates {
    static void printBonusDatesBetween(int fromYear, int toYear) {
        for (int year = fromYear; year < toYear; year++) {
            if (year == 0) {
                continue;
            }
            for (int month = 1; month <= 12; month++) {
                for (int day = 1; day <= getMaxDaysInMonth(year, month); day++) {
                    int date = 0;
                    if (year < 0) {
                        date = year * -10000 + month * 100 + day;
                    } else {
                        date = year * 10000 + month * 100 + day;
                    }
                    int dateReversed = dateReversed(date);
                    if (date == dateReversed) {
                        printDate(year, month, day);
                    }
                }
            }
        }
    }

    private static boolean isLeapYear(int year) {
        return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
    }

    private static int getMaxDaysInMonth(int year, int month) {
        switch (month) {
            case 1: {
                return 31;
            }
            case 2: {
                if (isLeapYear(year)) {
                    return 29;
                } else {
                    return 28;
                }
            }
            case 3: {
                return 31;
            }
            case 4: {
                return 30;
            }
            case 5: {
                return 31;
            }
            case 6: {
                return 30;
            }
            case 7: {
                return 31;
            }
            case 8: {
                return 31;
            }
            case 9: {
                return 30;
            }
            case 10: {
                return 31;
            }
            case 11: {
                return 30;
            }
            case 12: {
                return 31;
            }
            default: {
                return 0;
            }
        }
    }

    private static int dateReversed(int date) {
        int tempNumber;
        int dateReversed = 0;
        for (int i = date; i > 0; i = (i - tempNumber) / 10) {
            tempNumber = i % 10;
            dateReversed = dateReversed * 10 + tempNumber;
        }
        return dateReversed;
    }

    private static void printDate(int year, int month, int day) {
        System.out.printf("%d-", year);
        if (month < 10) {
            System.out.printf("0%d-", month);
        } else {
            System.out.printf("%d-", month);
        }
        if (day < 10) {
            System.out.printf("0%d\n", day);
        } else {
            System.out.printf("%d\n", day);
        }
    }
}