package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PURCHASE_MONEY_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_REQUEST_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_REQUEST_MESSAGE = "보너스 번호를 입력해 주세요.";

    public String inputPurchaseMoney() {
        System.out.println(PURCHASE_MONEY_REQUEST_MESSAGE);
        return Console.readLine();
    }

    public String inputWinningNumber() {
        System.out.println();
        System.out.println(WINNING_NUMBER_REQUEST_MESSAGE);
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println();
        System.out.println(BONUS_NUMBER_REQUEST_MESSAGE);
        return Console.readLine();
    }
}
