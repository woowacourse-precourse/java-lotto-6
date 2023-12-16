package lotto.view;

import static lotto.view.ErrorMessage.ERROR;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Money;

public class InputView {

    public static Money inputMoney() {
        while (true) {
            try {
                String input = Console.readLine();
                int price = validateMoneyInput(input);
                return new Money(price);
            } catch (IllegalArgumentException e) {
                OutputView.print(e.getMessage());
            }
        }
    }

    private static int validateMoneyInput(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR);
        }
    }

    public static Lotto inputWinningNumbers() {
        while (true) {
            try {
                String[] input = Console.readLine().split(",");
                List<Integer> numbers = validateWinningNumbers(input);
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                OutputView.print(e.getMessage());
            }
        }
    }

    private static List<Integer> validateWinningNumbers(String[] input) {
        try {
            return Arrays.stream(input).map(number -> Integer.parseInt(number.trim())).toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR);
        }
    }

    public static int inputBonusNumber() {
        while (true) {
            try {
                String input = Console.readLine();
                return validateBonusNumberInput(input);
            } catch (IllegalArgumentException e) {
                OutputView.print(e.getMessage());
            }
        }
    }

    private static int validateBonusNumberInput(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR);
        }
    }
}
