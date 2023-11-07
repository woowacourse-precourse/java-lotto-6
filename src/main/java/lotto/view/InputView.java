package lotto.view;

import camp.nextstep.edu.missionutils.Console;


import static lotto.exception.InputValidator.*;
import static lotto.exception.MoneyValidator.validatePurchaseAmount;

public class InputView {

    public static final String USER_MONEY_INPUT_MSG = "구입금액을 입력해 주세요.";

    public static long getLottoPayment() {
        printMessage(USER_MONEY_INPUT_MSG);

        String money = Console.readLine();
        validateLottoPurchaseAmount(money);
        validatePurchaseAmount(Long.parseLong(money));
        return Long.parseLong(money);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
