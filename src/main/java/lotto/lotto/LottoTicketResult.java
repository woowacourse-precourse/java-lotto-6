package lotto.lotto;

import java.util.List;
import lotto.enums.WinningChartEnum;

public class LottoTicketResult {
    private  Integer sixMatchCount;
    private  Integer fiveAndBonusMatchCount;
    private  Integer fiveMatchCount;
    private  Integer fourMatch;
    private  Integer threeMatch;

    public LottoTicketResult(List<ScratchedLottoTicket> scratchedLottoTickets) {
        this.sixMatchCount = (int) scratchedLottoTickets.stream()
                .filter(ticket -> ticket.getWinningChartEnum() == WinningChartEnum.SIX_MATCH)
                .count();
        this.fiveAndBonusMatchCount = (int) scratchedLottoTickets.stream()
                .filter(ticket -> ticket.getWinningChartEnum() == WinningChartEnum.FIVE_AND_BONUS_MATCH)
                .count();
        this.fiveMatchCount = (int) scratchedLottoTickets.stream()
                .filter(ticket -> ticket.getWinningChartEnum() == WinningChartEnum.FIVE_MATCH)
                .count();
        this.fourMatch = (int) scratchedLottoTickets.stream()
                .filter(ticket -> ticket.getWinningChartEnum() == WinningChartEnum.FOUR_MATCH)
                .count();
        this.threeMatch = (int) scratchedLottoTickets.stream()
                .filter(ticket -> ticket.getWinningChartEnum() == WinningChartEnum.THREE_MATCH)
                .count();
    }

    public static LottoTicketResult createLottoResult(List<ScratchedLottoTicket> scratchedLottoTickets) {
        return new LottoTicketResult(scratchedLottoTickets);
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

    public Integer getFourMatch() {
        return fourMatch;
    }

    public Integer getThreeMatch() {
        return threeMatch;
    }
}
