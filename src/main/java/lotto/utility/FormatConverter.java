package lotto.utility;

import lotto.domain.Winning;

import java.util.ArrayList;
import java.util.List;

public class FormatConverter {
    public static List<Integer> toIntegerListFromStringWithComma(String input) {
        List<Integer> numbers = new ArrayList<>();

        for (String number : input.split(",")) {
            numbers.add(TypeConverter.convertStringToInt(number));
        }

        return numbers;
    }

    public static Winning toWinningFromIntValue(int input) {
        if (input == 1 || input == 2) {
            return Winning.NO_WINNING;
        }

        if (input == 3) {
            return Winning.THREE;
        }

        if (input == 4) {
            return Winning.FOUR;
        }

        if (input == 5) {
            return Winning.FIVE;
        }

        if (input == 6) {
            return Winning.SIX;
        }

        return Winning.FIVE_BONUS;
    }
}
