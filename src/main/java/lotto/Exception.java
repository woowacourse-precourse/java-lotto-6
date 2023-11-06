package lotto;

import static lotto.Enum.ErrorMessage.DUPLICATED_ERROR;
import static lotto.Enum.ErrorMessage.LENGHT_ERROR;
import static lotto.Enum.ErrorMessage.NOT_NUMBER_ERROR;
import static lotto.Enum.ErrorMessage.UNIT_ERROR;
import static lotto.Enum.Number.UNIT;

import java.util.ArrayList;
import java.util.List;

public class Exception {
    public static void checkIfNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR.getMessage());
        }
    }

    public static void checkUnit(int money) {
        int thousand = UNIT.getNumber();
        if (money % thousand != 0) {
            throw new IllegalArgumentException(UNIT_ERROR.getMessage());
        }
    }

    private static void checkIfDuplicated(List<Integer> numbers, int num) {
        if (numbers.contains(num)) {
            throw new IllegalArgumentException(DUPLICATED_ERROR.getMessage());
        }
    }

    private static void checkIfStringStartAndEndWithNumber(String str){
        checkIfNumber(String.valueOf(str.charAt(str.length() - 1)));
        checkIfNumber(String.valueOf(str.charAt(0)));
    }

    public static List<Integer> checkWinningNumber(String input) {
        checkIfStringStartAndEndWithNumber(input);
        String[] inputSplit = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String str : inputSplit) {
            checkIfNumber(str);
            int number = Integer.parseInt(str);
            checkIfDuplicated(numbers, number);
            numbers.add(number);
        }
        if (numbers.size() != 6){
            throw new IllegalArgumentException(LENGHT_ERROR.getMessage());
        }
        return numbers;
    }
}
