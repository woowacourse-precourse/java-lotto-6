package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.error.Error.ErrorType;

public class LottoTicketGenerator {
    public int ticketCount;

    public LottoTicketGenerator() {
    }

    public LottoTicket createLottoTicket() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        LottoTicket lottoTicket = new LottoTicket(lottoNumber);
        return lottoTicket;
    }

    public List<LottoTicket> createLottoTickets() {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottoTickets.add(createLottoTicket());
        }
        return lottoTickets;
    }

    public void insertMoney(int money) {
        this.ticketCount = money / 1000;
    }

    public void validate(int money) {
        if (!(money % 1000 == 0) || money <= 0) {
            throw new IllegalArgumentException(ErrorType.INVALID_MONEY_VALUE.getMessage());
        }
    }

}
