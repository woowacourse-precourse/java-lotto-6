package lotto.validation;

import lotto.domain.WinningNumber;

public class WinningNumberInputValidator {

    public boolean isCommaFive(String winningNumberInput) {
        int commaCount = 0;
        for (int i = 0; i < winningNumberInput.length(); i++) {
            char oneCharacter = winningNumberInput.charAt(i);
            if (oneCharacter == ',') {
                commaCount++;
            }
        }
        return commaCount == 5;
    }

    public boolean isLottoNumber(int oneLottoNumber) {
        return false;
    }

    public boolean isLottoNumberDuplication(WinningNumber winningNumber) {
        return false;
    }
}
