package lotto.model.domain.lotto;

import java.util.List;
import lotto.constance.GameConst;
import lotto.exception.LottoGameException;
import lotto.model.domain.result.LottoCompareResult;

public class LottoAnswer extends Lotto {
    private final Integer bonusNumber;

    public LottoAnswer(List<Integer> numbers, Integer bonusNumber) {
        super(numbers);
        validateBonusNumber(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw LottoGameException.DUPLICATED_BONUS_NUMBER.makeException();
        }
    }

    @Override
    public LottoCompareResult compareLotto(Lotto lotto) {
        int collectNumber = collectNumber(lotto);
        boolean collectBonus = false;
        if (collectNumber == GameConst.BONUS_CHECK_NECESSARY) {
            collectBonus = isCollectBonus(lotto);
        }
        return new LottoCompareResult(collectNumber, collectBonus);
    }

    private int collectNumber(Lotto lotto) {
        return (int) lotto.getNumbers()
                .stream()
                .filter(this.getNumbers()::contains)
                .count();
    }

    private boolean isCollectBonus(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
