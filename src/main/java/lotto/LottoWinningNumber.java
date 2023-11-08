package lotto;

import java.util.ArrayList;
import java.util.List;
import msg.ErrorMessage;

public class LottoWinningNumber {
    private List<Integer> commonNumbers;
    private int bonusNumber;

    private LottoWinningNumber(List<Integer> commonNumbers, int bonusNumber) {
        this.commonNumbers = commonNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static Builder builder() {
        return new Builder();
    }

    public List<Integer> getCommonNumbers() {
        return commonNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public static class Builder {
        private List<Integer> commonNumbers;
        private Integer bonusNumber;

        private Builder() {
        }

        public Builder commonNumbers(List<Integer> commonNumbers) {
            verifyCommonNumber(commonNumbers);
            this.commonNumbers = commonNumbers;
            return this;
        }

        private void verifyCommonNumber(List<Integer> numbers) {
            if (numbers.size() != LottoConfig.COUNT) {
                throw new IllegalArgumentException(ErrorMessage.COUNT_DIFFERENCE.value());
            }
            numbers.forEach(number -> {
                if (number < LottoConfig.START_NUM || number > LottoConfig.END_NUM) {
                    throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.value());
                }
            });

            List<Integer> uniqueNumbers = new ArrayList<>();
            numbers.forEach(number -> {
                if (uniqueNumbers.contains(number)) {
                    throw new IllegalArgumentException(ErrorMessage.DUPLICATE.value());
                }
                uniqueNumbers.add(number);
            });
        }

        public Builder bonusNumber(int bonusNumber) {
            verifyBonusNumber(bonusNumber);
            this.bonusNumber = bonusNumber;
            return this;
        }

        private void verifyBonusNumber(int bonus) {
            if (commonNumbers == null || commonNumbers.isEmpty()) {
                throw new IllegalStateException(ErrorMessage.THERES_NO_COMMON.value());
            }
            if (bonus < LottoConfig.START_NUM || bonus > LottoConfig.END_NUM) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.value());
            }

            if (commonNumbers.contains(bonus)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE.value());
            }
        }

        public LottoWinningNumber build() {
            if (commonNumbers == null || commonNumbers.isEmpty()) {
                throw new IllegalStateException(ErrorMessage.THERES_NO_COMMON.value());
            }
            if (bonusNumber == null) {
                throw new IllegalStateException(ErrorMessage.THERES_NO_BONUS.value());
            }
            return new LottoWinningNumber(commonNumbers, bonusNumber);
        }
    }
}
