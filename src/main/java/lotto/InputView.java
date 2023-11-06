package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    String inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        return Console.readLine();
    }

    String inputWinningNumbers() {
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        return Console.readLine();
    }

    String inputBonusNumber() {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
