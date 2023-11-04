package lotto.constant;

public enum LottoRankExpression {

    THREE(LottoRank.THREE, "3개 일치 (5,000원) - %d개%n"),
    FOUR(LottoRank.FOUR, "4개 일치 (50,000원) - %d개%n"),
    FIVE_WITHOUT_BONUS(LottoRank.FIVE_WITHOUT_BONUS, "5개 일치 (1,500,000원) - %d개%n"),
    FIVE_WITH_BONUS(LottoRank.FIVE_WITH_BONUS, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n"),
    SIX(LottoRank.SIX, "6개 일치 (2,000,000,000원) - %d개%n");

    private final LottoRank lottoRank;
    private final String expression;

    LottoRankExpression(LottoRank lottoRank, String expression) {
        this.lottoRank = lottoRank;
        this.expression = expression;
    }

    public LottoRank getLottoRank() {
        return lottoRank;
    }

    public String getExpressionByCount(int count) {
        return String.format(expression, count);
    }
}
