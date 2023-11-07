package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.error.Error;
import lotto.error.Error.ErrorType;

public class LottoTicketGenerator {
    List<LottoTicket> lottoTickets;
    int numberOfTicket;

    public LottoTicketGenerator() {
    }

    public LottoTicket createLottoTicket() {
        LottoTicket lottoTicket = (LottoTicket) Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lottoTicket;
    }

    public List<LottoTicket> returnLottoTickets() {
        for (int i = 0; i < numberOfTicket; i++) {
            lottoTickets.add((LottoTicket) createLottoTicket());
        }
        return lottoTickets;
    }

    public void getNumberOfTicket(int amount) {
        validate(amount);
        this.numberOfTicket = amount / 1000;
    }

    private void validate(int amount) {
        if (!(amount % 1000 == 0) || amount <= 0) {
            Error.errorMessage(ErrorType.INVALID_AMOUNT);
        }
    }

}
