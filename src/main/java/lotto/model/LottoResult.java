package lotto.model;

import java.util.List;
import java.util.Objects;

public class LottoResult {
    private Lottos lottos;
    private Lotto winningLotto;
    private Integer bonusNumber;
    public LottoResult(Lottos lottos, Lotto winningLotto, Integer bonusNumber) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }
    public void countingMatchCount() {
        for(LottoInfo lottoInfo : this.lottos.getLottos()) {
            lottoInfo.countMatch(this.winningLotto);
            lottoInfo.isMatchBonus(this.bonusNumber);
        }
    }
}
