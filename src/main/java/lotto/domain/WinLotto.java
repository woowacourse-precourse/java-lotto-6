package lotto.domain;

import java.util.List;

public class WinLotto extends Lotto{

    private final int bonusNumber;

    public WinLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validate(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public LottoPrize calculatePrize(Lotto lotto, int bonusNumber){
        //TODO 등수 계산
        return null;
    }

    public void validate(List<Integer> numbers, int bonusNumber){
        if(numbers.contains(bonusNumber))
            throw new IllegalArgumentException();
    }
}
