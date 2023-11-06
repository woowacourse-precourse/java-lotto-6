package lotto;

import java.util.Arrays;
import java.util.List;
import lotto.constant.ExceptionMessage;

public class Converter {

    public static long pay(String paymentPrice) throws IllegalArgumentException {
        try {
            return Long.parseLong(paymentPrice);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.REQUIRE_INTEGER);
        }
    }

    public static List<Integer> winningNumbers(String numbersInput) throws IllegalArgumentException {
        try {
            String[] numbers = numbersInput.split(",");
            List<Integer> winningNumbers = Arrays.stream(numbers)
                    .map(Integer::parseInt)
                    .toList();
            return winningNumbers;
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionMessage.REQUIRE_FIVE_COMMAS);
        }
    }

    public static Integer bonusNumbers(String numberInput) {
        try {
            return Integer.parseInt(numberInput);
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionMessage.REQUIRE_INTEGER);
        }
    }
}