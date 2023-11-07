package lotto.domain;

import static lotto.domain.constant.LottoConstant.MATCH_ALL_SEVEN_COUNT;
import static lotto.domain.constant.LottoConstant.MATCH_ALL_SIX_COUNT;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Tickets {
    private List<Ticket> tickets = new ArrayList<>();
    private final Ticket ticket;

    public Tickets(Ticket ticket) {
        this.ticket = ticket;
    }

    public void generate() {
        IntStream.range(0, ticket.ticketCount())
                .mapToObj(i -> ticket.generate())
                .forEach(tickets::add);
    }

    public List<Integer> matchNumber(LottoSet lottoSet) {
        return tickets.stream()
                .map(ticket -> {
                    int lottoCount = lottoSet.sameLottoNumber(ticket.get());
                    int bonusCount = lottoSet.sameBonusNumber(ticket.get());
                    return matchAllCount(lottoCount, bonusCount);
                })
                .collect(Collectors.toList());
    }

    private int matchAllCount(int lottoCount, int bonusCount) {
        int sumCount = lottoCount + bonusCount;

        if (sumCount == MATCH_ALL_SIX_COUNT && lottoCount == 6) {
            sumCount = MATCH_ALL_SEVEN_COUNT;
        }

        return sumCount;
    }
}
