package lotto.domain;

import lotto.constant.Phrases;

public class PurchaseCounter implements Counter {
    private final int LOTTO_AMOUNT = 1000;
    @Override
    public int counter(int target) {
        if(target % LOTTO_AMOUNT == 0){
            return target / LOTTO_AMOUNT;
        }
        throw new IllegalArgumentException(Phrases.cannotDivisionAmountExceptionPhrase);
    }
}
