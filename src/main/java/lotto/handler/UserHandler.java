package lotto.handler;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.ResultView;

import java.util.List;

public class UserHandler {
    public static int getAmountFromUser() {
        System.out.println("구입금액을 입력해 주세요.");
        String userInput = Console.readLine();
        ResultView.printNewLine();

        return validateUserInput(userInput);
    }

    public static int validateUserInput(String userInput) {
        if (userInput == null || userInput.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 금액을 입력해주세요.");
        }

        checkStartWithZero(userInput);
        checkNumericString(userInput);

        int amount = Integer.parseInt(userInput);

        checkUnitAmount(amount);

        return amount;
    }

    public static int getLottoCountFromUser(int amount) {
        return amount/1000;
    }

    private static void checkStartWithZero(String userInput) {
        if (userInput.startsWith("0")) {
            throw new IllegalArgumentException("[ERROR] 0으로 시작하는 숫자를 입력하지 마세요.");
        }
    }

    private static void checkNumericString(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    private static void checkUnitAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
        }

    }

    public static String getWinningNumberFromUser() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumberInput = Console.readLine();
        return validateWinningNumberInput(winningNumberInput);
    }

    private static String validateWinningNumberInput(String winningNumberInput) {
        return null;
    }




}
