package lotto.domain;

import static lotto.common.exception.ExceptionMessages.DUPLICATE_WINNING_NUMBER;

import lotto.dto.MatchResult;

public record WinningTicket(Lotto winningLotto, LottoNumber bonusNumber) {

    public WinningTicket {
        validate(winningLotto, bonusNumber);
    }

    private void validate(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.has(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_WINNING_NUMBER.getMessage());
        }
    }

    public MatchResult match(Lotto lotto) {
        int matchCount = getMatchCount(lotto);
        boolean hasBonus = getHasBonus(lotto);
        return new MatchResult(matchCount, hasBonus);
    }

    private int getMatchCount(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningLotto::has)
                .count();
    }

    private boolean getHasBonus(Lotto lotto) {
        return lotto.has(bonusNumber);
    }
}
