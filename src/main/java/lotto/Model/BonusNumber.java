package lotto.Model;

import lotto.View.ExceptionMessage;
import lotto.View.InputVIew;

public class BonusNumber {
    private final int bonus;
    public BonusNumber(int bonus) {
        validate(bonus);
        this.bonus = bonus;
    }
    public int getBonus(){
        return bonus;
    }
    private void validate (int bonus){
        try {
            validateRange(bonus);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            InputVIew.inputBonusNumber();
        }
    }
    private void validateRange(int bonus){
        if(bonus < 0 || bonus > 45 ){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BONUS_NUMBER);
        }
    }
}
