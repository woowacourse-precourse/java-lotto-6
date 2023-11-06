package lotto.model;

import java.util.List;

public class WinningNumber {

    private static final String BONUS_DUPLICATED
            = "[ERROR] 보너스 번호는 로또 번호에 포함되지 않는 숫자여야 합니다.";

    private final Lotto winningLotto;

    private final BonusNumber bonusNumber;

    public WinningNumber(final List<Integer> numbers, final int bonusNumber) {
        validate(numbers, bonusNumber);
        this.winningLotto = new Lotto(numbers);
        this.bonusNumber = BonusNumber.of(bonusNumber);
    }

    private void validate(final List<Integer> numbers, final int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_DUPLICATED);
        }
    }

    public LottoRank compare(final Lotto lotto) {
        final MatchingType matchingType = getMatchingType(lotto);
        return LottoRank.of(matchingType);
    }

    private MatchingType getMatchingType(final Lotto lotto) {
        final MatchCount matchCount = winningLotto.findMatchCount(lotto);
        final BonusStatus bonusStatus = bonusNumber.existOn(lotto);
        return MatchingType.find(matchCount, bonusStatus);
    }
}
