package lotto.v3.view;

import camp.nextstep.edu.missionutils.Console;

public class LottoView {
    public int requestPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return parseAmount(Console.readLine());
    }

}
