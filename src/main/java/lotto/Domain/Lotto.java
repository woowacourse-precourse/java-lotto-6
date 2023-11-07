package lotto.Domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Constant.Constant;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(String inputNumbers) {
        List<Integer> numbers = validate(inputNumbers);
        this.numbers = numbers;
    }

    private List<Integer> validate(String inputNumbers) {
        List<Integer> validateNumbers = new ArrayList<>();
        lottoSizeValidate(inputNumbers);
        isNumber(inputNumbers);
        return validateNumbers;
    }

    //입력값이 6개인지 확인
    private void lottoSizeValidate(String inputNumbers) {
        String[] splitNumbers = stringToArray(inputNumbers);
        if (splitNumbers.length != Constant.LOTTO_LENGTH) {
            throw new IllegalArgumentException(
                    Constant.ERROR_PREFIX + Constant.USER_NUMBER_PREFIX + Constant.ERROR_NOT_COUNT_MESSAGE);
        }
    }

    //숫자값인지 확인
    private void isNumber(String inputNumbers) {
        String[] splitNumbers = stringToArray(inputNumbers);
        for (String splitNumber : splitNumbers) {
            if (!splitNumber.matches(Constant.NUMBER_PATTERN)) {
                throw new IllegalArgumentException(
                        Constant.ERROR_PREFIX + Constant.USER_NUMBER_PREFIX + Constant.ERROR_NOT_NUMBER_MESSAGE);
            }
        }
    }

    private String[] stringToArray(String inputNumbers) {
        return inputNumbers.split(",");
    }
}
