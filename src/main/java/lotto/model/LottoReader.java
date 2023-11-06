package lotto.model;

import java.util.Arrays;
import java.util.List;

public class LottoReader {
    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public LottoReader(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static class WinningNumbers {
        private final List<Integer> winningNumbers;

        public WinningNumbers(String winningNumbers) {
            validate();
            this.winningNumbers = Arrays.stream(winningNumbers.split(",")).map(Integer::parseInt).toList();
        }

        private void validate() {

        }
    }

    public static class BonusNumber {
        private final Integer bonusNumber;

        public BonusNumber(String bonusNumber) {
            validate();
            this.bonusNumber = Integer.parseInt(bonusNumber);
        }

        private void validate() {

        }
    }
}
