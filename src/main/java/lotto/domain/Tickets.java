package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import lotto.enums.GlobalConstant;
import lotto.enums.Reward;

public class Tickets {


    private final List<Lotto> tickets;

    public Tickets(List<Lotto> tickets) {
        this.tickets = new ArrayList<>(tickets);
    }

    public int getTicketAmount() {
        return tickets.size();
    }

    public List<Lotto> getTickets() {
        return Collections.unmodifiableList(tickets);
    }

    public TotalResult compareTicketsToAnswer(Answer answer) {
        EnumMap<Reward, Integer> totalResult = new EnumMap<>(Reward.class);
        initEnumMap(totalResult);
        for (Lotto ticket : tickets) {
            Result result = ticket.compareNumberToAnswer(answer);
            circuitEnum(totalResult, result);
        }
        return new TotalResult(totalResult);
    }

    private void initEnumMap(EnumMap<Reward, Integer> result) {
        for (Reward reward : Reward.values()) {
            result.put(reward, GlobalConstant.INIT_VAL.getValue());
        }
    }

    private void circuitEnum(EnumMap<Reward, Integer> totalResult, Result result) {
        for (Reward reward : totalResult.keySet()) {
            result.compareResultToCriterion(totalResult, reward);
        }
    }
}
