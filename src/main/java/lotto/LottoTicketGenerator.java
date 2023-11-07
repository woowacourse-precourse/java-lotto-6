package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.error.Error;
import lotto.error.Error.ErrorType;

public class LottoTicketGenerator {
    List<Integer> lottoNumber;
    static int NUMBER_OF_TICKET;

    public LottoTicketGenerator(int amount) {
        validate(amount);
        NUMBER_OF_TICKET = amount / 1000;
    }

    public List<Integer> createLottoTicket() {
        lottoNumber = Randoms.pickUniqueNumbersInRange(1,45,6);
        return lottoNumber;
    }

    private void validate(int amount) {
        if (!(amount / 1000 == 0) || amount <= 0) {
            Error.errorMessage(ErrorType.INVALID_AMOUNT);
        }
    }

}
