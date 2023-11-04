package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_BUY_AMOUNT_MESSAGE = "구입 금액을 입력해 주세요.";

    public int inputBuyAmount() {
        System.out.println(INPUT_BUY_AMOUNT_MESSAGE);
        return InputValidator.validateBuyAmount(Console.readLine());
    }
}