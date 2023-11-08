package lotto.domain;

import lotto.exception.LottoTicketExceptionMessages;
import lotto.view.OutputView;

public class LottoTicket {
    public static final int PRICE_OF_LOTTO_TICKET = 1000;
    private final Lotto lotto;

    public LottoTicket(Lotto lotto) {
        this.lotto = lotto;
    }

    public int calculateMatchCount(final WinningLotto winningLotto) {
        return winningLotto.countDuplicateNumbers(lotto);
    }

    public boolean containsBonusNumber(final WinningLotto winningLotto) {
        return winningLotto.containsBonusNumber(lotto);
    }

    public static void validateAffordability(final int budget) {
        if (budget % PRICE_OF_LOTTO_TICKET != 0) {
            OutputView.println(LottoTicketExceptionMessages.EXPECTED_DIVISIBLE_BY_COST);
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return lotto.toString();
    }
}
