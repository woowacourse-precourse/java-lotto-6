package lotto.domain;

public enum LottoPlaceMoney {
    FIRST_PLACE_MONEY(2000000000),
    SECOND_PLACE_MONEY(30000000),
    THIRD_PLACE_MONEY(1500000),
    FOURTH_PLACE_MONEY(50000),
    FIFTH_PLACE_MONEY(5000);

    int lottoPlaceMoney;

    LottoPlaceMoney(int lottoPlaceMoney) {
        this.lottoPlaceMoney = lottoPlaceMoney;
    }
}
