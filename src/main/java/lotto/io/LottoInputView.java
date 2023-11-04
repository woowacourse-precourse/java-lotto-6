package lotto.io;

import camp.nextstep.edu.missionutils.Console;

public class LottoInputView {

    public String readPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        return Console.readLine();
    }
}
