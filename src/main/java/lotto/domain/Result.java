package lotto.domain;

import lotto.constants.WinningInfo;

import java.util.Optional;

public class Result {
    int numberOfMatch;
    boolean isBonusPrize;
    Optional<WinningInfo> winningInfo;

    public Result(int numberOfMatch, boolean isBonusPrize, Optional<WinningInfo> winningInfo) {
        this.numberOfMatch = numberOfMatch;
        this.isBonusPrize = isBonusPrize;
        this.winningInfo = winningInfo;
    }

    public static Result createResult(int numberOfMatch, boolean isBonusPrize) {
        return new Result(numberOfMatch, isBonusPrize, WinningInfo.of(numberOfMatch, isBonusPrize));
    }

    public Optional<WinningInfo> getWinningInfo() {
        return this.winningInfo;
    }
}
