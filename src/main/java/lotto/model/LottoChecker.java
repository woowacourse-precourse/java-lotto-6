package lotto.model;

import java.util.List;

public class LottoChecker {

    private final List<Integer> numbers;

    private final int bonusNumber;

    public LottoChecker(List<Integer> winningNumber, int bonusNumber) {
        this.numbers = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public int getMatchCount(Lotto ticket) {
        return (int) numbers.stream().filter(ticket::contain).count();
    }

    public boolean hasBonusNumber(Lotto ticket) {
        return ticket.contain(bonusNumber);
    }

}