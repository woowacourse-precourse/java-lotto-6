package lotto.domain;

import lotto.constants.WinningInfo;

import java.util.Optional;

public class Result {
    private Optional<WinningInfo> winningInfo;

    public Result(Optional<WinningInfo> winningInfo) {
        this.winningInfo = winningInfo;
    }

    public static Result createResult(int numberOfMatch, boolean isBonusPrize) {
        return new Result(WinningInfo.of(numberOfMatch, isBonusPrize));
    }

    public Optional<WinningInfo> getWinningInfo() {
        return this.winningInfo;
    }
}
