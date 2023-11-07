package lotto.utils.io;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
    private static final String INPUT_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private InputManager() {
    }

    public String receivePurchasePrice() {
        System.out.println(INPUT_PURCHASE_PRICE_MESSAGE);
        return Console.readLine();
    }

    public String receiveWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        return Console.readLine();
    }

    public String receiveBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
