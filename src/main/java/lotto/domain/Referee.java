package lotto.domain;

import java.util.List;

public class Referee {
    private final List<Lotto> lottos;
    private final WinningNumbers winningNumbers;
    private final int bonusNumber;

    public Referee(List<Lotto> lottos, WinningNumbers winningNumbers, int bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
}
