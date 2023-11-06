package lotto;

import java.util.ArrayList;
import java.util.List;

public class Convertor {

    private static final Integer LOTTERY_NUMBERS = 6;

    public static Integer convertInputToInteger(String userInput) {
        return Integer.parseInt(userInput);
    }

    public static String[] splitInput(String userInput) {
        return userInput.split(",");
    }

    public static List<Integer> convertToList(String[] userInputArray) {
        List<Integer> numbersList = new ArrayList<>();
        for (int i = 0; i < LOTTERY_NUMBERS; i++) {
            String numberTemp = userInputArray[i];
            int winningNumber = Integer.parseInt(numberTemp);
            numbersList.add(winningNumber);
        }
        return numbersList;
    }
}
