package lotto;

import static lotto.IntegerUtil.*;
import static lotto.StringUtil.*;

public class LottoManager {

    private int lottoTicketCount;

    public int generateLottoTickets(int payAmount) {

        if ( payAmount % PAY_AMOUNT_UNIT.getValue() != 0 ) {
            throw new IllegalArgumentException(PRINT_ERR_PAY_AMONUT.getMessage());
        }

        return payAmount / PAY_AMOUNT_UNIT.getValue();
    }

    public void setLottoTicketCount(int lottoTicketCount) {
        this.lottoTicketCount = lottoTicketCount;
    }

    public int getLottoTicketCount() {
        return lottoTicketCount;
    }
}
