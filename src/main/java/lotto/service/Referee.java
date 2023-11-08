package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoTicket;
import lotto.model.LottoWinningNumbers;
import lotto.repository.LottoTicketRepository;
import lotto.util.Rank;

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

    public List<Rank> calculateRanks(LottoWinningNumbers lottoWinningNumbers) {
        List<Rank> ranks = new ArrayList<>();

        for (LottoTicket ticket : ticketRepository.getLottoTickets()) {
            Rank rank = Rank.calculate(ticket, lottoWinningNumbers);
            ranks.add(rank);
        }
        return ranks;
    }

    public double calculateReturnRate(List<Rank> ranks) {
        int totalPrize = getTotalPrize(ranks);
        int totalPurchase = getTotalPurchase();
        return (double) totalPrize / totalPurchase * 100;
    }

    private int getTotalPurchase() {
        return ticketRepository.getLottoTickets().size() * LottoTicket.PRICE;
    }

    private int getTotalPrize(List<Rank> ranks) {
        return ranks.stream()
                .mapToInt(Rank::getPrize)
                .sum();
    }
}