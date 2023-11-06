package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import common.Convert;

public class InputView {
    private static final int LOTTO_COST = 1000;
    public static Integer getBuyAmount() {
        String inputAmountSrc = Console.readLine();
        int inputAmount = Convert.StringToInteger(inputAmountSrc);
        validateAmount(inputAmount);
        return inputAmount / LOTTO_COST;
    }

    public static void validateAmount(int amount){
        if (amount % LOTTO_COST != 0) {
            throw new IllegalArgumentException();
        }
    }
}
