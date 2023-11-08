package lotto.view.inputView;
import camp.nextstep.edu.missionutils.Console;

import static lotto.constant.ViewMessages.Lotto_Number_Request;

public class LottoPurchaseInput {
    public String requestPurchaseAmount() {
        System.out.println(Lotto_Number_Request);
        return Console.readLine();
    }
}