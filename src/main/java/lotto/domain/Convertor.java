package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Convertor {

    private static final Integer LOTTERY_NUMBERS = 6;


    public static Integer convert(String userInput) {
        return Integer.parseInt(userInput);
    }

    public static String[] split(String userInput) {
        return userInput.split(",");
    }

    public static List<Integer> convertGathering(String[] userInputs) {
        List<Integer> gatheringOfNumbers = new ArrayList<>();
        for (int i = 0; i < LOTTERY_NUMBERS; i++) {
            String numberTemp = userInputs[i];
            int winningNumber = Integer.parseInt(numberTemp);
            gatheringOfNumbers.add(winningNumber);
        }
        return gatheringOfNumbers;
    }
}
