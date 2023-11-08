package lotto.domain.handler.service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.event.LottoMessageBroker;
import lotto.domain.event.LottoRank;
import lotto.domain.event.input.BonusNumber;
import lotto.domain.event.input.Lotto;
import lotto.domain.event.output.TicketsCreated;
import lotto.domain.event.output.TicketsEvaluateCompleted;
import lotto.domain.event.input.BonusNumberInputRequested;
import lotto.domain.event.input.LottoInputRequested;

public class LottoCompareHandler {


    private final LottoMessageBroker lottoMessageBroker;


    private final Map<LottoRank, Integer> rankCount = new EnumMap<>(LottoRank.class);

    public LottoCompareHandler(LottoMessageBroker lottoMessageBroker) {
        this.lottoMessageBroker = lottoMessageBroker;
        initMap();
    }


    public void evaluateLottoTickets(BonusNumberInputRequested bonusNumberInputRequested) {
        LottoInputRequested lottoInputReceive = bonusNumberInputRequested.lottoInputReceive();
        BonusNumber bonusNumber = bonusNumberInputRequested.bonusNumber();
        TicketsCreated tickets = lottoInputReceive.ticketsCreated();
        Lotto lotto = lottoInputReceive.lotto();

        evaluateLottoTickets(tickets, lotto, bonusNumber);

        lottoMessageBroker.enqueue(new TicketsEvaluateCompleted(this.rankCount, tickets));

    }

    private void evaluateLottoTickets(TicketsCreated ticketsCreated, Lotto userLotto, BonusNumber bonusNumber) {
        List<Integer> userNumbers = userLotto.numbers();
        List<Lotto> purchasedTickets = ticketsCreated.lottos();

        for (Lotto ticket : purchasedTickets) {
            int matchingNumbers = calculateMatchingNumbers(userNumbers, ticket.numbers());
            boolean isBonusMatched = ticket.numbers().contains(bonusNumber.number());
            LottoRank rank = LottoRank.of(matchingNumbers, isBonusMatched);
            recordRank(rank);
        }
    }


    private int calculateMatchingNumbers(List<Integer> userNumbers, List<Integer> ticketNumbers) {
        return (int) userNumbers.stream()
                .filter(ticketNumbers::contains)
                .count();
    }

    private void initMap() {
        for (LottoRank rank : LottoRank.values()) {
            rankCount.put(rank, 0);
        }
    }

    private void recordRank(LottoRank rank) {
        rankCount.merge(rank, 1, Integer::sum);
    }
}
