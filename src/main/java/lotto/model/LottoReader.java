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

    public List<Integer> read(LottoTicket lottoTicket) {
        return lottoTicket.getLottos().stream()
                .map(this::a)
                .toList();
    }

    Integer a(Lotto lotto) {
        Integer result = lotto.compare(winningNumbers.getWinningNumbers());
        if (result.equals(6)) {
            return 1;
        }
        if (lotto.contains(bonusNumber.getBonusNumber())) {
            result++;
        }
        if (result.equals(6)) {
            return 2;
        }
        if (result.equals(5)) {
            return 3;
        }
        if (result.equals(4)) {
            return 4;
        }
        if (result.equals(3)) {
            return 5;
        }
        return null;
    }

    public static class WinningNumbers {
        private final List<Integer> winningNumbers;

        public WinningNumbers(String winningNumbers) {
            validate();
            this.winningNumbers = Arrays.stream(winningNumbers.split(",")).map(Integer::parseInt).toList();
        }

        private void validate() {

        }

        public List<Integer> getWinningNumbers() {
            return this.winningNumbers;
        }
    }

    public static class BonusNumber {
        private final Integer bonusNumber;

        public BonusNumber(String bonusNumber) {
            validate();
            this.bonusNumber = Integer.parseInt(bonusNumber);
        }

        public Integer getBonusNumber() {
            return bonusNumber;
        }

        private void validate() {

        }
    }
}
