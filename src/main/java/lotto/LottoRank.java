package lotto;

import static constants.LottoConstants.*;

public enum LottoRank {
    FIRST(2000000000, LOTTO_WINNING_FIRST_MESSAGE),
    SECOND(30000000, LOTTO_WINNING_SECOND_MESSAGE),
    THIRD(1500000, LOTTO_WINNING_THIRD_MESSAGE),
    FOURTH(50000, LOTTO_WINNING_FOURTH_MESSAGE),
    FIFTH(5000, LOTTO_WINNING_FIFTH_MESSAGE);

    private final int rankPrice;
    private final String rankMessage;

    LottoRank(int rankPrice, String rankMessage) {
        this.rankPrice = rankPrice;
        this.rankMessage = rankMessage;
    }

    public int getRankPrize() {
        return rankPrice;
    }

    public String getRankMessage() {
        return rankMessage;
    }

}
