package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.size() != 6 || !isInRange(winningNumbers, 1, 45) || !isInRange(bonusNumber, 1, 45)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복되면 안됩니다.");
        }
    }

    private boolean isInRange(int number, int min, int max) {
        return number >= min && number <= max;
    }

    private boolean isInRange(List<Integer> numbers, int min, int max) {
        for (int number : numbers) {
            if (!isInRange(number, min, max)) {
                return false;
            }
        }
        return true;
    }

    public Rank calculateRank(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        long matchCount = lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
        boolean hasBonusNumber = lottoNumbers.contains(bonusNumber);
        return Rank.valueOf(matchCount, hasBonusNumber);
    }
}
