package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String LOTTO_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public static String inputLottoPurchaseAmount() {
        System.out.println(LOTTO_PURCHASE_AMOUNT_MESSAGE);
        return Console.readLine();
    }
}
