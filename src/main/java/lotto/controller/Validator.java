package lotto.controller;

import java.util.Collections;
import java.util.List;

public class Validator {
    public static boolean isBuyAmountValid(String playerInput) {
        try {
            int buyAmount = Integer.parseInt(playerInput);
            if (buyAmount <= 0) {
                Exception.isNotPlusInt();
            }

            if (buyAmount % 1000 != 0) {
                Exception.isNotThousandUnit();
            }

        } catch (NumberFormatException e) {
            Exception.isNotNumber();
        }

        return true;
    }

    public static boolean isDisticnt(List<Integer> numbers) {
        return (numbers.size() == numbers.stream().distinct().count());
    }

    public static boolean isSizeSix(List<Integer> numbers) {
        return numbers.size() == 6;
    }
}
