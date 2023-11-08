package lotto.domain.winninglotto;

import java.util.List;
import lotto.domain.lotto.BonusNumber;
import lotto.domain.lotto.Lotto;
import lotto.domain.ranking.LottoRanking;

public class WinningLotto {

    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    private WinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(List<Integer> lottoNumbers, int bonusNumberValue) {
        Lotto lotto = new Lotto(lottoNumbers);
        BonusNumber bonusNumber = BonusNumber.of(bonusNumberValue, lotto);

        return new WinningLotto(lotto, bonusNumber);
    }

    public LottoRanking judge(Lotto lotto) {
        int numberOfMatches = this.lotto.countMatches(lotto);
        boolean bonusNumberMatches = bonusNumber.containsInLotto(lotto);

        return LottoRanking.of(numberOfMatches, bonusNumberMatches);
    }
}
