package lotto.domain;

import java.util.Arrays;

public enum LottoPrice {
    NONE(0, false, 0, "", 0),
    FIFTH(3, false, 5000, "(5,000원)", 5),
    FOURTH(4, false, 50000, "(50,000원)", 4),
    THIRD(5, false, 1500000, "(1,500,000원)", 3),
    SECOND(5, true, 30000000, "(30,000,000원)", 2),
    FIRST(6, false, 2000000000, "(2,000,000,000원)", 1);

    private final int matchesNumber;

    private final boolean bonusNumber;

    private final int priceMoney;

    private final String priceMoneyMessage;
    private final int prize;

    LottoPrice(int matchesNum, boolean bonusNumber, int priceMoney, String priceMoneyMessage, int prize) {
        this.matchesNumber = matchesNum;
        this.bonusNumber = bonusNumber;
        this.priceMoney = priceMoney;
        this.priceMoneyMessage = priceMoneyMessage;
        this.prize = prize;
    }

    public static LottoPrice getLottoPriceByMatchesNumber(int matchesNumber, boolean bonusNumber) {
        return Arrays.stream(LottoPrice.values())
                .filter(lottoPrice -> lottoPrice.matchesNumber == matchesNumber)
                .filter(lottoPrice -> lottoPrice.bonusNumber == bonusNumber)
                .findFirst()
                .orElse(NONE);

    }

    public static LottoPrice getLottoPriceByPrize(int prize){
        return Arrays.stream(LottoPrice.values())
                .filter(lottoPrice -> lottoPrice.getPrize() == prize)
                .findFirst()
                .get();
    }

    public int getMatchesNumber() {
        return matchesNumber;
    }

    public int getPriceMoney() {
        return priceMoney;
    }

    public int getPrize() {
        return prize;
    }

    public String getPriceMoneyMessage() {
        return priceMoneyMessage;
    }
}
