package lotto;

import java.util.List;

public class WinningLotto extends Lotto {
    private int bonusNum;

    public WinningLotto(List<Integer> numbers, int bonusNum) {
        super(numbers);
        this.bonusNum = bonusNum;
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
