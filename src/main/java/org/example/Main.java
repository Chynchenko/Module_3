package org.example;

import action.Actions;
import utils.UserInput;

public class Main {
    public static void main(String[] args) {
        final Actions[] values = Actions.values();
        final String[] names = UserInput.mapActionToName(values);

        while (true) {
            final int userChoice = UserInput.menu(names);
            values[userChoice].execute();
        }
    }
}