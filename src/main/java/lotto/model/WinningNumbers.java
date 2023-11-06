package lotto.model;

import java.util.List;

public class WinningNumbers {

    private Lotto winningNumbers;
    private Integer bonusNumber;

    private WinningNumbers(Lotto lotto, Integer bonusNumber) {
        validateDuplicateNumber(lotto, bonusNumber);
        this.winningNumbers = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers from(List<Integer> lotto, Integer bonusNumber) {
        return new WinningNumbers(new Lotto(lotto), bonusNumber);
    }

    public boolean hasNumber(Integer number) {
        return winningNumbers.hasNumber(number);
    }

    public Integer getBonusNumber() {
        return this.bonusNumber;
    }

    private void validateDuplicateNumber(Lotto lotto, Integer bonusNumber) {
        if (lotto.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 숫자는 입력할 수 없습니다.");
        }
    }
}
