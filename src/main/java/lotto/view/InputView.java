package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BuyAmount;

public class InputView {

    private InputView() {
    }

    public static BuyAmount getBuyAmountFromInput() {
        String buyAmount = read();
        return new BuyAmount(Long.parseLong(buyAmount));
    }

    private static String read() {
        return Console.readLine().trim();
    }
}
