package lotto;

import java.util.List;

public class DrawResult {

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public DrawResult(Builder builder) {
        this.winningNumbers = builder.winningNumbers;
        this.bonusNumber = builder.bonusNumber;
    }

    public static class Builder {
        private List<Integer> winningNumbers;
        private int bonusNumber;

        public Builder winningNumbers(List<Integer> winningNumbers) {
            validateWinningNumbers(winningNumbers);
            this.winningNumbers = winningNumbers;
            return this;
        }

        public Builder bonusNumber(int bonusNumber) {
            validateBonusNumber(bonusNumber);
            this.bonusNumber = bonusNumber;
            return this;
        }

        public DrawResult build() {
            validateDuplicationBetweenWinningNumbersAndBonusNumber();
            return new DrawResult(this);
        }

        private void validateWinningNumbers(List<Integer> winningNumbers) {
            boolean isSizeInvalid = (winningNumbers.size() != 6);
            boolean isThereAnyDuplicatedNumber = (winningNumbers.size() != winningNumbers.stream().distinct().count());
            boolean isThereAnyOutrangedNumber = false;
            for (Integer number : winningNumbers) {
                if (number < 1 || 45 < number) {
                    isThereAnyOutrangedNumber = true;
                }
            }

            if (isSizeInvalid || isThereAnyDuplicatedNumber || isThereAnyOutrangedNumber) {
                throw new IllegalArgumentException(
                        "당첨 번호는 1이상 45 이하의 중복되지 않는 6개의 정수여야 합니다.");
            }
        }

        private void validateBonusNumber(int bonusNumber) {
            if (bonusNumber < 1 || 45 < bonusNumber) {
                throw new IllegalArgumentException
                        ("보너스 번호는 1이상 45이하의 정수여야합니다.");
            }
        }

        private void validateDuplicationBetweenWinningNumbersAndBonusNumber() {
            if (winningNumbers.contains(bonusNumber)) {
                throw new IllegalArgumentException("보너스 번호와 당첨 번호는 중복되어서는 안됩니다.");
            }
        }
    }

    public Prize check(Lotto lotto) {
        int matchCount = 0;
        boolean isBonusNumberMatch = false;

        List<Integer> numbers = lotto.getImmutableSortedNumbers();
        for (int n : numbers) {
            if (winningNumbers.contains(n)) {
                matchCount++;
            }
        }

        if (lotto.getImmutableSortedNumbers().contains(bonusNumber)) {
            isBonusNumberMatch = true;
        }

        return determineRank(matchCount, isBonusNumberMatch);
    }

    private Prize determineRank(int matchCount, boolean isBonusNumberMatch) {
        if (matchCount == 6) {
            return Prize.FIRST;
        }
        if (matchCount == 5 && isBonusNumberMatch) {
            return Prize.SECOND;
        }
        if (matchCount == 5) {
            return Prize.THIRD;
        }
        if (matchCount == 4) {
            return Prize.FOURTH;
        }
        if (matchCount == 3) {
            return Prize.FIFTH;
        }
        return Prize.LOSE;
    }
}
