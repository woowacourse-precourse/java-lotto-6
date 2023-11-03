package lotto.controller;

import camp.nextstep.edu.missionutils.Console;

public class InputController {
    private static final String ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String ENTER_SIX_DIGITS_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public String purchaseAmount() {
        System.out.println(ENTER_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    public String numbers() {
        System.out.println(ENTER_SIX_DIGITS_NUMBERS);
        return Console.readLine();
    }

    public String bonusNumber() {
        System.out.println(ENTER_BONUS_NUMBER);
        return Console.readLine();
    }
}
