package lotto.model;

import static lotto.Constants.Constants.MAX_RANDOM_NUMBER;
import static lotto.Constants.Constants.MIN_RANDOM_NUMBER;
import static lotto.exception.ErrorCode.BONUS_NUMBER_DUPLICATE;
import static lotto.exception.ErrorCode.BONUS_NUMBER_RANGE;

import java.util.List;
import lotto.exception.BonusNumberException;

public class LottoChecker {

    private final Lotto winningLotto;
    private final int bonus;

    public LottoChecker(List<Integer> winningNumbers, int bonus) {
        Lotto winningLotto = new Lotto(winningNumbers);
        validateBonusNumber(bonus);
        this.winningLotto = winningLotto;
        this.bonus = bonus;
    }

    private void validateBonusNumber(final int bonus) {
        validateBonusNumberRange(bonus);
        validateBonusNumberDuplicate(bonus);
    }

    private void validateBonusNumberRange(final int number) {
        if (number < MIN_RANDOM_NUMBER || number > MAX_RANDOM_NUMBER) {
            throw new BonusNumberException(BONUS_NUMBER_RANGE);
        }
    }

    private void validateBonusNumberDuplicate(final int number) {
        if (winningLotto.contains(number)) {
            throw new BonusNumberException(BONUS_NUMBER_DUPLICATE);
        }
    }

    public LottoResult checkLottos(final List<Lotto> lottos) {
        final LottoResult result = new LottoResult();
        for (final Lotto lotto : lottos) {
            final LottoRank lottoRank = getLottoRank(lotto);
            result.increaseRankCount(lottoRank);
        }
        return result;
    }

    private LottoRank getLottoRank(final Lotto lotto) {
        final int matchCount = winningLotto.getMatchCount(lotto);
        if (matchCount == 5) {
            return LottoRank.valueFrom(matchCount, hasBonusNumber(lotto));
        }
        return LottoRank.valueFrom(matchCount);
    }

    private boolean hasBonusNumber(final Lotto lotto) {
        return lotto.contains(bonus);
    }

}