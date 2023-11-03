package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static void printPurchasePrompt() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static String getPurchaseAmountView() {
        String input = Console.readLine();
        System.out.println();

        return input;
    }
}
