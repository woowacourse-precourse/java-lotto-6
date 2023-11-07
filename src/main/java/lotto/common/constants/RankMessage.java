package lotto.common.constants;

public enum RankMessage {
    FIRST_RANK_MESSAGE(LottoRankRule.FIRST_RANK_MATCH_COUNT.getRank() + "개 일치 (2,000,000,000" + Unit.KOREA_MONEY.getUnit() + ") - "),
    SECOND_RANK_MESSAGE(LottoRankRule.SECOND_RANK_MATCH_COUNT.getRank() + "개 일치, 보너스 볼 일치 (30,000,000" + Unit.KOREA_MONEY.getUnit() + ") - "),
    THIRD_RANK_MESSAGE(LottoRankRule.THIRD_RANK_MATCH_COUNT.getRank() + "개 일치 (1,500,000" + Unit.KOREA_MONEY.getUnit() + ") - "),
    FOURTH_RANK_MESSAGE(LottoRankRule.FOURTH_RANK_MATCH_COUNT.getRank() + "개 일치 (50,000" + Unit.KOREA_MONEY.getUnit() + ") - "),
    FIFTH_RANK_MESSAGE(LottoRankRule.FIFTH_RANK_MATCH_COUNT.getRank() + "개 일치 (5,000" + Unit.KOREA_MONEY.getUnit() + ") - ");

    private final String message;

    RankMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
