package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto {


    private final Integer bonusNumber;


    public WinningLotto(final List<Integer> numbers, final Integer bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(List<Integer> numbers, Integer bonusNumber) {
        return new WinningLotto(numbers, bonusNumber);
    }
    
    public List<Integer> getWinningLottoNumbers() {
        return this.getNumbers();
    }

    public Integer getBonusNumber() {
        return this.bonusNumber;
    }
}
