package lotto.dto;

import lotto.model.WinningLotto;

public record Result(int matchCount, int amounts, boolean isBonus, long winningLottoCount) {

    public static Result of(WinningLotto winningLotto, long winningLottoCount) {
        return new Result(winningLotto.getMatchCount(),
                winningLotto.getAmounts(),
                winningLotto.isBonus(),
                winningLottoCount);
    }
}
