package lotto.view;

import static lotto.validator.Validator.validateNumeric;
import static lotto.validator.Validator.validateWinningNumbersInput;
import static lotto.view.ViewConstant.ASK_PAYMENT_MESSAGE;
import static lotto.view.ViewConstant.ASK_WINNING_NUMBER_MESSAGE;
import static lotto.view.ViewConstant.WINNING_NUMBER_DELIMITER;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public static int readPayment() {
        System.out.println(ASK_PAYMENT_MESSAGE);

        String payment = Console.readLine();
        validateNumeric(payment);
        return Integer.parseInt(payment);
    }

    public static List<Integer> readWinningNumbers() {
        System.out.println(ASK_WINNING_NUMBER_MESSAGE);

        String numbers = Console.readLine();
        validateWinningNumbersInput(numbers);
        return toIntegerList(numbers);
    }

    private static List<Integer> toIntegerList(String numbers) {
        return Arrays.stream(numbers.split(WINNING_NUMBER_DELIMITER.value()))
                .map(Integer::parseInt)
                .toList();
    }

}
