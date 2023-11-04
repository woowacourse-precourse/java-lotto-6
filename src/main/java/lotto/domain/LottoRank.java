package lotto.domain;

import static lotto.constant.ResultMessage.STAT;
import static lotto.constant.ResultMessage.BONUS;
import static lotto.constant.ResultMessage.NULL;

import java.util.Arrays;
import java.text.DecimalFormat;
import lotto.constant.ResultMessage;

public enum LottoRank {
    FIFTH(3, false, 5_000L, STAT),
    FOURTH(4, false, 50_000L, STAT),
    THIRD(5, false, 1_500_000L, STAT),
    SECOND(5, true, 30_000_000L, BONUS),
    FIRST(6, false, 2_000_000_000L, STAT),
    NO_PRIZE(0, false, 0, NULL);

    private final int count;
    private final boolean bonus;
    private final long prize;
    private final String message;

    LottoRank(int count, boolean bonus, long prize, ResultMessage message) {
        this.count = count;
        this.bonus = bonus;
        this.prize = prize;
        this.message = makeRankNoticeBase(message);
    }

    public static LottoRank findLottoRank(Integer matchCount, boolean bonusNumberMatch) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.count == matchCount)
                .filter(rank -> rank.bonus == bonusNumberMatch)
                .findAny()
                .orElse(NO_PRIZE);
    }

    public String getMessage() {
        return this.message;
    }

    public long getPrize() {
        return this.prize;
    }

    private String makeRankNoticeBase(ResultMessage message) {
        return String.format(message.getMessage(), count, formatPrize(prize));
    }

    private static String formatPrize(long prize) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(prize);
    }
}
