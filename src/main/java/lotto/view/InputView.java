package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static String getPurchaseAmount() {
        printPurchaseMessage();
        return Console.readLine();
    }

    private static void printPurchaseMessage() {
        System.out.println(PURCHASE_MESSAGE);
    }

    public static String getWinningNumbers() {
        printInputWinningNumbers();
        return Console.readLine();
    }

    private static void printInputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
    }

    public static String getBonusNumber() {
        printInputBonusNumber();
        return Console.readLine();
    }

    private static void printInputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    }

}
