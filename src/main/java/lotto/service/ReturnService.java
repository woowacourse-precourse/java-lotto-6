package lotto.service;

import static lotto.constants.LottoConstants.PERCENTAGE_FORMAT;
import static lotto.constants.LottoConstants.PERCENTAGE_MULTIPLIER;

public class ReturnService {
    public String evaluateLottoReturn(int payment, int winningAmount) {
        float returns = ((float) winningAmount / payment) * PERCENTAGE_MULTIPLIER;
        return String.format(PERCENTAGE_FORMAT, returns);
    }
}
