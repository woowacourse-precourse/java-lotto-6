package lotto.model;

import lotto.exceptionMessages.ExceptionMessages;

public class WinningLotto {
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, BonusNumber bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningLotto, BonusNumber bonusNumber) {
        if (winningLotto.getNumbers().contains(bonusNumber.getBonusNumber())) {
            throw new IllegalArgumentException(ExceptionMessages.EXCEPTION_NUMBER_DUPLICATION.getMessage());
        }
    }

    public int getMatchCount(Lotto lottoTicket) {
        return (int) winningLotto.getNumbers().stream()
                .filter(lottoTicket.getNumbers()::contains)
                .count();
    }

    public boolean hasBonusNumber(Lotto lottoTicket) {
        return lottoTicket.getNumbers()
                .contains(bonusNumber.getBonusNumber());
    }
}