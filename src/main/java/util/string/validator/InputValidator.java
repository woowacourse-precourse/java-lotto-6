package util.string.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.DuplicatedLottoNumberException;
import lotto.exception.EmptyInputException;
import lotto.exception.EmptySpaceIncludeException;
import lotto.exception.NotIntegerInputException;
import lotto.exception.OutOfLengthException;
import lotto.exception.OutOfNumberRangeException;
import util.string.StringUtils;

public class InputValidator {
    private static final String EMPTY_SPACE = " ";
    private static final int LOTTO_DIGIT_RESTRICTIONS = 6;

    private static final int LOTTO_NUMBER_MIN_RANGE = 1;
    private static final int LOTTO_NUMBER_MAX_RANGE = 45;

    private InputValidator() {
    }

    public static void checkPriceInput(String input) throws IllegalArgumentException {
        checkEmptyAndThrowException(input);
        checkSpaceAndThrowException(input);
        checkIntegerInputAndThrowException(input);
    }

    public static void checkWinningLottoInput(String input) throws IllegalArgumentException {
        checkEmptyAndThrowException(input);
        checkLastIndexAndThrowException(input);
        List<Integer> numbers = StringUtils.parseLottoNumber(input);
        checkLottoLengthAndThrowException(numbers);
        checkLottoNumberDuplicatedAndThrowException(numbers);
        checkLottoNumberRangeAndThrowException(numbers);
    }

    private static void checkLottoNumberRangeAndThrowException(List<Integer> numbers) {
        for (int x : numbers) {
            if (x > LOTTO_NUMBER_MAX_RANGE || x < LOTTO_NUMBER_MIN_RANGE) {
                throw new OutOfNumberRangeException();
            }
        }
    }

    private static void checkLottoNumberDuplicatedAndThrowException(List<Integer> carNameList) {
        Set<Integer> set = new HashSet<>(carNameList);
        if (set.size() != carNameList.size()) {
            throw new DuplicatedLottoNumberException();
        }
    }

    private static void checkLottoLengthAndThrowException(List<Integer> carNameList) {
        if (LOTTO_DIGIT_RESTRICTIONS != carNameList.size()) {
            throw new OutOfLengthException();
        }
    }

    private static void checkLastIndexAndThrowException(String input) {
        if (input.lastIndexOf(",") == input.length() - 1) {
            throw new OutOfLengthException();
        }
    }

    private static void checkIntegerInputAndThrowException(String input) throws IllegalArgumentException {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NotIntegerInputException();
        }
    }

    private static void checkEmptyAndThrowException(String input) throws IllegalArgumentException {
        if (input.isEmpty()) {
            throw new EmptyInputException();
        }
    }

    private static void checkSpaceAndThrowException(String input) throws IllegalArgumentException {
        if (input.contains(EMPTY_SPACE)) {
            throw new EmptySpaceIncludeException();
        }
    }
}
