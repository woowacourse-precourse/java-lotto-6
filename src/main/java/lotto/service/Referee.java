package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.wrapper.LottoNumber;

public class Referee {
    private Lotto winningLotto;
    private LottoNumber bonusNumber;
    private Lottos playerLottos;

    public Referee(List<Integer> winningNumbers, int bonusNumber, Lottos playerLottos) {
        this.winningLotto = new Lotto(winningNumbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
        this.playerLottos = playerLottos;
    }
}
