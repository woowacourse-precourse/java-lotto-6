package lotto.domain;

import lotto.exception.LottoPurchaseAmountException;

public class LottoPurchaseAmount {
    private static final int lottoPrice = 1000;
    private final String input;

    public LottoPurchaseAmount(String input) {
        validate(input);
        this.input = input;

    }

    private void validate(String input) {
        LottoPurchaseAmountException lottoPurchaseAmountException = new LottoPurchaseAmountException(input);
    }

    public int getLottoCount(){
        int count = Integer.parseInt(input);
        int lottoCount = count / lottoPrice;
        return lottoCount;
    }
}
