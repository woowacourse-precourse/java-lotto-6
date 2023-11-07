package lotto.domain;

import lotto.view.ValidationView;

public class LottoCalculate {
    private static final int LOTTO_PRICE = 1000;

    public static int calcAmount(int money){
        return money/LOTTO_PRICE;
    }

}
