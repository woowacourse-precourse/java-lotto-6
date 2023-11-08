package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String ERROR_INPUT_ERROR_MESSAGE = ERROR_PREFIX + "올바른 형식으로 입력해 주세요.";

    public static int inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        String input = Console.readLine();
        validateMoneyString(input);
        int money = Integer.parseInt(input);
        validateMoney(money);
        return money;
    }

    public static List<Integer> inputLottoWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        String input = Console.readLine();
        List<String> inputs = validateWinningNumberString(input);
        List<Integer> winningNumbers = validateWinningNumbers(inputs);
        return winningNumbers;
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String input = Console.readLine();
        validateNumber(input);
        int bonusNumber = Integer.parseInt(input);
        validateNumberRange(bonusNumber);
        return bonusNumber;
    }


    private static List<Integer> validateWinningNumbers(List<String> inputs) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String input : inputs) {
            validateNumber(input);
            int winningNumber = Integer.parseInt(input);
            validateNumberRange(winningNumber);
            winningNumbers.add(winningNumber);
        }
        return winningNumbers;
    }

    private static void validateNumberRange(int winningNumber) {
        if (winningNumber < 1 || winningNumber > 45) {
            throw new IllegalArgumentException(ERROR_INPUT_ERROR_MESSAGE);
        }
    }

    private static void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INPUT_ERROR_MESSAGE);
        }
    }

    private static List<String> validateWinningNumberString(String input) {
        List<String> inputs = List.of(input.split(","));
        if (inputs.size() != 6) {
            throw new IllegalArgumentException(ERROR_INPUT_ERROR_MESSAGE);
        }
        return inputs;
    }

    private static void validateMoney(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException(ERROR_INPUT_ERROR_MESSAGE);
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_INPUT_ERROR_MESSAGE);
        }
    }

    private static void validateMoneyString(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INPUT_ERROR_MESSAGE);
        }
    }
}
