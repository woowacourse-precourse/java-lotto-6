package lotto.domain;

public enum LottoPlaceCount {
    FIRST_PLACE(6),
    SECOND_PLACE(5),
    THIRD_PLACE(5),
    FOURTH_PLACE(4),
    FIFTH_PLACE(3);

    int lottoPlaceCount;

    LottoPlaceCount(int lottoPlaceCount) {
        this.lottoPlaceCount = lottoPlaceCount;
    }
}
