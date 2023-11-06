package lotto.core.lotto;

import static lotto.core.enums.WinningChartEnum.*;

import java.util.ArrayList;
import java.util.List;

public class ScratchedLottoTicketList {
    private final List<ScratchedLottoTicket> scratchedLottoTickets;
    private final Integer sixMatchCount;
    private final Integer fiveAndBonusMatchCount;
    private final Integer fiveMatchCount;
    private final Integer fourMatchCount;
    private final Integer threeMatchCount;

    public static ScratchedLottoTicketList createLottoResult(List<ScratchedLottoTicket> scratchedLottoTickets) {
        return new ScratchedLottoTicketList(scratchedLottoTickets);
    }

    private ScratchedLottoTicketList(List<ScratchedLottoTicket> scratchedLottoTickets) {
        this.scratchedLottoTickets = scratchedLottoTickets;
        this.sixMatchCount = (int) scratchedLottoTickets.stream()
                .filter(ticket -> ticket.getWinningChartEnum().equals(SIX_MATCH))
                .count();
        this.fiveAndBonusMatchCount = (int) scratchedLottoTickets.stream()
                .filter(ticket -> ticket.getWinningChartEnum().equals(FIVE_AND_BONUS_MATCH))
                .count();
        this.fiveMatchCount = (int) scratchedLottoTickets.stream()
                .filter(ticket -> ticket.getWinningChartEnum().equals(FIVE_MATCH))
                .count();
        this.fourMatchCount = (int) scratchedLottoTickets.stream()
                .filter(ticket -> ticket.getWinningChartEnum().equals(FOUR_MATCH))
                .count();
        this.threeMatchCount = (int) scratchedLottoTickets.stream()
                .filter(ticket -> ticket.getWinningChartEnum().equals(THREE_MATCH))
                .count();
    }

    public Integer getSixMatchCount() {
        return sixMatchCount;
    }

    public Integer getFiveAndBonusMatchCount() {
        return fiveAndBonusMatchCount;
    }

    public Integer getFiveMatchCount() {
        return fiveMatchCount;
    }

    public Integer getFourMatchCount() {
        return fourMatchCount;
    }

    public Integer getThreeMatchCount() {
        return threeMatchCount;
    }

    public List<ScratchedLottoTicket> getScratchedLottoTickets() {
        return new ArrayList<>(scratchedLottoTickets);
    }
}
