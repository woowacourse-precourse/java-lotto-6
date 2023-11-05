package lotto.domain;

import java.util.List;

public class WinningNumbers {

    private final Lotto winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningNumbers(Lotto winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public RankInfo compareTo(Lotto lottoTicket) {
        List<Integer> numbers = lottoTicket.getNumbers();
        int count = (int) winningNumbers.getNumbers().stream()
                .filter(numbers::contains)
                .count();
        boolean isBonusNumContained = bonusNumber.containsIn(numbers);
        return RankInfo.getRankByValue(count, isBonusNumContained);
    }
}
