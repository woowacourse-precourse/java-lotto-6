package lotto.domain;

import static lotto.message.MessageConstants.MESSAGE_FIFTH;
import static lotto.message.MessageConstants.MESSAGE_FIRST;
import static lotto.message.MessageConstants.MESSAGE_FOURTH;
import static lotto.message.MessageConstants.MESSAGE_SECOND;
import static lotto.message.MessageConstants.MESSAGE_THIRD;
import static lotto.message.MessageConstants.PRIZE_FIFTH;
import static lotto.message.MessageConstants.PRIZE_FIRST;
import static lotto.message.MessageConstants.PRIZE_FOURTH;
import static lotto.message.MessageConstants.PRIZE_SECOND;
import static lotto.message.MessageConstants.PRIZE_THIRD;

import java.text.NumberFormat;

public enum WinningRank {
    FIFTH(3, MESSAGE_FIFTH, PRIZE_FIFTH),
    FOURTH(4, MESSAGE_FOURTH, PRIZE_FOURTH),
    THIRD(5, MESSAGE_THIRD, PRIZE_THIRD),
    SECOND(5, MESSAGE_SECOND, PRIZE_SECOND),
    FIRST(6, MESSAGE_FIRST, PRIZE_FIRST);

    private final int matchCount;
    private final String message;
    private final int prizeMoney;

    WinningRank(int matchCount, String message, int prizeMoney) {
        this.matchCount = matchCount;
        this.message = message;
        this.prizeMoney = prizeMoney;
    }

    public boolean isMatch(long matchCount, boolean bonusMatch) {
        if (this == SECOND) {
            return matchCount == this.matchCount && bonusMatch;
        }

        return matchCount == this.matchCount;
    }

    public String getMessage(LottoBuyer lottoBuyer) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        String formattedPrizeMoney = numberFormat.format(prizeMoney);
        return String.format(message, formattedPrizeMoney, lottoBuyer.getWinCount(this));
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
    
}
