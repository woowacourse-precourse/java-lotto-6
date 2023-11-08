package lotto.domain;

import static lotto.domain.constant.LottoConstant.MATCH_ALL_SEVEN_COUNT;
import static lotto.domain.constant.LottoConstant.MATCH_ALL_SIX_COUNT;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.config.output.MessageType;
import lotto.config.output.OutputMessage;
import lotto.domain.util.RandomNumber;

public class Tickets {
    private List<List<Integer>> tickets = new ArrayList<>();
    private final Ticket ticket;

    public Tickets(Ticket ticket) {
        this.ticket = ticket;
    }

    public void generate() {
        IntStream.range(0, ticket.ticketCount())
                .mapToObj(i -> orderedTicket())
                .forEach(tickets::add);
    }

    private List<Integer> orderedTicket() {
        List<Integer> disorderTicket = RandomNumber.gernerate();
        List<Integer> orderedTicket = ticket.ascendingNumber(disorderTicket);
        OutputMessage.printf(MessageType.INPUT_BUYER_FORMAT, orderedTicket);

        return orderedTicket;
    }

    public List<Integer> matchNumber(LottoSet lottoSet) {
        return this.tickets.stream()
                .map(ticket -> matchAllCount(lottoSet, ticket))
                .collect(Collectors.toList());
    }

    private int matchAllCount(LottoSet lottoSet, List<Integer> ticket) {
        int lottoCount = lottoSet.sameLottoNumber(ticket);
        int bonusCount = lottoSet.sameBonusNumber(ticket);
        return calculateCount(lottoCount, bonusCount);
    }

    private int calculateCount(int lottoCount, int bonusCount) {
        int sumCount = lottoCount + bonusCount;

        if (sumCount == MATCH_ALL_SIX_COUNT && lottoCount == 6) {
            sumCount = MATCH_ALL_SEVEN_COUNT;
        }

        return sumCount;
    }
}
