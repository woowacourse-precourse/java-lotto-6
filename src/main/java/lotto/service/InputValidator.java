package lotto.service;

import java.util.regex.Pattern;
import lotto.exception.InputDataNotNumberException;
import lotto.exception.LottoNumberIsOverRangeException;

public class InputValidator {

    private static final String NUMBER = "^[0-9]*$";

    public void validateInputDataIsNumber(String inputData) {
        if (!Pattern.matches(NUMBER, inputData)) {
            throw new InputDataNotNumberException();
        }
    }

    public void validateInputDataIsLottoRange(int inputData) {
        if (inputData < 1 || inputData > 45) {
            throw new LottoNumberIsOverRangeException();
        }
    }
}
