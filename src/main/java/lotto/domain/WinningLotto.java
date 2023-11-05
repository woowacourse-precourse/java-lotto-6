package lotto.domain;

import lotto.Lotto;
import lotto.config.Rank;

public record WinningLotto(Lotto lotto, LottoNumber bonusNumber) {

    public WinningLotto {
        validateDuplicateBonusNumber(lotto, bonusNumber);
    }

    private void validateDuplicateBonusNumber(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public Rank getRank(Lotto compare) {
        return Rank.of(
                countMatchingNumbers(compare),
                matchesBonusNumber(compare)
        );
    }

    private int countMatchingNumbers(Lotto compare) {
        return lotto.countMatchingNumbers(compare);
    }

    private boolean matchesBonusNumber(Lotto compare) {
        return countMatchingNumbers(compare) == Rank.SECOND.matchedCount
                && compare.contains(bonusNumber);
    }
}
