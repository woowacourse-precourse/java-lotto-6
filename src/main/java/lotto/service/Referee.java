package lotto.service;

import java.util.List;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;

public class Referee {
    private WinningLotto winningLotto;
    private Lottos playerLottos;

    public Referee(List<Integer> winningNumbers, int bonusNumber, Lottos playerLottos) {
        winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        this.playerLottos = playerLottos;
    }
}
