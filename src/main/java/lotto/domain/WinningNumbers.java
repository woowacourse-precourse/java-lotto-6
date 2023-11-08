package lotto.domain;

import java.util.List;

import static lotto.util.message.ExceptionMessage.CHECK_DUPLICATES;

public class WinningNumbers {

    private final Lotto winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningNumbers(Lotto winningNumbers, BonusNumber bonusNumber) {
        checkDuplicateWinningNumInBonusNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void checkDuplicateWinningNumInBonusNumber(Lotto winningNumbers, BonusNumber bonusNumber) {
        List<Integer> numbers = winningNumbers.getNumbers();
        if (bonusNumber.containsIn(numbers)) {
            throw new IllegalArgumentException(CHECK_DUPLICATES.getMessage());
        }
    }

    public RankInfo compareTo(Lotto lottoTicket) {
        List<Integer> numbers = lottoTicket.getNumbers();
        Integer count = (int) winningNumbers.getNumbers().stream()
                .filter(numbers::contains)
                .count();
        boolean isBonusNumContained = bonusNumber.containsIn(numbers);
        return RankInfo.getRankByValue(count, isBonusNumContained);
    }
}
