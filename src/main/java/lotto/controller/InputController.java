package lotto.controller;

import java.util.List;
import lotto.model.validation.BonusNumberValidation;
import lotto.model.validation.InputLottoValidation;
import lotto.view.InputView;

public class InputController {

    public static int inputValidPlayerAmount() {
        while (true) {
            try {
                String inputMoney = InputView.inputLottoMoney();
                int validatedAmount = InputLottoValidation.validateInput(inputMoney);
                return new InputLottoValidation(validatedAmount).calculateLottoCount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> inputWinningNumbers() {
        while (true) {
            try {
                return InputView.inputLottoWinningNum();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int inputBonusNum(List<Integer> winningNumbers) {
        while (true) {
            try {
                String bonusNumberStr = InputView.inputBonusNumber();
                BonusNumberValidation bonusNumberValidation = new BonusNumberValidation(bonusNumberStr, winningNumbers);
                return bonusNumberValidation.getBonusNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
