package lotto.domain;

import java.util.List;

public class WinningLotto {

    private Lotto lotto;
    private int bonusNumber;

    public List<Integer> getNumbers() {
        return lotto.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void generate(List<Integer> numbers) {
        lotto = new Lotto(numbers);
    }

    public void updateBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
