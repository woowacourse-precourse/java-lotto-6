package lotto.constants;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum LottoReward {
    NOTHING(0, "0", (matchLottoCount, matchBonus) -> matchLottoCount < 3),
    FIFTH(3, "5,000", (matchLottoCount, matchBonus) -> matchLottoCount == 3),
    FOURTH(4, "50,000", (matchLottoCount, matchBonus) -> matchLottoCount == 4),
    THIRD(5, "1,500,000", (matchLottoCount, matchBonus) -> matchLottoCount == 5 && !matchBonus),
    SECOND(5, "30,000,000", (matchLottoCount, matchBonus) -> matchLottoCount == 5 && matchBonus),
    FIRST(6, "2,000,000,000", (matchLottoCount, matchBonus) -> matchLottoCount == 6);

    private int matchLottoCount;
    private String winningAmount;
    private BiPredicate<Integer, Boolean> match;

    LottoReward(int matchLottoCount, String winningAmount, BiPredicate<Integer, Boolean> match) {
        this.matchLottoCount = matchLottoCount;
        this.winningAmount = winningAmount;
        this.match = match;
    }

    public static LottoReward getWinningReward(int matchLottoCount, boolean matchBonusNumber) {
        return Arrays.stream(LottoReward.values())
                .filter(winningReward -> winningReward.match.test(matchLottoCount, matchBonusNumber))
                .findAny()
                .orElse(NOTHING);
    }

    public int getMatchLottoCount() {
        return matchLottoCount;
    }

    public String getWinningAmount() {
        return winningAmount;
    }
}
