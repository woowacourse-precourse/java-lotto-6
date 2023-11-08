package lotto.service.constant;

public enum LottoServiceMessage {
    MATCH_COUNT_3(3),
    MATCH_COUNT_4(4),
    MATCH_COUNT_5(5),
    MATCH_COUNT_5_AND_BONUS(5),
    MATCH_COUNT_6(6),
    LOTTO_NUMBER_MIN(1),
    LOTTO_NUMBER_MAX(45),
    LOTTO_NUMBER_SIZE(6),
    START_INDEX(0),
    DIVIDE_BY(1000);
    private final Integer value;
    LottoServiceMessage(Integer value) {
        this.value = value;
    }
    public Integer getValue() {
        return this.value;
    }
}
