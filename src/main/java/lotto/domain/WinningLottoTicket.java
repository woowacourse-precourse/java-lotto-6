package lotto.domain;

import java.util.List;

public class WinningLottoTicket {

    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLottoTicket(List<Integer> winningNumbers, int bonusNumber) {
        this.winningLotto = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public Rank match(Lotto lotto) {
        int countOfMatch = (int) winningLotto.getNumbers().stream().filter(lotto.getNumbers()::contains).count();
        boolean matchBonus = lotto.getNumbers().contains(bonusNumber);
        return Rank.valueOf(countOfMatch, matchBonus);
    }
}