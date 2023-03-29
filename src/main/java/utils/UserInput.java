package utils;

import action.Actions;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class UserInput {
    private static final BufferedReader READER =
            new BufferedReader(new InputStreamReader(System.in));

    public static int menu(final String[] names) {
        int userChoice = -1;
        do {
            System.out.println("Write what you want to do:");
            for (int i = 0; i < names.length; i++) {
                System.out.println(i + " " + names[i]);
            }
            final String line;
            try {
                line = READER.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (!StringUtils.isNumeric(line)) {
                continue;
            }
            userChoice = Integer.parseInt(line);
        } while (userChoice < 0 || userChoice >= names.length);
        return userChoice;
    }

    public static String inputName() {
        String name;
        do {
            System.out.println("Write name:");
            try {
                name = READER.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } while (name == null || name.isEmpty());
        return name;
    }

    public static double getDouble() {
        String line;
        do {
            try {
                System.out.println("Write number between 0 and 99:");
                line = READER.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } while (!StringUtils.isNumeric(line));

        return Double.parseDouble(line);
    }


    private final static Random RANDOM = new Random();

    public static String getRandomString() {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int length = RANDOM.nextInt(5, 10);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = RANDOM.nextInt(52);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    public static String[] mapActionToName(final Actions[] values) {
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].getName();
        }
        return names;
    }
}