package lotto.util;


import lotto.controller.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.view.outputMessage.printMessage;

public class Utils {
    public static List<String> splitName(String input) {
        return List.of(input.split(","));
    }

    public static int changeStringToInt(String input) {
        return changeNumber(input);
    }

    public static int changeNumber(String input) {
        int number = 0;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            Error error = Error.NOT_NUMBER;
            backFunction(error);
        }

        return number;
    }

    public static void backFunction(Error error) {
        try {
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException ex) {
            printMessage(error.getMsg());
            Controller controller = new Controller();
            controller.playGame();
        }
    }


    public static List<Integer> ascendingOrder(List<Integer> numbers) {
        List<Integer> orderedList = new ArrayList<Integer>(numbers);
        Collections.sort(orderedList);
        return orderedList;
    }

}
