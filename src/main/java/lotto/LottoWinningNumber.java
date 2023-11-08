package lotto;

import java.util.ArrayList;
import java.util.List;

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
                throw new IllegalArgumentException("[ERROR] 로또 번호 개수가 다릅니다.");
            }
            numbers.forEach(number -> {
                if (number < LottoConfig.START_NUM || number > LottoConfig.END_NUM) {
                    throw new IllegalArgumentException("[ERROR] 로또 번호로 적합하지 않은 숫자입니다.");
                }
            });

            List<Integer> uniqueNumbers = new ArrayList<>();
            numbers.forEach(number -> {
                if (uniqueNumbers.contains(number)) {
                    throw new IllegalArgumentException("[ERROR] 중복된 숫자를 가질 수 없습니다.");
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
                throw new IllegalStateException("[ERROR] 일반 숫자가 없습니다.");
            }
            if (bonus < LottoConfig.START_NUM || bonus > LottoConfig.END_NUM) {
                throw new IllegalArgumentException("[ERROR] 로또 번호로 적합하지 않은 숫자입니다.");
            }

            if (commonNumbers.contains(bonus)) {
                throw new IllegalArgumentException("[ERROR] 중복된 숫자를 가질 수 없습니다.");
            }
        }

        public LottoWinningNumber build() {
            if (commonNumbers == null || commonNumbers.isEmpty()) {
                throw new IllegalStateException("[ERROR] 일반 숫자가 없습니다.");
            }
            if (bonusNumber == null) {
                throw new IllegalStateException("[ERROR] 보너스 숫자가 없습니다.");
            }
            return new LottoWinningNumber(commonNumbers, bonusNumber);
        }
    }
}
