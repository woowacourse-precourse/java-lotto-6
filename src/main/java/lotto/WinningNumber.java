package lotto;

import lotto.util.Validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumber extends Lotto{
    private final int bonusNumber;
    private final Set<Integer> numSet;
    public WinningNumber(List<Integer> numbers, int bonusNumber){
        super(numbers);
        Validator.validateIfContains(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
        this.numSet = new HashSet<>(numbers);
    }
    public boolean hasNumber(int number){
        return this.numSet.contains(number);
    }
    public int getBonusNumber(){
        return this.bonusNumber;
    }
}
