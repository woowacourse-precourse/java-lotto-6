package lotto.domain;

import java.util.List;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(int bonusNumber, List<Integer> numbers) {
        this.bonusNumber = bonusNumber;
        duplicate(numbers);
        exceed(bonusNumber);
    }

    private void duplicate(List<Integer> numbers) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }

    private void exceed(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호의 입력 가능 범위는 1부터 45까지 입니다.");
        }
    }
}
