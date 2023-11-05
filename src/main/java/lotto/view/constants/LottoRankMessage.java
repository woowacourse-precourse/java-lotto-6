package lotto.view.constants;

import lotto.common.constants.LottoRank;

public enum LottoRankMessage {
    FIFTH(LottoRank.FIFTH),
    FOURTH(LottoRank.FOURTH),
    THIRD(LottoRank.THIRD),
    SECOND(LottoRank.SECOND),
    FIRST(LottoRank.FIRST);

    private static final String FORMAT = "%d개 일치%s (%,d원)";
    private static final String HAS_BONUS_BALL_MESSAGE = ", 보너스 볼 일치";
    private final String message;

    LottoRankMessage(LottoRank rank) {
        String bonusBallMessage = "";
        if (rank.hasBonusBall()) {
            bonusBallMessage = HAS_BONUS_BALL_MESSAGE;
        }
        this.message = String.format(FORMAT, rank.getMatchingNumbersCount(), bonusBallMessage, rank.getPrize());
    }

    public String getMessage() {
        return this.message;
    }
}
