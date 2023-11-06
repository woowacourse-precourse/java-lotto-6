package lotto.model;

import java.util.List;

public class LottoChecker extends Lotto {

    private final int bonusNumber;

    public LottoChecker(List<Integer> winningNumber, int bonusNumber) {
        super(winningNumber);
        this.bonusNumber = bonusNumber;
    }

    public LottoRank checkTicket(Lotto ticket) {
        int matchCount = getMatchCount(ticket);
        if (matchCount == 5) {
            return LottoRank.valueFrom(matchCount, hasBonusNumber(ticket));
        }
        return LottoRank.valueFrom(matchCount);
    }

    private int getMatchCount(Lotto ticket) {
        return (int) getNumberStream().filter(ticket::contain).count();
    }

    private boolean hasBonusNumber(Lotto ticket) {
        return ticket.contain(bonusNumber);
    }

}