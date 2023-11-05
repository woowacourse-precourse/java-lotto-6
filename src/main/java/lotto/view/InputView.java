package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Parser;

public class InputView {
    static final String PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";

    public static String inputPurchaseAmount() {
        System.out.println(PURCHASE_MESSAGE);
        return Console.readLine();
    }
}
