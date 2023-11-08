package lotto.model;

import static lotto.util.Constants.MAX_NUMBER;
import static lotto.util.Constants.MIN_NUMBER;
import static lotto.util.Constants.NUMBERS_SIZE;
import static lotto.util.ExceptionMessage.TICKET_COUNT_INVALID_NUMBER;
import static lotto.util.ExceptionMessage.TICKET_COUNT_IS_NULL;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private final List<Lotto> issuedLotto;

    public LottoMachine(Integer lottoTicket) {
        validateTicketCountIsNull(lottoTicket);
        validateTicketCountIsNegative(lottoTicket);
        this.issuedLotto = new ArrayList<>();
        issueTickets(lottoTicket);
    }

    private void issueTickets(int ticketCount) {
        int init = 1;
        while (init++ <= ticketCount) {
            List<Integer> numbers =
                new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBERS_SIZE));
            Collections.sort(numbers);
            issuedLotto.add(new Lotto(numbers));
        }
    }

    private void validateTicketCountIsNegative(Integer ticketCount) {
        if (ticketCount <= 0) {
            throw new IllegalArgumentException(TICKET_COUNT_INVALID_NUMBER.getMessage());
        }
    }

    private void validateTicketCountIsNull(Integer ticketCount) {
        if (ticketCount == null) {
            throw new NullPointerException(TICKET_COUNT_IS_NULL.getMessage());
        }
    }

    public List<Lotto> getIssuedLotto() {
        return this.issuedLotto;
    }
}
