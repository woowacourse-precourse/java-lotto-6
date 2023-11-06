package lotto.model;

import java.util.List;
import java.util.Objects;

public class LottoResult {
    private Lottos lottos;
    private Lotto winningLotto;
    private Integer bonusNumber;
    private Integer countOf3;
    private Integer countOf4;
    private Integer countOf5;
    private Integer countOf5AndBonus;
    private Integer countOf6;
    public LottoResult(Lottos lottos, Lotto winningLotto, Integer bonusNumber) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
        this.countOf3 = 0;
        this.countOf4 = 0;
        this.countOf5 = 0;
        this.countOf5AndBonus = 0;
        this.countOf6 = 0;
    }
    public void countingMatchCount() {
        for(LottoInfo lottoInfo : this.lottos.getLottos()) {
            lottoInfo.countMatch(this.winningLotto);
            lottoInfo.isMatchBonus(this.bonusNumber);
        }
    }
}
