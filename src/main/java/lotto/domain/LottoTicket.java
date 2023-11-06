package lotto.domain;

import lotto.exception.LottoTicketExceptionMessages;
import lotto.view.OutputView;

public class LottoTicket {
    public static final int PRICE_OF_LOTTO_TICKET = 1000;
    private final Lotto lotto;

    public LottoTicket(Lotto lotto) {
        this.lotto = lotto;
    }

    public static void validateAffordability(final int budget) {
        if (budget % PRICE_OF_LOTTO_TICKET != 0) {
            OutputView.println(LottoTicketExceptionMessages.EXPECTED_DIVISIBLE_BY_COST);
            throw new IllegalArgumentException();
        }
    }

}
