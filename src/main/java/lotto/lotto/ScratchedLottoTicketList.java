package lotto.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.enums.WinningChartEnum;

public class ScratchedLottoTicketList {
    private final List<ScratchedLottoTicket> scratchedLottoTickets;
    private  Integer sixMatchCount;
    private  Integer fiveAndBonusMatchCount;
    private  Integer fiveMatchCount;
    private  Integer fourMatchCount;
    private  Integer threeMatchCount;

    public ScratchedLottoTicketList(List<ScratchedLottoTicket> scratchedLottoTickets) {
        this.scratchedLottoTickets = scratchedLottoTickets;
        this.sixMatchCount = (int) scratchedLottoTickets.stream()
                .filter(ticket -> ticket.getWinningChartEnum() == WinningChartEnum.SIX_MATCH)
                .count();
        this.fiveAndBonusMatchCount = (int) scratchedLottoTickets.stream()
                .filter(ticket -> ticket.getWinningChartEnum() == WinningChartEnum.FIVE_AND_BONUS_MATCH)
                .count();
        this.fiveMatchCount = (int) scratchedLottoTickets.stream()
                .filter(ticket -> ticket.getWinningChartEnum() == WinningChartEnum.FIVE_MATCH)
                .count();
        this.fourMatchCount = (int) scratchedLottoTickets.stream()
                .filter(ticket -> ticket.getWinningChartEnum() == WinningChartEnum.FOUR_MATCH)
                .count();
        this.threeMatchCount = (int) scratchedLottoTickets.stream()
                .filter(ticket -> ticket.getWinningChartEnum() == WinningChartEnum.THREE_MATCH)
                .count();
    }

    public static ScratchedLottoTicketList createLottoResult(List<ScratchedLottoTicket> scratchedLottoTickets) {
        return new ScratchedLottoTicketList(scratchedLottoTickets);
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
