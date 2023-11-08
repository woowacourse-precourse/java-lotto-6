package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.exception.Validator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String PURCHASE_AMOUNT_MESSAGE = "구입 금액을 입력해 주세요.";
    public static final String WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static int inputPurchaseAmount() {
        while (true) {
            try {
                System.out.println(PURCHASE_AMOUNT_MESSAGE);
                int amount = Integer.parseInt(Console.readLine());
                Validator.isValidAmount(amount);
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> inputWinningNumbers() {
        while (true) {
            try {
                System.out.println(WINNING_NUMBERS_MESSAGE);
                List<Integer> numbers = parseInputNumbers(Console.readLine());
                Validator.isValidWinningNumbers(numbers);
                return numbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int inputBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                System.out.println(BONUS_NUMBER_MESSAGE);
                int number = Integer.parseInt(Console.readLine());
                Validator.isValidBonusNumber(number, winningNumbers);
                return number;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> parseInputNumbers(String input) {
        return Stream.of(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
