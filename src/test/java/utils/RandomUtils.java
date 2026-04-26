package utils;

import java.security.SecureRandom;

import static java.lang.String.format;

public class RandomUtils {
    private static final SecureRandom rnd = new SecureRandom();

    public static String getRandomString(int length) {
        String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < length; i++)
            result.append(LETTERS.charAt(rnd.nextInt(LETTERS.length())));

        return result.toString();
    }

    public static String getRandomEmail() {
        return format("%s@%s.com", getRandomString(8), getRandomString(8));
    }

    public static String getRandomNegativeEmail() {
        String[] negativeEmails = {
                getRandomString(8) + "gmail.com",
                getRandomString(8) + "@",
                "@" + getRandomString(8) + ".com",
                getRandomString(8) + "@gmail",
                getRandomString(5) + "@" + getRandomString(5)
        };
        return negativeEmails[rnd.nextInt(negativeEmails.length)];
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return genders[rnd.nextInt(genders.length)];
    }

    public static String getRandomMonth() {
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        return months[rnd.nextInt(months.length)];
    }

    public static String getMonthNumber(String month) {
        return switch (month) {
            case "january" -> "01";
            case "february" -> "02";
            case "march" -> "03";
            case "april" -> "04";
            case "may" -> "05";
            case "june" -> "06";
            case "july" -> "07";
            case "august" -> "08";
            case "september" -> "09";
            case "october" -> "10";
            case "november" -> "11";
            case "december" -> "12";
            default -> "01";
        };
    }
}
