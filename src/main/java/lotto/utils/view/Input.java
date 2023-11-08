package lotto.utils.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.constant.BuyPrice;

public class Input {
    public BuyPrice setupBuyPrice() {
        return new BuyPrice(Console.readLine());
    }
}
