package lotto.domain.constant;

import lotto.domain.money.Money;

public class LottoConstant {

    public static final int LOTTO_MINIMUM_NUMBER = 1;
    public static final int LOTTO_MAXIMUM_NUMBER = 45;
    public static final int LOTTO_NUMBERS_SIZE = 6;
    public static final Money LOTTO_PRICE = Money.valueOf(1000);

    private LottoConstant() {
    }
}
