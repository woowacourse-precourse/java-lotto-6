package lotto.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputWinningNumbersValidator {
    private static final String NON_INPUT_ERROR_MESSAGE = "[ERROR] 입력하지 않으셨습니다. 당첨 번호를 입력해주세요";
    private static final String NON_NUMBER_SIZE_SIX_ERROR_MESSAGE = "[ERROR] 당첨번호는 6개로 입력해주세요 .";
    private static final String WRONG_RANGE_ERROR_MESSAGE = "[ERROR] 당첨 번호는 1부터 45 사이의 정수입니다.";
    private static final String NUMBER_DUPLICATE_ERROR_MESSAGE = "[ERROR] 당첨 번호는 중복될 수 없습니다.";
    private static final String NON_COMMA_ERROR_MESSAGE = "[ERROR] 당첨 번호는 쉼표(,)로 구분해주세요.";
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int WINNING_NUMBERS_SIZE = 6;
    private static final String[] inputMark = {".", "/", "-", "&", "_"};
    private static final String BLANK = "";
    private static final String COMMA = ",";

    public void validateNonInputWinningNumbers(String winningNumbers) {
        if (winningNumbers.equals(BLANK)) {
            throw new IllegalArgumentException(NON_INPUT_ERROR_MESSAGE);
        }
    }

    public void validateNonNumberSizeSix(String winningNumbers) {
        List<Integer> winningNumber = Arrays.stream(winningNumbers.split(COMMA))
                .map(Integer::parseInt)
                .toList();

        if (winningNumber.size() != WINNING_NUMBERS_SIZE) {
            throw new IllegalArgumentException(NON_NUMBER_SIZE_SIX_ERROR_MESSAGE);
        }
    }

    public void validateWrongRangeWinningNumbers(String winningNumbers) {
        List<Integer> winningNumber = Arrays.stream(winningNumbers.split(COMMA))
                .map(Integer::parseInt)
                .toList();

        for (int number : winningNumber) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(WRONG_RANGE_ERROR_MESSAGE);
            }
        }
    }

    public void validateDuplicateWinningNumbers(String winningNumbers) {
        List<Integer> winningNumber = Arrays.stream(winningNumbers.split(COMMA))
                .map(Integer::parseInt)
                .toList();
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumber);

        if (uniqueNumbers.size() != winningNumber.size()) {
            throw new IllegalArgumentException(NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
    }

    public void validateNonCommaWinningNumbers(String winningNumbers) {
        for (String mark : inputMark) {
            if (winningNumbers.contains(mark)) {
                throw new IllegalArgumentException(NON_COMMA_ERROR_MESSAGE);
            }
        }
    }
}
