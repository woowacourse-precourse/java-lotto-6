package lotto;

import static lotto.IntegerUtil.*;

public class LottoManager {

    public int generateLottoTickets(int payAmount) {

        if ( payAmount % PAY_AMOUNT_UNIT.getValue() == 0 ) {
            return payAmount / PAY_AMOUNT_UNIT.getValue();
        }

        return -1;
    }
}
