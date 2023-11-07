package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String WINNING_NUMBERS_REGEX = "^([0-9]{1,2},){5}[0-9]{1,2}$";

    public static String inputPurchaseMoney() {
        printPurchaseMoneyMessage();
        return Console.readLine();
    }

    private static void printPurchaseMoneyMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static String inputWinningNumbers() {
        printWinningNumbersMessage();
        String input = Console.readLine();
        validateWinningNumber(input);
        return input;
    }

    private static void printWinningNumbersMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    private static void validateWinningNumber(String input) {
        if (!input.matches(WINNING_NUMBERS_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 입력 값이 올바르지 않습니다.");
        }
    }

    public static String inputBonusNumber() {
        printBonusNumberMessage();
        return Console.readLine();
    }

    private static void printBonusNumberMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

}
