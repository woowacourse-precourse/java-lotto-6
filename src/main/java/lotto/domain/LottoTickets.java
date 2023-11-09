package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.vo.BonusNumber;
import lotto.vo.WinningNumbers;

public class LottoTickets {
    private final List<Lotto> tickets;

    private LottoTickets(List<Lotto> tickets) {
        this.tickets = tickets;
    }

    public static LottoTickets from(List<Lotto> tickets) {
        return new LottoTickets(tickets);
    }

    public List<Lotto> getTickets() {
        return Collections.unmodifiableList(tickets);
    }

    public RankResult evaluateWinningStatus(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        RankResult rankResult = RankResult.create();
        tickets.stream()
                .map(lotto -> lotto.matchRank(winningNumbers, bonusNumber))
                .forEach(rankResult::add);
        return rankResult;
    }
}
