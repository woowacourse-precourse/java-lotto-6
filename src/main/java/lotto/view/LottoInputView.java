package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class LottoInputView {

    public LottoInputView() {
    }

    public Long getLottoPurchaseAmountInput() {
        String purchaseAmount = Console.readLine();

        // TODO : 예외 처리 [ERROR]

        return Long.parseLong(purchaseAmount);
    }
}
