package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int insertBuyPrice() {
        String buyPrice = Console.readLine();
        return convertToInt(buyPrice);
    }

    public static int convertToInt(String buyPrice) {
        return Integer.parseInt(buyPrice);
    }
}