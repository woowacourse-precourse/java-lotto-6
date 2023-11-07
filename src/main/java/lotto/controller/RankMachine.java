package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Rank;
import lotto.domain.Tickets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RankMachine {
    private final List<Rank> ranks;
    private List<Integer> counts;

    public RankMachine(List<Rank> ranks) {
        this.ranks = ranks;
        counts = new ArrayList<>(Collections.nCopies(ranks.size(), 0));
    }

    public void applyTicket(Lotto ticket, Lotto winningTicket, LottoNumber bonusNumber) {
        for (int i = 0; i < ranks.size(); i++) {
            if (ranks.get(i).winningPredicate().apply(ticket, winningTicket, bonusNumber)) {
                counts.set(i, counts.get(i) + 1);
            }
        }
    }

    public void applyTickets(Tickets tickets, Lotto winningTicket, LottoNumber bonusNumber) {
        tickets.lottos().forEach(ticket -> applyTicket(ticket, winningTicket, bonusNumber));
    }

    public String getWinningStatistics() {
        // TODO: 당첨 통계 구현
        return "";
    }

    public String getRateOfReturn() {
        // TODO: 수익률 구현
        return "";
    }
}
