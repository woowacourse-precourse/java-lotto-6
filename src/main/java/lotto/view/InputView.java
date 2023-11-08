package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String MESSAGE_REQUEST_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_REQUEST_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public String requestPurchaseAmount() {
        System.out.println(MESSAGE_REQUEST_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    public String requestWinningNumbers() {
        System.out.println(MESSAGE_REQUEST_WINNING_NUMBERS);
        return Console.readLine();
    }

    public String requestBonusNumbers() {
        System.out.println(MESSAGE_REQUEST_BONUS_NUMBER);
        return Console.readLine();
    }
}
