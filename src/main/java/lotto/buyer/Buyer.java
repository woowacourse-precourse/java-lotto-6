package lotto.buyer;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Validator;

public class Buyer {
    public int buyLotto() {
        String buyAmount = Console.readLine();
        Console.close();
        if (!Validator.isNumber(buyAmount)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(buyAmount);
    }
}
