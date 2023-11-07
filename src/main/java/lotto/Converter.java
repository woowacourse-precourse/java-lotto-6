package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.ExceptionMessage;
import lotto.view.OutputHandler;

public class Converter {

    public static long pay(String paymentPrice) throws IllegalArgumentException {
        if (paymentPrice.isEmpty()) {
            OutputHandler.requireNonemptyInput();
            throw new IllegalArgumentException(ExceptionMessage.REQUIRE_NONEMPTY_INPUT.getMessage());
        }
        try {
            return Long.parseLong(paymentPrice);
        } catch (NullPointerException e) {
            OutputHandler.requireNonemptyInput();
            throw new IllegalArgumentException(ExceptionMessage.REQUIRE_NONEMPTY_INPUT.getMessage());
        } catch (NumberFormatException e) {
            OutputHandler.requireInteger();
            throw new IllegalArgumentException(ExceptionMessage.REQUIRE_LONG.getMessage());
        }
    }

    public static List<Integer> winningNumbers(String numbersInput) throws IllegalArgumentException {
        if (numbersInput.isEmpty()) {
            OutputHandler.requireNonemptyInput();
            throw new IllegalArgumentException(ExceptionMessage.REQUIRE_NONEMPTY_INPUT.getMessage());
        }
        try {
            String[] numbers = numbersInput.split(",");
            List<Integer> winningNumbers = Arrays.stream(numbers)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return winningNumbers;
        } catch (NullPointerException e) {
            OutputHandler.requireNonemptyInput();
            throw new IllegalArgumentException(ExceptionMessage.REQUIRE_NONEMPTY_INPUT.getMessage());
        } catch (NumberFormatException e) {
            OutputHandler.requireInteger();
            throw new IllegalArgumentException(ExceptionMessage.REQUIRE_INTEGER.getMessage());
        }
    }

    public static Integer bonusNumbers(String numberInput) throws IllegalArgumentException {
        if (numberInput.isEmpty()) {
            OutputHandler.requireNonemptyInput();
            throw new IllegalArgumentException(ExceptionMessage.REQUIRE_NONEMPTY_INPUT.getMessage());
        }
        try {
            return Integer.parseInt(numberInput);
        } catch (NullPointerException e) {
            OutputHandler.requireNonemptyInput();
            throw new IllegalArgumentException(ExceptionMessage.REQUIRE_NONEMPTY_INPUT.getMessage());
        } catch (NumberFormatException e) {
            OutputHandler.requireInteger();
            throw new IllegalArgumentException(ExceptionMessage.REQUIRE_INTEGER.getMessage());
        }
    }
}