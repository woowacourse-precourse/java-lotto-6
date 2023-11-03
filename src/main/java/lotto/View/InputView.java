package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String INPUT_LOTTO_PUCAHSE_AMOUNT = "구입금액을 입력해주세요.";

    public static String inputLottoPurchaseAmount() {
        System.out.println(INPUT_LOTTO_PUCAHSE_AMOUNT);
        return Console.readLine();
    }
}
