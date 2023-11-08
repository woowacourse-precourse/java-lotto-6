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

    private List<Integer> getWinningNumbers() {
        List<Integer> winningNumbers = InputController.repeat(() -> inputAndValidateWinningNumbers());
        return winningNumbers;
    }

    private Integer getBonusNumber(List<Integer> winningNumbers) {
        Integer bonusNumber = InputController.repeat(() -> inputAndValidateBonusNumbers(winningNumbers));
        return bonusNumber;
    }

    private List<Integer> inputAndValidateWinningNumbers(){
        List<Integer> winningNumbers = InputController.inputWinningNumber();
        NumberValidator.validate(winningNumbers);

        return winningNumbers;
    }

    private Integer inputAndValidateBonusNumbers(List<Integer> winningNumbers){
        Integer bonusNumber = InputController.inputBonusNumber();
        NumberValidator.validate(bonusNumber,winningNumbers);

        return bonusNumber;
    }
}
