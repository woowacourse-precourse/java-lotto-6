package lotto.model;

import java.util.Arrays;

public enum winningDetails {
    FIRST(new winningDetailsResult(6, false), 2000000000),
    SECOND(new winningDetailsResult(5, true), 30000000),
    THIRD(new winningDetailsResult(5, false), 1500000),
    FOURTH(new winningDetailsResult(4, false), 50000),
    FIFTH(new winningDetailsResult(3, false), 5000),
    MISS(new winningDetailsResult(0, false), 0);

    private final winningDetailsResult winningDetailsResult;
    private final int reward;

    winningDetails(final winningDetailsResult winningDetailsResult, final int reward) {
        this.winningDetailsResult = winningDetailsResult;
        this.reward = reward;
    }

    public static winningDetails getWinningDetails(final int matchingLottoNumber, final boolean checkBonusBall) {
        winningDetailsResult winningDetailsResult = new winningDetailsResult(matchingLottoNumber, checkBonusBall);
        return Arrays.stream(values())
                .filter(winningDetails -> winningDetailsResult.equals(winningDetailsResult))
                .findAny()
                .orElse(MISS);
    }

    public int getMatchingLotto() {
        return winningDetailsResult.getMatchingLottoNumber();
    }

    public int getReward() {
        return reward;
    }


}
