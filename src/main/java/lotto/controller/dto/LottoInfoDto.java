package lotto.controller.dto;

import java.util.Map;
import lotto.domain.result.WinningRank;

public class LottoInfoDto {

    private final int matchCount;
    private final int money;
    private final boolean hasBonusNumber;

    private final int winningCount;

    private LottoInfoDto(int matchCount, int money, boolean hasBonusNumber, int winningCount) {
        this.matchCount = matchCount;
        this.money = money;
        this.hasBonusNumber = hasBonusNumber;
        this.winningCount = winningCount;
    }

    public static LottoInfoDto of(Map<WinningRank, Integer> result, WinningRank winningRank) {
        return new LottoInfoDto(winningRank.getCount(), winningRank.getMoney(),
                winningRank.isBonusNumber(), result.get(winningRank));
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getMoney() {
        return money;
    }

    public boolean hasBonusNumber() {
        return hasBonusNumber;
    }

    public int getWinningCount() {
        return winningCount;
    }
}
