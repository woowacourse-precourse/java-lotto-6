package lotto.domain;

import java.util.List;

public class WinLotto extends Lotto{

    private final int bonusNumber;
    public WinLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public Prize calculatePrize(Lotto lotto){
        //TODO 등수 계산
        return null;
    }
}
