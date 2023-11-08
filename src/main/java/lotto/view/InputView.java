package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String WINNING_NUMBERS_REGEX = "^([0-9]{1,2},){5}[0-9]{1,2}$";
    private static final int WINNING_NUMBERS_COUNT = 6;
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
        printWinningNumbersMessage();
        String input = Console.readLine();
        validateWinningNumber(input);
        return translateWinningNumbers(input);
    }

    private static void printWinningNumbersMessage() {
        System.out.println(System.lineSeparator() + "당첨 번호를 입력해 주세요.");
    }

    private static void validateWinningNumber(String input) {
        validateWinningNumbersForm(input);
        validateDuplicateWinningNumbers(input);
    }

    private static void validateWinningNumbersForm(String input) {
        if (!input.matches(WINNING_NUMBERS_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 입력 값이 올바르지 않습니다.");
        }
    }

    private static void validateDuplicateWinningNumbers(String input) {
        long count = Arrays.stream(input.split(REGEX))
                .distinct()
                .count();
        if (count != WINNING_NUMBERS_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 숫자를 중복되지 않게 입력해야 합니다.");
        }
    }

    private static List<Integer> translateWinningNumbers(String input) {
        return Arrays.stream(input.split(REGEX))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int inputBonusNumber() {
        printBonusNumberMessage();
        String input = Console.readLine();
        validateBonusNumber(input);
        return Integer.parseInt(input);
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
