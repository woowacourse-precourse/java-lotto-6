package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String WINNING_NUMBERS_REGEX = "^([0-9]{1,2},){5}[0-9]{1,2}$";
    private static final String REGEX = ",";

    public static int inputPurchaseMoney() {
        printPurchaseMoneyMessage();
        String input = Console.readLine();
        validatePurchaseMoney(input);
        return Integer.parseInt(input);
    }

    private static void printPurchaseMoneyMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    private static void validatePurchaseMoney(String money) {
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자만 입력하실 수 있습니다.");
        }
    }

    public static List<Integer> inputWinningNumbers() {
        try {
            printWinningNumbersMessage();
            String input = Console.readLine();
            validateWinningNumber(input);
            return translateWinningNumbers(input);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return inputWinningNumbers();
        }
    }

    private static void printWinningNumbersMessage() {
        System.out.println(System.lineSeparator() + "당첨 번호를 입력해 주세요.");
    }

    private static void validateWinningNumber(String input) {
        if (!input.matches(WINNING_NUMBERS_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 입력 값이 올바르지 않습니다.");
        }
    }

    private static List<Integer> translateWinningNumbers(String input) {
        return Arrays.stream(input.split(REGEX))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int inputBonusNumber() {
        try {
            printBonusNumberMessage();
            String input = Console.readLine();
            validateBonusNumber(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return inputBonusNumber();
        }
    }

    private static void printBonusNumberMessage() {
        System.out.println(System.lineSeparator() + "보너스 번호를 입력해 주세요.");
    }

    private static void validateBonusNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 입력 가능합니다.");
        }
    }
}
