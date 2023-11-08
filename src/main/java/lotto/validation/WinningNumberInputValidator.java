package lotto.validation;

import lotto.model.Lotto;
import lotto.model.WinningLotto;

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
        return (1 <= oneLottoNumber && oneLottoNumber <= 45);
    }

    public boolean isWinningLottoNotDuplication(WinningLotto winningNumber) {
        Lotto winningLotto = winningNumber.getWinningNumber();
        int bonusNumber = winningNumber.getBonusNumber();

        if (winningLotto.contains(bonusNumber)) {
            return false;
        }
        return true;
    }
}
