package lotto.model;

import java.util.List;

public class LottoChecker extends Lotto {

    private final int bonusNumber;

    public LottoChecker(List<Integer> winningNumber, int bonusNumber) {
        super(winningNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getMatchCount(Lotto ticket) {
        return (int) getNumberStream().filter(ticket::contain).count();
    }

    public boolean hasBonusNumber(Lotto ticket) {
        return ticket.contain(bonusNumber);
    }

}