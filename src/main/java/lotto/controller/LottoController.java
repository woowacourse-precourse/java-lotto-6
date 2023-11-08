package lotto.controller;

import static lotto.util.Util.changeStringToInt;
import static lotto.validator.LottoInputValidator.validateBonusNumber;
import static lotto.validator.LottoInputValidator.validateBonusNumberNumeric;
import static lotto.validator.LottoInputValidator.validateBonusNumberRange;

import camp.nextstep.edu.missionutils.Console;
public class LottoController {
    public String inputWinningNumbers() {
        String winningNumbers = Console.readLine();
        return winningNumbers;
    }

    public int inputBonusNumber() {
        int bonusNumber = 0;
        boolean validInput = false;

        while(!validInput){
            try {
                String input = Console.readLine();
                validateBonusNumber(input);
                bonusNumber = changeStringToInt(input);
                validInput = true;
            } catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        } return bonusNumber;
    }
}
