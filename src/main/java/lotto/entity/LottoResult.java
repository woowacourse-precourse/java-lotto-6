package lotto.entity;

import lotto.entity.mapper.FiledMapper;
import lotto.property.MethodProperty;

public enum LottoResult {
    NO_PRIZE(0, "", ""),
    THREE_MATCH(3, "3개 일치", "(5,000원)"),
    FOUR_MATCH(4, "4개 일치", "(50,000원)"),
    FIVE_MATCH(5, "5개 일치", "(1,500,000원)"),
    FIVE_MATCH_WITH_BONUS(999, "5개 일치, 보너스 볼 일치", "(30,000,000원)"),
    SIX_MATCH(6, "6개 일치", "(2,000,000,000원)");

    private Integer count;
    private String hitCount;
    private String prize;

    LottoResult(Integer count, String hitCount, String prize) {
        this.count = count;
        this.hitCount = hitCount;
        this.prize = prize;
    }

    public Integer getCount() {
        return (Integer) FiledMapper.getFieldValue(this, MethodProperty.ENUM_COUNT);
    }
}
