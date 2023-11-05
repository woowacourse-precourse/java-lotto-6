package lotto;

import java.util.List;

public class LottoChecker {

    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;

    public LottoChecker(List<Integer> winningNumbers, Integer bonusNumber) {
        validate(winningNumbers);
        validateNumberRange(bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        winningNumbers.forEach(this::validateNumberRange);
    }

    private void validateNumberRange(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
