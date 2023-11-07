package lotto;

import static lotto.Constants.ErrorConstant.*;
import static lotto.Constants.LottoConstant.*;


public class AmountToBuyLotto {

    private final Integer amount;

    public static final int ZERO = 0;

    private AmountToBuyLotto(String input) {
        input = input.trim();

        this.amount = Integer.parseInt(input);

    }

    public static AmountToBuyLotto newInstance(String amount) {
        return new AmountToBuyLotto(amount);
    }

    public Integer getAmount() {
        return amount;
    }



}
