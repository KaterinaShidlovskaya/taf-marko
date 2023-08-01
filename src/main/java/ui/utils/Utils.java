package ui.utils;

import com.github.javafaker.Faker;

public class Utils {
    static Faker faker = new Faker();
    public static String generatePassword() {
        String password = faker.internet().password();
        return password;
    }

    public static String generatePhoneNumber() {
        String str = "1234567890";
        char ch;
        String phoneNumber = generatePhoneCodeAndFirstNumber();
        for (int i = 0; i < 6; i++) {
            int j = (int) Math.floor(Math.random() * str.length());
            ch = str.charAt(j);
            phoneNumber = phoneNumber.concat(String.valueOf(ch));
        }
        return phoneNumber;
    }

    public static String generatePhoneCodeAndFirstNumber() {
        String[] codePhoneNumber = {"29", "33"};
        int i = (int) Math.floor(Math.random() * codePhoneNumber.length);
        String phoneCode = codePhoneNumber[i];
        String firstPhoneNumber;
        if (phoneCode != "33") {
            firstPhoneNumber = generateFirstNumber1();
        } else {
            firstPhoneNumber = generateFirstNumber2();
        }
        return phoneCode + firstPhoneNumber;
    }

    public static String generateFirstNumber1() {
        String[] elements = {"2", "5", "7", "8"};
        String firstPhoneNumber = "";
        for (int i = 0; i < 1; i++) {
            int j;
            j = (int) Math.floor(Math.random() * elements.length);
            firstPhoneNumber = elements[j];
        }
        return firstPhoneNumber;
    }

    public static String generateFirstNumber2() {
        String[] elements = {"3", "6", "9"};
        String firstPhoneNumber = "";
        for (int i = 0; i < 1; i++) {
            int j;
            j = (int) Math.floor(Math.random() * elements.length);
            firstPhoneNumber = elements[j];
        }
        return firstPhoneNumber;
    }
}
