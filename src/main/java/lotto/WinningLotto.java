package lotto;

import java.util.List;
import lotto.validator.Validator;

public class WinningLotto extends Lotto {
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validate(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        Validator.validateBonusNumber(bonusNumber, numbers);
    }

    public LottoRanking checkLottoResult(Lotto lotto) {
        long matchCount = lotto.countMatchingNumbers(this);
        boolean hasBonusNumber = lotto.isInNumbers(bonusNumber);
        return LottoRanking.getLottoRanking(matchCount, hasBonusNumber);
    }
}
