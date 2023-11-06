package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto extends Lotto{
    private BonusNumber bonusNumber;

    private WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        this.bonusNumber = new BonusNumber(bonusNumber);
        validate(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (bonusNumber.isContains(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호와 보너스 번호는 중복될 수 없습니다.");
        }
    }

    public static WinningLotto of(List<Integer> numbers, int bonusNumber) {
        return new WinningLotto(numbers,bonusNumber);
    }

    public int countMatchingNumbers(Lotto otherLotto) {
        Set<Integer> winningNumbers = new HashSet<>(getNumbers());
        Set<Integer> numbers = new HashSet<>(otherLotto.getNumbers());

        winningNumbers.retainAll(numbers);

        return winningNumbers.size();
    }
}
