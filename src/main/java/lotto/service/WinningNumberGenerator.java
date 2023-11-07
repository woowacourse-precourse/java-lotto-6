package lotto.service;

import java.util.List;
import lotto.controller.InputController;
import lotto.domain.WinningNumbers;
import lotto.exception.NumberValidator;

public class WinningNumberGenerator {

    public WinningNumbers generate() {
        List<Integer> winningNumbers = getWinningNumbers();
        Integer bonusNumber = getBonusNumber(winningNumbers);
        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    private Integer getBonusNumber(List<Integer> winningNumbers) {
        Integer bonusNumber;
        while(true){
            try{
                bonusNumber = InputController.inputBonusNumber();
                NumberValidator.validate(bonusNumber, winningNumbers);
                break;
            }catch(IllegalArgumentException e){}
        }
        return bonusNumber;
    }

    private List<Integer> getWinningNumbers() {
        List<Integer> winningNumbers;
        while(true){
            try{
                winningNumbers = InputController.inputWinningNumber();
                NumberValidator.validate(winningNumbers);
                break;
            }catch(IllegalArgumentException e){}
        }
        return winningNumbers;
    }
}
