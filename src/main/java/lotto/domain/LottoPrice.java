package lotto.domain;

import java.util.Arrays;

public enum LottoPrice {
    NONE(0, false, 0),
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);

    private final int matchesNumber;

    private final boolean bonusNumber;

    private final int priceMoney;

    LottoPrice(int matchesNum, boolean bonusNumber, int priceMoney) {
        this.matchesNumber = matchesNum;
        this.bonusNumber = bonusNumber;
        this.priceMoney = priceMoney;
    }

    public static LottoPrice getLottoPriceByMatchesNumber(int matchesNumber, boolean bonusNumber) {
        return Arrays.stream(LottoPrice.values())
                .filter(lottoPrice -> lottoPrice.matchesNumber == matchesNumber)
                .filter(lottoPrice -> lottoPrice.bonusNumber == bonusNumber)
                .findFirst()
                .orElse(NONE);

    }

    public int getMatchesNumber() {
        return matchesNumber;
    }

    public int getPriceMoney() {
        return priceMoney;
    }
}
