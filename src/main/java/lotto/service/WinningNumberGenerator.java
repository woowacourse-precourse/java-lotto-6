package lotto.service;

import java.util.List;
import lotto.controller.InputController;
import lotto.domain.WinningNumbers;
import lotto.util.ErrorMessage;

public class WinningNumberGenerator {

    public WinningNumbers generate() {
        return new WinningNumbers(getWinningNumbers(), getBonusNumber());
    }

    private Integer getBonusNumber() {
        Integer bonusNumber;
        while(true){
            try{
                bonusNumber = inputBonusNumber();
            }catch(IllegalArgumentException e){
                continue;
            }
            break;
        }
        return bonusNumber;
    }

    private List<Integer> getWinningNumbers() {
        List<Integer> winningNumbers;
        while(true){
            try{
                winningNumbers = inputWinningNumber();
            }catch(IllegalArgumentException e){
                continue;
            }
            break;
        }
        return winningNumbers;
    }

    private List<Integer> inputWinningNumber() throws IllegalArgumentException {
        List<Integer> winningNumber;

        try {
            winningNumber = InputController.inputWinningNumber();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.valueOf(ErrorMessage.ERROR_INPUT_WINNING_NUMBER_MESSAGE));
        }
        return winningNumber;
    }

    private Integer inputBonusNumber() throws IllegalArgumentException {
        Integer bonusNumber = null;

        try {
            bonusNumber = InputController.inputBonusNumber();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.valueOf(ErrorMessage.ERROR_INPUT_BONUS_NUMBER_MESSAGE));
        }
        return bonusNumber;
    }
}
