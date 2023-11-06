package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private final String WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public String inputPurchaseAmount() {
        System.out.println(PURCHASE_MESSAGE);
        return Console.readLine();
    }

    public String drawWinningString() {
        System.out.println(WINNING_NUMBERS_MESSAGE);
        return Console.readLine();
    }

    public String drawBonusString() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
