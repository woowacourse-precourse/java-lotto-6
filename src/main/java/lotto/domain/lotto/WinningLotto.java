package lotto.domain.lotto;

import java.util.List;

public class WinningLotto extends Lotto{
    private final Number bonusNumber;
    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validateBonusNumber(numbers);
        this.bonusNumber = Number.of(bonusNumber);
    }

    private void validateBonusNumber(List<Integer> numbers) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
