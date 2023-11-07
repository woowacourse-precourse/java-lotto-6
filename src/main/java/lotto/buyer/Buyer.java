package lotto.buyer;

import camp.nextstep.edu.missionutils.Console;

public class Buyer {
    public int buyLotto() {
        String buyAmount = Console.readLine();
        Console.close();
        return Integer.parseInt(buyAmount);
    }
}
