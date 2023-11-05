package lotto.view.validator;

import static lotto.config.GameNumberConfig.LOTTO_NUMBER_COUNT;
import static lotto.config.GameNumberConfig.LOTTO_RANGE_MAX;
import static lotto.config.GameNumberConfig.LOTTO_RANGE_MIN;
import static lotto.exception.ErrorMessage.VALIDATE_DUPLICATE;
import static lotto.exception.ErrorMessage.VALIDATE_LOTTO_SIZE;
import static lotto.exception.ErrorMessage.VALIDATE_LOTTO_SORT;
import static lotto.exception.ErrorMessage.VALIDATE_RANGE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.util.Parser;
import lotto.view.OutputView;

public class LottoNumberValidator {
    private LottoNumberValidator() {
    }

    public static boolean validateLottoNumber(String input) {
        try {
            InputValidator.checkEmpty(input);
            List<Integer> numbers = parseLottoNumber(input);
            checkSize(numbers);
            checkSort(numbers);
            checkDuplicate(numbers);
            checkRange(numbers);
            return true;
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return false;
        }
    }

    public static List<Integer> parseLottoNumber(String input) {
        List<String> splitInput = Parser.splitBySeparator(input);
        List<Integer> numbers =  splitInput.stream()
                .map(Parser::parseInt)
                .toList();
        return Parser.sortList(numbers);
    }

    private static void checkSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT.getNumber()) {
            throw new IllegalArgumentException(VALIDATE_LOTTO_SIZE.getMessage());
        }
    }

    private static void checkSort(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        if (!numbers.equals(sortedNumbers)) {
            throw new IllegalArgumentException(VALIDATE_LOTTO_SORT.getMessage());
        }
    }

    private static void checkDuplicate(List<Integer> numbers) {
        long distinctCount = numbers.stream()
                .distinct()
                .count();
        if (numbers.size() > distinctCount) {
            throw new IllegalArgumentException(VALIDATE_DUPLICATE.getMessage());
        }
    }

    private static void checkRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number > LOTTO_RANGE_MAX.getNumber() || number < LOTTO_RANGE_MIN.getNumber()) {
                throw new IllegalArgumentException(VALIDATE_RANGE.getMessage());
            }
        }
    }

}
