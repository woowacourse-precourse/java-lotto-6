package lotto.readUserInput;

import camp.nextstep.edu.missionutils.Console;

public class PurchaseAmount {
    public static int lottoQuantity;

    public void readMoney() {
        String money = Console.readLine();
        moneyToLotto(money);
    }

    public void moneyToLotto(String money) {
        lottoQuantity = Integer.parseInt(money);
    }

}
