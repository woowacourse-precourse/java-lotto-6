package lotto.Model;

import java.util.List;
import lotto.View.ExceptionMessage;
import lotto.Controller.InputController;
import lotto.View.OuputView;

public class BonusNumber {
    private final int bonus;
    public BonusNumber(int bonus, List<Integer> winningNumbers) {
        this.bonus = validate(bonus,winningNumbers);
    }
    public int getBonus(){
        return bonus;
    }
    private int validate (int bonus,List<Integer>winningNumbers){
        try {
            validateRange(bonus);
            checkForDuplicate(bonus,winningNumbers);
            return bonus;
        }catch (IllegalArgumentException e){
            OuputView.printErrorMessage(e.getMessage());
            int newBonus = InputController.inputBonusNumber();
            return validate(newBonus,winningNumbers);
        }
    }
    private void validateRange(int bonus){
        if(bonus < ExceptionMessage.MIN_NUM || bonus > ExceptionMessage.MAX_NUM ){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BONUS_NUMBER);
        }
    }
    public void checkForDuplicate(int bonus,List<Integer>winningNumbers) {
        if (isDuplicate(bonus,winningNumbers)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_BONUS_NUMBER);
        }
    }

    private boolean isDuplicate(int bonus,List<Integer>winningNumbers) {
        for (int number : winningNumbers) {
            if (number == bonus) {
                return true; // 중복 숫자 발견
            }
        }
        return false; // 중복 숫자 없음
    }
}
