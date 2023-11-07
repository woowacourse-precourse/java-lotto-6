package lotto.exception;

import java.util.List;

public class LottoNumberException {
    private static final int SIX_INPUT = 6;
    private static final String BLANK = "빈 값은 입력할 수 없습니다.";
    private static final String END_WITH_NUMBER = "6개의 숫자를 입력해 주세요.";
    private static final String INSUFFICIENT_LOTTO_NUMBER = "당첨 번호 6개를 모두 입력해 주세요.";
    private static final String NOT_LOTTO_NUMBER = "로또 번호는 1~45사이의 숫자만 가능 합니다.";
    private static final String DUPLICATE_NUMBER = "당첨 번호는 중복 되지 않아야 합니다.";

    public void checkBlank(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(BLANK);
        }
    }

    public void checkLottoNumber(String input) {
        int number = Integer.parseInt(input);

        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(NOT_LOTTO_NUMBER);
        }
    }

    public void checkEndWithNumber(String input) {
        int length = input.length();
        char lastNumber = input.charAt(length - 1);

        if (lastNumber < '0' || lastNumber > '9') {
            throw new IllegalArgumentException(END_WITH_NUMBER);
        }
    }

    public void checkSixInputs(List<String> inputs) {
        if (inputs.size() != SIX_INPUT) {
            throw new IllegalArgumentException(INSUFFICIENT_LOTTO_NUMBER);
        }
    }

    public void checkInteger(String number) {
        for (int index = 0; index < number.length(); index++) {
            if (number.charAt(index) < '0' || number.charAt(index) > '9') {
                throw new IllegalArgumentException(NOT_LOTTO_NUMBER);
            }
        }
    }

    public void checkSixNumbers(List<String> inputs) {
        for (String input : inputs) {
            checkInteger(input.trim());
            checkLottoNumber(input.trim());
        }
    }

    private boolean isDuplicate(int currentIndex, List<String> numbers) {
        String currentNumber = numbers.get(currentIndex);

        for (int index = currentIndex + 1; index < numbers.size(); index++) {
            if (currentNumber.equals(numbers.get(index))) {
                return true;
            }
        }

        return false;
    }

    public void checkDuplicate(List<String> numbers) {
        for (int index = 0; index < numbers.size() - 1; index++) {
            if (isDuplicate(index, numbers)) {
                throw new IllegalArgumentException(DUPLICATE_NUMBER);
            }
        }
    }
}
