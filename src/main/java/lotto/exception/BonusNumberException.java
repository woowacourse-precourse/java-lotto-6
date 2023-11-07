package lotto.exception;

import static lotto.type.ExceptionMessage.DUPLICATED_NUMBER;
import static lotto.type.ExceptionMessage.NOT_CONDITIONAL_NUMBER;
import static lotto.type.ExceptionMessage.NOT_NUMBER;

import java.util.List;
import lotto.Lotto;

public class BonusNumberException {

    public void validate(String bonusNumber, Lotto lotto) {
        word(bonusNumber);
        conditionalNumber(bonusNumber);
        duplicated(bonusNumber, lotto);
    }

    public void word(String bonusNumber) {
        int idx = 0;
        if (bonusNumber.equals("")) {
            throw new IllegalArgumentException(NOT_NUMBER.getMessage());
        }
        if (bonusNumber.charAt(idx) == '-') {
            idx++;
        }
        if (bonusNumber.charAt(idx) < 48 || bonusNumber.charAt(idx) > 57) {
            throw new IllegalArgumentException(NOT_NUMBER.getMessage());
        }
    }

    public void conditionalNumber(String bonusNumber) {
        if (Integer.parseInt(bonusNumber) < 1 || Integer.parseInt(bonusNumber) > 45) {
            throw new IllegalArgumentException(NOT_CONDITIONAL_NUMBER.getMessage());
        }
    }

    public void duplicated(String bonusNumber, Lotto winningLotto) {
        List<Integer> numbers = winningLotto.getNumbers();
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == Integer.parseInt(bonusNumber)) {
                throw new IllegalArgumentException(DUPLICATED_NUMBER.getMessage());
            }
        }
    }

}
