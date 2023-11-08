package lotto.validation;

import lotto.domain.Lotto;
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
        return (1 <= oneLottoNumber && oneLottoNumber <= 45);
    }

    public boolean isLottoNumberNotDuplication(Lotto lotto) {
        for (int i = 0; i < lotto.size(); i++) {
            int oneNumber = lotto.get(i);
            if (lotto.contains(oneNumber)) {
                return false;
            }
        }
        return true;
    }

    public boolean isWinningLottoNotDuplication(WinningNumber winningNumber) {
        Lotto winningLotto = winningNumber.getWinningNumber();
        int bonusNumber = winningNumber.getBonusNumber();
        if (!isLottoNumberNotDuplication(winningLotto)) {
            return false;
        }

        if (winningLotto.contains(bonusNumber)) {
            return false;
        }
        return true;
    }
}
