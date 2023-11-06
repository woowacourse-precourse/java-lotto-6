package lotto.domain;

import static lotto.domain.lotto.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.domain.lotto.LottoConstants.MIN_LOTTO_NUMBER;
import static lotto.util.ErrorMessage.DUPLICATED_INPUT;
import static lotto.util.ErrorMessage.INVALID_RANGE;

import lotto.domain.lotto.Lotto;

public class BonusNumber implements Comparable<Integer> {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber, Lotto winningTicket) {
        validate(bonusNumber, winningTicket);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber, Lotto winningTicket) {
        if (winningTicket.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_INPUT.getMessage());
        }
        if (bonusNumber < MIN_LOTTO_NUMBER.getValue() || bonusNumber > MAX_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(INVALID_RANGE.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    @Override
    public int compareTo(Integer o) {
        return this.bonusNumber - o;
    }

    @Override
    public String toString() {
        return "" + bonusNumber;
    }
}
