package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.exception.ErrorMessage.BLANK_STRING_EXCEPTION;
import static lotto.exception.ErrorMessage.EMPTY_STRING_EXCEPTION;
import static lotto.exception.ErrorMessage.INPUT_STRING_NOT_LOTTO_NUMBER;
import static lotto.exception.ErrorMessage.INPUT_STRING_NOT_NUMBER;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import lotto.exception.LottoGameException;


public class InputView {
    public static final String NUMBER_REGEX = "(-)?\\d+";
    public static final String LOTTO_NUMBER_STRING_REGEX = "((\\d)+,)*\\d+";
    public static final String LOTTO_NUMBER_DELIMITER = ",";

    public static int inputMoney() {
        return inputNumber();
    }

    public static List<Integer> inputWinningLottoNumber() {
        String inputString = readNotEmptyLine();

        validateInputStringNotBlank(inputString);
        validateInputStringIsLottoNumber(inputString);

        return Arrays.stream(inputString.split(LOTTO_NUMBER_DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }

    public static int inputBonusNumber() {
        return inputNumber();
    }

    private static String readNotEmptyLine() {
        try {
            return readLine();
        } catch (NoSuchElementException ignore) {
            throw LottoGameException.of(EMPTY_STRING_EXCEPTION);
        }
    }

    private static int inputNumber() {
        String inputString = readNotEmptyLine();

        validateInputString(inputString);
        validateInputStringIsNumber(inputString);

        return Integer.parseInt(inputString);
    }

    private static void validateInputString(String inputString) {
        validateInputStringNotEmpty(inputString);
        validateInputStringNotBlank(inputString);
    }

    private static void validateInputStringNotEmpty(String inputString) {
        if (inputString.isEmpty()) {
            throw LottoGameException.of(EMPTY_STRING_EXCEPTION);
        }
    }

    private static void validateInputStringNotBlank(String inputString) {
        if (inputString.isBlank()) {
            throw LottoGameException.of(BLANK_STRING_EXCEPTION);
        }
    }

    private static void validateInputStringIsNumber(String inputString) {
        if (!inputString.matches(NUMBER_REGEX)) {
            throw LottoGameException.of(INPUT_STRING_NOT_NUMBER);
        }
    }

    private static void validateInputStringIsLottoNumber(String inputString) {
        if (!inputString.matches(LOTTO_NUMBER_STRING_REGEX)) {
            throw LottoGameException.of(INPUT_STRING_NOT_LOTTO_NUMBER);
        }
    }

}
