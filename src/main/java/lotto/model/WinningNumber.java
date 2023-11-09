package lotto.model;

import static lotto.exception.ErrorType.BONUS_DUPLICATED;

import java.util.List;

public class WinningNumber {

    private final Lotto winningLotto;

    private final LottoNumber bonusNumber;

    public WinningNumber(final List<Integer> numbers, final int bonusNumber) {
        validate(numbers, bonusNumber);
        this.winningLotto = new Lotto(numbers);
        this.bonusNumber = LottoNumber.of(bonusNumber);
    }

    private void validate(final List<Integer> numbers, final int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_DUPLICATED.getMessage());
        }
    }

    public LottoRank compare(final Lotto lotto) {
        final MatchCount matchCount = winningLotto.findMatchCount(lotto);
        final boolean bonusMatches = lotto.contains(bonusNumber);
        return LottoRank.of(matchCount, bonusMatches);
    }
}
