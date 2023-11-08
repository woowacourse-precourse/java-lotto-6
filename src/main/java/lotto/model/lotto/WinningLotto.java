package lotto.model.lotto;

import static lotto.utils.constant.LottoConstant.LOTTO_NUMBER_COUNT;

import java.util.List;

public class WinningLotto {

    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, BonusNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public int numberMatches(List<Integer> numbers) {
        int matchCount = 0;
        for (int i = 0; i < LOTTO_NUMBER_COUNT.getValue(); i++) {
            if (winningLotto.isNumberExist(numbers.get(i))) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean isBonusMatches(List<Integer> numbers) {
        return this.bonusNumber.isBonusNumberMatches(numbers);
    }
}
