package lotto.model;

import static lotto.Constants.Constants.MAX_RANDOM_NUMBER;
import static lotto.Constants.Constants.MIN_RANDOM_NUMBER;
import static lotto.exception.ErrorCode.BONUS_NUMBER_DUPLICATE;
import static lotto.exception.ErrorCode.BONUS_NUMBER_RANGE;

import java.util.List;
import lotto.exception.BonusNumberException;

public class WinningLotto {

    private final Lotto winningNumbersLotto;
    private final int bonus;

    public WinningLotto(final Lotto winningNumbersLotto, final int bonus) {
        validateBonusNumber(winningNumbersLotto, bonus);
        this.winningNumbersLotto = winningNumbersLotto;
        this.bonus = bonus;
    }

    private static void validateBonusNumber(final Lotto winningLotto, final int bonus) {
        validateBonusNumberRange(bonus);
        validateBonusNumberDuplicate(winningLotto, bonus);
    }

    private static void validateBonusNumberRange(final int number) {
        if (number < MIN_RANDOM_NUMBER || number > MAX_RANDOM_NUMBER) {
            throw new BonusNumberException(BONUS_NUMBER_RANGE);
        }
    }

    private static void validateBonusNumberDuplicate(final Lotto winningLotto, final int number) {
        if (winningLotto.contains(number)) {
            throw new BonusNumberException(BONUS_NUMBER_DUPLICATE);
        }
    }

    public LottoResult checkLottos(final List<Lotto> lottos) {
        List<LottoRank> ranks = lottos.stream().map(this::getLottoRank).toList();
        return new LottoResult(ranks);
    }

    private LottoRank getLottoRank(final Lotto lotto) {
        final int matchCount = winningNumbersLotto.getMatchCount(lotto);
        if (matchCount == 5) {
            return LottoRank.valueFrom(matchCount, hasBonusNumber(lotto));
        }
        return LottoRank.valueFrom(matchCount);
    }

    private boolean hasBonusNumber(final Lotto lotto) {
        return lotto.contains(bonus);
    }

}