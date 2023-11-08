package lotto.domain.handler.service;

import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.domain.event.Yieldcalculationcompleted;
import lotto.domain.event.LottoMessageBroker;
import lotto.domain.event.LottoRank;
import lotto.domain.event.output.TicketsCreated;
import lotto.domain.event.output.TicketsEvaluateCompleted;
import lotto.util.LottoNumberConstants;
import lotto.util.LottoRankUtils;

import java.util.List;
import java.util.Map;

public class LottoYieldCalculatorHandler {
    private final LottoMessageBroker lottoMessageBroker;

    public LottoYieldCalculatorHandler(LottoMessageBroker lottoMessageBroker) {
        this.lottoMessageBroker = lottoMessageBroker;
    }

    public void calculateYield(TicketsEvaluateCompleted ticketsEvaluateCompleted) {
        TicketsCreated tickets = ticketsEvaluateCompleted.tickets();
        Map<LottoRank, Integer> rankCount = ticketsEvaluateCompleted.rankCount();

        List<String> allRankResults = calculateAllRankResults(rankCount);
        long totalPrizeMoney = calculateTotalPrizeMoney(rankCount);

        double profitRate = calculateProfitRate(totalPrizeMoney, tickets);

        lottoMessageBroker.enqueue(new Yieldcalculationcompleted(allRankResults, profitRate));
    }

    private List<String> calculateAllRankResults(Map<LottoRank, Integer> rankCount) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.NO_MATCH)
                .map(rank -> LottoRankUtils.getAllRank(rank, rankCount.get(rank)))
                .collect(Collectors.toList());
    }

    private long calculateTotalPrizeMoney(Map<LottoRank, Integer> rankCount) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.NO_MATCH)
                .mapToLong(rank -> rank.getPrizeMoney() * rankCount.get(rank))
                .sum();
    }

    private double calculateProfitRate(long totalPrizeMoney, TicketsCreated tickets) {
        int totalMoneySpent = tickets.lottos().size() * LottoNumberConstants.LOTTO_PRICE.getValue();
        return (double) totalPrizeMoney / totalMoneySpent * LottoNumberConstants.ONE_HUNDRED_PERCENT.getValue();
    }
}
