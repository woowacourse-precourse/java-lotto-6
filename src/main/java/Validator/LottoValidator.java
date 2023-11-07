package Validator;

import static Constant.ErrorMessage.ERROR_MSG_DUPLICATED_LOTTO_NUMBER;

import java.util.ArrayList;
import java.util.List;

public class LottoValidator {

    public static void checkDupilcatedNumber(List<Integer> value) throws IllegalArgumentException {
        List<Integer> testValue = new ArrayList<>(value);
        for (Integer oneValue : value) {
            testValue.remove(oneValue);
            if (testValue.contains(oneValue)) {
                throw new IllegalArgumentException(ERROR_MSG_DUPLICATED_LOTTO_NUMBER);
            }
        }
    }

}
