package lotto.domain;

import lotto.constant.Phrases;
import lotto.view.OutputAboutException;

import java.util.List;

public class PurchaseCounter implements Counter {
    private final int LOTTO_AMOUNT = 1000;

    @Override
    public int counter(int target) {
        if (target % LOTTO_AMOUNT == 0) {
            return target / LOTTO_AMOUNT;
        }
        throw new IllegalArgumentException(Phrases.cannotDivisionAmountExceptionPhrase);
    }

    @Override
    public int counter(List<Integer> numbers, List<Integer> winnerNumbers) {
        return 0;
    }
}
