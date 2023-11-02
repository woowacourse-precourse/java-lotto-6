package lotto.model;

import java.util.List;

public class WinningLotto {
    private Lotto lotto;
    private Integer bonusNumber;

    public WinningLotto(List<Integer> numbers, Integer bonusNumber){
        this.lotto = new Lotto(numbers);
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
