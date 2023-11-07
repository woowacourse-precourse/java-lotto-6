package lotto.domain;

import static lotto.common.exception.ExceptionMessages.DUPLICATE_WINNING_NUMBER;

public record WinningLotto(Lotto lotto, LottoNumber bonusNumber) {

    public WinningLotto {
        validate(lotto, bonusNumber);
    }

    private void validate(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.has(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_WINNING_NUMBER.getMessage());
        }
    }

    public Rank match(Lotto lotto) {
        int matchCount = getMatchCount(lotto);
        boolean hasBonus = getHasBonus(lotto);
        return Rank.of(matchCount, hasBonus);
    }

    private int getMatchCount(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(this.lotto::has)
                .count();
    }

    private boolean getHasBonus(Lotto lotto) {
        return lotto.has(bonusNumber);
    }
}
