package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import common.Convert;
import lotto.domain.LottoBuyAmount;

public class InputView {
    private static final int LOTTO_COST = 1000;
    public static Integer getBuyAmount() {
        String inputAmountSrc = Console.readLine();
        int inputAmount = Convert.StringToInteger(inputAmountSrc);
        return LottoBuyAmount.getAmount(inputAmount);
    }
}
