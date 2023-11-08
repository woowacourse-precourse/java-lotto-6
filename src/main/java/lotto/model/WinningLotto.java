package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto extends Lotto{
    private final int bonusNumber;
    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validateBonusNumber(bonusNumber, numbers);
        this.bonusNumber = bonusNumber;
    }

    public int compareNumbers(Lotto lotto) {
        List<Integer> temp = new ArrayList<>(lotto.getNumbers());
        temp.retainAll(getNumbers());
        return temp.size();
    }

    public boolean compareBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> numbers) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자여야 합니다.");
        }
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다.");
        }
    }
}
