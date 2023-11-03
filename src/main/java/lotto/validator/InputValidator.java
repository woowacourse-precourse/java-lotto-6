package lotto.validator;

import java.util.List;
import lotto.Exception.InputErrorMessage;
import lotto.Pattern;
import lotto.Utils;

public class InputValidator {
    private final static int PRICE = 1000;
    private final static int MIN_LOTTO_NUMBER = 1;
    private final static int MAX_LOTTO_NUMBER = 45;

    public void validateMoney(int money) {
        int remainder = Utils.getRemainder(money, PRICE);

        if (remainder != 0) {
            throw new IllegalArgumentException(
                    InputErrorMessage.INVALID_UNIT.getValue()
            );
        }
    }

    /**
     * 리스트의 요소들이 중복없는 1~45범위의 숫자인지 확인
     *
     * @param numbers
     * @see InputValidator#validateDuplicatedNumber(List)
     * @see InputValidator#validateNumbersRange(List)
     */
    public void validateLottoNumber(List<Integer> numbers) {
        validateDuplicatedNumber(numbers);
        validateNumbersRange(numbers);
    }

    public void validateDuplicatedNumber(List<Integer> numbers) {
        if (Utils.hasDuplicates(numbers)) {
            throw new IllegalArgumentException(
                    InputErrorMessage.DUPLICATED_NUMBER.getValue()
            );
        }
    }

    public void validateHasOnlyIntegers(List<String> strings) {
        boolean isValid = strings.stream()
                .allMatch(string -> string.matches(Pattern.ONLY_INTEGERS.getValue()));

        if (!isValid) {
            throw new IllegalArgumentException(
                    InputErrorMessage.INVALID_LOTTO_NUMBERS.getValue()
            );
        }
    }

    public void validateNumbersRange(List<Integer> numbers) {
        boolean isValidRange = numbers.stream().allMatch(
                number -> number >= MIN_LOTTO_NUMBER && number <= MAX_LOTTO_NUMBER);

        if (!isValidRange) {
            throw new IllegalArgumentException(
                    InputErrorMessage.INVALID_NUMBER_RANGE.getValue()
            );
        }
    }

}
