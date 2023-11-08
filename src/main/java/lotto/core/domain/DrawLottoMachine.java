package lotto.core.domain;

import lotto.common.console.Input;
import lotto.common.console.Output;
import lotto.common.exception.ErrorType;
import lotto.common.exception.LottoGameException;

import java.util.List;

public class DrawLottoMachine {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public DrawLottoMachine(Lotto winningLotto) {
        this.winningLotto = winningLotto;
        this.bonusNumber = readBonusNumber();
    }
    private int readBonusNumber() {
        String bonusNumber;

        do {
            bonusNumber = Input.readBonusNumber();
        } while (!isValidBonusNumber(bonusNumber));

        return Integer.parseInt(bonusNumber);
    }

    private boolean isValidBonusNumber(String bonusNumberInput) {
        try {
            int bonusNumber = convertNumber(bonusNumberInput);
            validateNumberRange(bonusNumber);
            validateBonusNumber(bonusNumber);
            return true;
        } catch (IllegalArgumentException e) {
            Output.writeMessage(e.getMessage());
            return false;
        }
    }

    private int convertNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (Exception e) {
            throw LottoGameException.withType(ErrorType.INVALID_NUMBERS);
        }
    }

    private void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
           throw LottoGameException.withType(ErrorType.INVALID_NUMBERS);
        }
    }

    private void validateBonusNumber(int bonusNumber) {
        List<Integer> lottoNumbers = this.winningLotto.getNumbers();

        if (lottoNumbers.contains(bonusNumber)) {
            throw LottoGameException.withType(ErrorType.DUPLICATE_NUMBERS);
        }
    }
}
