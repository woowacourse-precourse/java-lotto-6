package lotto;

import java.util.List;

public class LottoService {

    private Lotto winningLotto;
    private int bonusNumber;

    public LottoService() { }

    public LottoService(List<Integer> winningNumbers, int bonusNumber) {
        this.winningLotto = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public DrawResult checkResult(Lotto lotto) {
        return DrawResult.resultOf(lotto.countHitNumbers(this.winningLotto),
                containsBonusNumber(lotto));
    }

    public boolean containsBonusNumber(Lotto lotto) {
        return lotto.containsGivenNumber(this.bonusNumber);
    }
}
