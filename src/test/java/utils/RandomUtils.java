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
        switch (month) {
            case "January": return "01";
            case "February": return "02";
            case "March": return "03";
            case "April": return "04";
            case "May": return "05";
            case "June": return "06";
            case "July": return "07";
            case "August": return "08";
            case "September": return "09";
            case "October": return "10";
            case "November": return "11";
            case "December": return "12";
            default: return "01";
        }
    }
}
