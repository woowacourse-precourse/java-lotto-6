package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Buyer {
    public int getLottoPurchaseAmount() {
        String money = Console.readLine();
        return Integer.parseInt(money);
    }
}
