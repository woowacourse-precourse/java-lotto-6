package lotto.service;

import java.util.List;
import lotto.controller.InputController;
import lotto.domain.WinningNumbers;
import lotto.exception.NumberValidator;
import lotto.util.ErrorMessage;

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
                bonusNumber = inputBonusNumber();
                NumberValidator.validate(bonusNumber, winningNumbers);
                break;
            }catch(IllegalArgumentException e){            }
        }
        return bonusNumber;
    }

    private List<Integer> getWinningNumbers() {
        List<Integer> winningNumbers;
        while(true){
            try{
                winningNumbers = inputWinningNumber();
                NumberValidator.validate(winningNumbers);
                break;
            }catch(IllegalArgumentException e){}
        }
        return winningNumbers;
    }

    private List<Integer> inputWinningNumber() throws IllegalArgumentException {
        List<Integer> winningNumber;

        try {
            winningNumber = InputController.inputWinningNumber();
        } catch (NumberFormatException e) {
            System.out.println(ErrorMessage.ERROR_INPUT_NOT_NUMBER_MESSAGE);
            throw new IllegalArgumentException();
        }
        return winningNumber;
    }

    private Integer inputBonusNumber() throws IllegalArgumentException {
        Integer bonusNumber = null;

        try {
            bonusNumber = InputController.inputBonusNumber();
        } catch (NumberFormatException e) {
            System.out.println(ErrorMessage.ERROR_INPUT_NOT_NUMBER_MESSAGE);
            throw new IllegalArgumentException();
        }
        return bonusNumber;
    }
}
