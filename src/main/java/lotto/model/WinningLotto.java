package lotto.model;

import java.util.Arrays;
import java.util.List;
import lotto.utils.ExceptionMessage;

public class WinningLotto {

    private final Lotto lotto;
    private final Bonus bonus;

    public WinningLotto(final Lotto lotto, final Bonus bonus) {
        validate(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    private void validate(Lotto lotto, Bonus bonus) {
        validateBonusNotInLotto(lotto, bonus);
    }

    private void validateBonusNotInLotto(Lotto lotto, Bonus bonus) {
        if (lotto.contains(bonus.bonusNumber())) {
            throw new IllegalArgumentException(
                ExceptionMessage.INVALID_BONUS_DUPLICATION.getMessage());
        }
    }

    public LottoResult matchLottos(final List<Lotto> userLottos) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto userLotto : userLottos) {
            MatchCount matchCount = matchLotto(userLotto);
            lottoResult.addResult(matchCount);
        }
        return lottoResult;
    }

    private MatchCount matchLotto(Lotto userLotto) {
        int matchedCount = getMatchedCount(userLotto);
        if (hasBonusMatch(userLotto, matchedCount)) {
            return MatchCount.FIVE_AND_BONUS_MATCH;
        }
        return findMatchCountByMatchedNumber(matchedCount);
    }

    private int getMatchedCount(Lotto userLotto) {
        return (int) lotto.getNumbers().stream()
            .filter(userLotto::contains)
            .count();
    }

    private boolean hasBonusMatch(Lotto userLotto, int matchedCount) {
        return matchedCount == 5 && userLotto.contains(bonus.bonusNumber());
    }

    private MatchCount findMatchCountByMatchedNumber(int matchedCount) {
        return Arrays.stream(MatchCount.values())
            .filter(matchCount -> matchCount.getMatchCount() == matchedCount)
            .findFirst()
            .orElseThrow(IllegalStateException::new);
    }

}
