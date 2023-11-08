package lotto.entity;

import lotto.entity.mapper.FiledMapper;
import lotto.property.MethodProperty;

public enum LottoResult {
    NO_PRIZE(0, 0L, "", ""),
    THREE_MATCH(3, 5000L, "3개 일치", "(5,000원)"),
    FOUR_MATCH(4, 50000L, "4개 일치", "(50,000원)"),
    FIVE_MATCH(5, 1500000L, "5개 일치", "(1,500,000원)"),
    FIVE_MATCH_WITH_BONUS(999, 30000000L, "5개 일치, 보너스 볼 일치", "(30,000,000원)"),
    SIX_MATCH(6, 2000000000L, "6개 일치", "(2,000,000,000원)");

    private Integer count;
    public Long prize;
    public String hitCount;
    public String hitPrize;

    LottoResult(Integer count, Long prize, String hitCount, String hitPrize) {
        this.count = count;
        this.prize = prize;
        this.hitCount = hitCount;
        this.hitPrize = hitPrize;
    }

    public Integer getCount() {
        return (Integer) FiledMapper.getFieldValue(this, MethodProperty.ENUM_COUNT);
    }
}
