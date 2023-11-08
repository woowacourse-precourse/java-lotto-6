package lotto.core.domain;

import java.util.Arrays;

public enum WinningCondition {
    FIRST_PLACE("6개 일치", 6, false, 2000000000),
    SECOND_PLACE("5개 일치, 보너스 볼 일치", 5, true, 30000000),
    THRID_PLACE("5개 일치", 5, false, 1500000),
    FORTH_PLACE("4개 일치", 4, false, 50000),
    FIFTH_Place("3개 일치", 3, false, 5000),
    LOSE("패배", 0, false, 0),
    ;

    final String description;
    final int lottoNumberCount;
    final boolean includeBonusNumber;
    final int reward;

    WinningCondition(String description, int lottoNumberCount, boolean includeBonusNumber, int reward) {
        this.description = description;
        this.lottoNumberCount = lottoNumberCount;
        this.includeBonusNumber = includeBonusNumber;
        this.reward = reward;
    }

    public String getDescription() {
        return description;
    }

    public int getReward() {
        return reward;
    }

    public static WinningCondition getByMatchResult (int matchingLottoNumberCount, boolean isMatchBonusNumber) {
        return Arrays.stream(WinningCondition.values())
                .filter(condition -> condition.lottoNumberCount == matchingLottoNumberCount && condition.includeBonusNumber == isMatchBonusNumber)
                .findFirst()
                .orElse(LOSE);
    }
}
