package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public int readTotalPurchasedAmount() {
        String input = Console.readLine();
        int amount = Integer.parseInt(input);
        return amount;
    }
}
