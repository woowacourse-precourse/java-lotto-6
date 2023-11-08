package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import lotto.enums.Reward;

public class Tickets {
    private static final int INIT_VAL = 0;
    private static final int ADD_NUM = 1;

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
            result.put(reward, INIT_VAL);
        }
    }

    private void circuitEnum(EnumMap<Reward, Integer> totalResult, Result result) {
        for (Reward reward : totalResult.keySet()) {
            compareResultToCriterion(totalResult, reward, result);
        }
    }

    private void compareResultToCriterion(EnumMap<Reward, Integer> totalResult, Reward reward, Result result) {
        int hitResult = result.getHitResult();
        int bonusResult = result.getBonusResult();

        if (reward.compareHitCnt(hitResult) && reward.compareBonusCnt(bonusResult)) {
            int preValue = totalResult.get(reward);
            totalResult.put(reward, preValue + ADD_NUM);
        }
    }
}
