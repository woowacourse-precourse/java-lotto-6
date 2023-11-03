package lotto.domain.constants;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

public enum LottoWinnings {
    FIRST_PRIZE_WINNINGS(1, 2000000000),
    SECOND_PRIZE_WINNINGS(2, 30000000),
    THIRD_PRIZE_WINNINGS(3, 1500000),
    FOURTH_PRIZE_WINNINGS(4, 50000),
    FIFTH_PRIZE_WINNINGS(5, 5000);

    private final int place;
    private final int winnings;

    LottoWinnings(int place, int winnings) {
        this.place = place;
        this.winnings = winnings;
    }

    public static int getWinningByPlace(int lottoPlace, int lottoCount) {
        Optional<LottoWinnings> matchedWinnings = Arrays.stream(LottoWinnings.values())
                .filter(place -> place.isSamePlace(lottoPlace))
                .findAny();

        return matchedWinnings.get().getWinnings(lottoCount);
    }

    private boolean isSamePlace(int place) {
        return this.place == place;
    }

    private int getWinnings(int lottoCount) {
        return winnings * lottoCount;
    }
}
