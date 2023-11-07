package lotto.dto;

import lotto.model.WinningLotto;

public record TotalResult(int matchCount, int amounts, boolean isBonus, long winningLottoCount) {

    public static TotalResult of(WinningLotto winningLotto, long winningLottoCount) {
        return new TotalResult(winningLotto.getMatchCount(),
                winningLotto.getAmounts(),
                winningLotto.isBonus(),
                winningLottoCount);
    }
}
