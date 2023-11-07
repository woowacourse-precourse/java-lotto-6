package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Rank;
import lotto.domain.Tickets;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.constant.Config.PRICE_PER_LOTTO;
import static lotto.constant.GeneralMessage.NOTIFY_RATE_OF_RETURN;

public class RankMachine {
    private final List<Rank> ranks;
    private final List<Integer> counts;
    private int applyCount;

    public RankMachine(List<Rank> ranks) {
        this.ranks = ranks;
        counts = new ArrayList<>(Collections.nCopies(ranks.size(), 0));
        applyCount = 0;
    }

    public void applyTicket(Lotto ticket, Lotto winningTicket, LottoNumber bonusNumber) {
        for (int i = 0; i < ranks.size(); i++) {
            if (ranks.get(i).winningPredicate().apply(ticket, winningTicket, bonusNumber)) {
                counts.set(i, counts.get(i) + 1);
            }
        }
        applyCount++;
    }

    public void applyTickets(Tickets tickets, Lotto winningTicket, LottoNumber bonusNumber) {
        tickets.lottos().forEach(ticket -> applyTicket(ticket, winningTicket, bonusNumber));
    }

    public String getRankStatistics() {
        DecimalFormat formatter = new DecimalFormat("#,###");
        return IntStream
                .range(0, ranks.size())
                .mapToObj(index -> String.format(
                        ranks.get(index).message().getMessage(),
                        formatter.format(ranks.get(index).reward()),
                        counts.get(index)
                ))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public String getRateOfReturn() {
        DecimalFormat formatter = new DecimalFormat("#,###.0");
        long amountWinning = IntStream
                .range(0, ranks.size())
                .mapToLong(index -> ranks.get(index).reward() * counts.get(index))
                .sum();
        double rate = (double) amountWinning / (applyCount * PRICE_PER_LOTTO);
        return String.format(
                NOTIFY_RATE_OF_RETURN.getMessage(),
                formatter.format(Math.round(rate * 1000) / 10.0).concat("%")
        );
    }
}
