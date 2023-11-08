package lotto.validator;

import java.util.List;
import lotto.domain.LottoProperty;
import lotto.exception.EmptyInputException;
import lotto.exception.EmptySpaceIncludeException;
import lotto.exception.NotIntegerInputException;
import lotto.exception.OutOfLengthException;
import util.string.StringUtils;

public class InputValidator {
    private static final String EMPTY_SPACE = " ";

    private InputValidator() {
    }

    public static void checkPriceInput(String input) throws IllegalArgumentException {
        checkEmptyAndThrowException(input);
        checkSpaceAndThrowException(input);
        checkIntegerInputAndThrowException(input);
    }

    public static void checkWinningLottoInput(String input) throws IllegalArgumentException {
        checkEmptyAndThrowException(input);
        checkSpaceAndThrowException(input);
        checkLastIndexAndThrowException(input);
        List<Integer> numbers = StringUtils.parseLottoNumber(input);
        checkLottoLengthAndThrowException(numbers);
    }

    public static void checkBonusInput(String input)
            throws IllegalArgumentException {
        checkEmptyAndThrowException(input);
        checkSpaceAndThrowException(input);
        checkIntegerInputAndThrowException(input);
    }


    private static void checkLottoLengthAndThrowException(List<Integer> carNameList) throws IllegalArgumentException {
        if (LottoProperty.LOTTO_DIGIT_RESTRICTIONS.getNumber() != carNameList.size()) {
            throw new OutOfLengthException();
        }
    }

    private static void checkLastIndexAndThrowException(String input) throws IllegalArgumentException {
        if (input.lastIndexOf(",") == input.length() - 1) {
            throw new OutOfLengthException();
        }
    }

    private static void checkIntegerInputAndThrowException(String input) throws IllegalArgumentException {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException error) {
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
