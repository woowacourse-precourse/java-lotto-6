package lotto.exception;

import java.util.List;

public class LottoNumberException {
    private static final int SIX_INPUT = 6;
    private static final String INSUFFICIENT_LOTTO_NUMBER = "당첨 번호는 6개입니다.";
    private static final String NOT_NUMBER = "로또 번호는 1~45사이의 숫자만 가능합니다.";
    private static final String DUPLICATE_NUMBER = "당첨 번호는 중복되지 않아야 합니다.";

    public void checkSixInputs(List<String> inputs) {
        if (inputs.size() != SIX_INPUT) {
            throw new IllegalArgumentException(INSUFFICIENT_LOTTO_NUMBER);
        }
    }

    private boolean isNumber(String number) {
        for (int index = 0; index < number.length(); index++) {
            if (number.charAt(index) < '0' || number.charAt(index) > '9') {
                return false;
            }
        }

        return true;
    }

    public void checkSixNumbers(List<String> inputs) {
        for (String input : inputs) {
            if (!isNumber(input.trim())) {
                throw new IllegalArgumentException(NOT_NUMBER);
            }
        }
    }

    public void checkDuplicate(List<String> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i).equals(numbers.get(j))) {
                    throw new IllegalArgumentException(DUPLICATE_NUMBER);
                }
            }
        }
    }
}
