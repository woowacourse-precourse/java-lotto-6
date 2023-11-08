package lotto.domain;

import static lotto.domain.lotto.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.domain.lotto.LottoConstants.MIN_LOTTO_NUMBER;
import static lotto.util.ErrorMessage.DUPLICATED_INPUT;
import static lotto.util.ErrorMessage.INVALID_RANGE;

import lotto.domain.lotto.Lotto;

public class WinningNumbers {

    private static final int FIVE_MATCHES = 5;
    private final Lotto winningTicket;
    private final int bonusNumber;

    public WinningNumbers(Lotto winningTicket, int bonusNumber) {
        validate(winningTicket, bonusNumber);
        this.winningTicket = winningTicket;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningTicket, int bonusNumber) {
        if (winningTicket.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_INPUT.getMessage());
        }
        if (bonusNumber < MIN_LOTTO_NUMBER.getValue() || bonusNumber > MAX_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(INVALID_RANGE.getMessage());
        }
    }

    public Rankings assignRankings(Lotto lotto) {
        int matchCount = winningTicket.countMatches(lotto);
        boolean hasBonusNumber = false;
        if (matchCount == FIVE_MATCHES) {
            hasBonusNumber = lotto.contains(bonusNumber);
        }

        return Rankings.setRankings(matchCount, hasBonusNumber);
    }
}
