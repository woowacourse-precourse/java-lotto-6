package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoTicket;
import lotto.repository.LottoTicketRepository;

public class Referee {
    private LottoTicketRepository ticketRepository;

    public Referee(LottoTicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void generateLottoTickets(int purchaseAmount) {
        int purchaseCount = purchaseAmount / LottoTicket.PRICE;
        for (int count = 0; count < purchaseCount; count++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Lotto.MIN_RANGE, Lotto.MAX_RANGE,
                    Lotto.NUMBER_COUNT);
            LottoTicket newLottoTicket = new LottoTicket(numbers);
            ticketRepository.addLottoNumbers(newLottoTicket);
        }
    }
}