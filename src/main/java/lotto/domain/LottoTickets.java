package lotto.domain;

import static lotto.exception.ExceptionMessage.*;

import lotto.exception.LottoException;
import lotto.util.Parser;

public class LottoTickets {
    private final int purchaseMoney;

    private LottoTickets(int purchaseMoney) {
        this.purchaseMoney = purchaseMoney;
    };

    public static LottoTickets purchase(String purchaseMoney) {

        return new LottoTickets(Parser.StringParseInt(purchaseMoney));
    }

    public int getLottoTicketCount() {
        if (purchaseMoney % 1_000 > 0) {
            throw new LottoException(INDIVISIBLE);
        }
        return purchaseMoney / 1_000;
    }
}
