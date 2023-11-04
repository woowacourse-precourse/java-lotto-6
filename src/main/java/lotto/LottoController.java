package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoController {
    private int money;

    public void inputPurchaseMoney() {
        do {
            money = Integer.parseInt(Console.readLine());
        } while (validMoneyInput(money));
    }

    private boolean validMoneyInput(final int money) {
        try {
            if (money % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위입니다. 다시 입력하세요.");
            }
            return false;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return true;
        }
    }
}
