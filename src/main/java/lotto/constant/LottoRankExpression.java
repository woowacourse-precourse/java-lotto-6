package lotto.constant;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public enum LottoRankExpression {

    THREE(LottoRank.THREE, "3개 일치 (5,000원) - %d개", 1),
    FOUR(LottoRank.FOUR, "4개 일치 (50,000원) - %d개", 2),
    FIVE_WITHOUT_BONUS(LottoRank.FIVE_WITHOUT_BONUS, "5개 일치 (1,500,000원) - %d개", 3),
    FIVE_WITH_BONUS(LottoRank.FIVE_WITH_BONUS, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", 4),
    SIX(LottoRank.SIX, "6개 일치 (2,000,000,000원) - %d개", 5);

    private final LottoRank lottoRank;
    private final String expression;
    private final int order;

    LottoRankExpression(LottoRank lottoRank, String expression, int order) {
        this.lottoRank = lottoRank;
        this.expression = expression;
        this.order = order;
    }

    public static List<LottoRankExpression> getOrderedExpressions() {
        return Stream.of(values()).sorted(Comparator.comparingInt(e -> e.order)).toList();
    }

    public LottoRank getLottoRank() {
        return lottoRank;
    }

    public String getExpressionByCount(int count) {
        return String.format(expression, count);
    }
}
