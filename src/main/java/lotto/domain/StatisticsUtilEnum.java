package lotto.domain;

public enum StatisticsUtilEnum {
    LOTTO_PRICE(1000),
    CHECK_2ND(5),

    MATCH_SIZE(8),

    CHANGE_LEFT(6),

    CHANGE_RIGHT(7),

    SECOND_PLACE_TO_LAST_PLACE(2);


    private final Integer status;

    StatisticsUtilEnum(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}
