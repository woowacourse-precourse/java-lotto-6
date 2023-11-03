package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class LottoInputView {

    public LottoInputView() {
    }

    public Long getLottoPurchaseAmountInput() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();

        // TODO : 예외 처리 [ERROR]

        return Long.parseLong(purchaseAmount);
    }
}
