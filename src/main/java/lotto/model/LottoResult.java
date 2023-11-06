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
    public void matchingCount(Integer number,boolean isBonus) {
        for(LottoInfo lottoInfo : lottos.getLottos()) {
            if(Objects.equals(lottoInfo.getMatchCount(), number)) {
                if(number == 3) {
                    this.countOf3 = this.countOf3 + 1;
                }
                else if(number == 4) {
                    this.countOf4 = this.countOf4 + 1;
                }
                else if(number == 5) {
                    this.countOf5 = this.countOf5 + 1;
                }
                else if(number == 6) {
                    if (isBonus) {
                        this.countOf5AndBonus = this.countOf5AndBonus + 1;
                    }
                    else {
                        this.countOf6 = this.countOf6 + 1;
                    }
                }
            }
        }
    }
}
