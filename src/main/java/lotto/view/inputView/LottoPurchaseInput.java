package lotto.view.inputView;
import camp.nextstep.edu.missionutils.Console;

import static lotto.constant.ViewMessages.LOTTO_NUMBER_REQUEST;

public class LottoPurchaseInput {
    public String requestPurchaseAmount() {
        System.out.println(LOTTO_NUMBER_REQUEST);
        return Console.readLine();
    }
}