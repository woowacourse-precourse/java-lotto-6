package lotto;

import static lotto.Constants.ErrorConstant.*;
import static lotto.Constants.LottoConstant.*;


public class AmountToBuyLotto {

    private final Integer amount;

    public static final int ZERO = 0;

    private AmountToBuyLotto(String input) {
        isBlank(input);
        input = input.trim();

        this.amount = Integer.parseInt(input);

    }

    public static AmountToBuyLotto newInstance(String amount) {
        return new AmountToBuyLotto(amount);
    }

    public Integer getAmount() {
        return amount;
    }

    public int dividedByLottoPrice(int lottoPrice) {
        return amount / lottoPrice;
    }


    private void isBlank(String input) {
        if (input != null && !input.isBlank()) {
            return;
        }
        throw new IllegalArgumentException(ERROR_INPUT_VALID_VAULE);
    }



}
