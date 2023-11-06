package lotto;

public enum LottoResult {
    FIFTH_PLACE_COUNT("3개 일치 (5,000원) - "),
    FOURTH_PLACE_COUNT("4개 일치 (50,000원) - "),
    THIRD_PLACE_COUNT("5개 일치 (1,500,000원) - "),
    SECOND_PLACE_COUNT("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST_PLACE_COUNT("6개 일치 (2,000,000,000원) - "),
    ;

    private final String desc;

    LottoResult(java.lang.String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
