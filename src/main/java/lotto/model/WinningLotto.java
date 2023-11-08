package lotto.model;

import java.util.List;

public class WinningLotto extends Lotto{

    private final int bonusNumber;

    private WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(List<Integer> numbers, int bonusNumber){
        return new WinningLotto(numbers, bonusNumber);
    }

    @Override
    public boolean contains(int num) {
        if (super.contains(num)){
            return true;
        }

        if(isBonusNumber(num)){
            return true;
        }

        return false;
    }

    public boolean isBonusNumber(int isBonusNumber){
        return bonusNumber == isBonusNumber;
    }


}
