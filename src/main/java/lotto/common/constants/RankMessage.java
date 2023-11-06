package lotto.common.constants;

public enum RankMessage {
    FIRST_RANK_MESSAGE(LottoRankRule.FIRST_RANK_MATCH_COUNT.getRank() + "개 일치 (" + LottoRankRule.FIRST_RANK_PRICE + Unit.KOREA_MONEY.getUnit() + ") - "),
    SECOND_RANK_MESSAGE(LottoRankRule.SECOND_RANK_MATCH_COUNT.getRank() + "개 일치, 보너스 볼 일치 (" + LottoRankRule.SECOND_RANK_PRICE  + Unit.KOREA_MONEY.getUnit() + ") - "),
    THIRD_RANK_MESSAGE(LottoRankRule.THIRD_RANK_MATCH_COUNT.getRank() + "개 일치 (" + LottoRankRule.THIRD_RANK_PRICE  + Unit.KOREA_MONEY.getUnit() + ") - "),
    FOURTH_RANK_MESSAGE(LottoRankRule.FOURTH_RANK_MATCH_COUNT.getRank() + "개 일치 (" + LottoRankRule.FOURTH_RANK_PRICE  + Unit.KOREA_MONEY.getUnit() + ") - "),
    FIFTH_RANK_MESSAGE(LottoRankRule.FIFTH_RANK_MATCH_COUNT.getRank() + "개 일치 (" + LottoRankRule.FIFTH_RANK_PRICE  + Unit.KOREA_MONEY.getUnit() + ") - ");

    private final String message;

    RankMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    /*
    3개 일치 (5,000원) - 1개
    4개 일치 (50,000원) - 0개
    5개 일치 (1,500,000원) - 0개
    5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
    6개 일치 (2,000,000,000원) - 0개
     */
}
