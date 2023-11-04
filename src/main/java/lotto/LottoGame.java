package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoGame {
    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";

    public void start() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        int purchaseAmount = Integer.parseInt(Console.readLine());
    }
}
