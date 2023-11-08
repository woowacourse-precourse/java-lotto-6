package lotto.Validator;

import static lotto.config.ErrorMessage.INPUT_WINNING_CHARACTER_ERROR_MESSAGE;
import static lotto.config.ErrorMessage.INPUT_WINNING_FORMAT_ERROR_MESSAGE;
import static lotto.config.ErrorMessage.INPUT_WINNING_NUMBER_SIZE_ERROR_MESSAGE;
import static lotto.config.ErrorMessage.LOTTO_NUMBER_DUPLICATION_ERROR_MESSAGE;
import static lotto.config.ErrorMessage.LOTTO_NUMBER_ERROR_MESSAGE;
import static lotto.config.LottoConfig.LOTTO_SIZE;

import java.util.List;
import java.util.regex.Pattern;

/**
 * 정답 번호를 검증하는 클래스
 */
public class WinningNumberValidator extends Validator<List<String>> {

    @Override
    public List<String> valid(List<String> input) {
        checkCount(input);
        checkEachStringInteger(input);
        checkEachNumberValid(input);
        checkDuplicates(input);

        return input;
    }

    /**
     * 정답 번호의 입력 형식이 맞는지 검증
     * @param input 사용자가 입력한 정답 번호
     * @return 검증된 정답 번호
     */
    public static String vaildFormat(String input) {
        String regex = "^(\\d+),(\\d+),(\\d+),(\\d+),(\\d+),(\\d+)$";

        boolean isMatch = Pattern.matches(regex, input);

        if (!isMatch) {
            throw new IllegalArgumentException(INPUT_WINNING_FORMAT_ERROR_MESSAGE.getMessage());
        }
        return input;
    }

    private void checkCount(List<String> input) {
        if (input.size() != LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(INPUT_WINNING_NUMBER_SIZE_ERROR_MESSAGE.getMessage());
        }
    }

    private void checkEachStringInteger(List<String> input) {
        boolean allNumbers = input.stream().allMatch(super::isNumber);

        if (!allNumbers) {
            throw new IllegalArgumentException(INPUT_WINNING_CHARACTER_ERROR_MESSAGE.getMessage());
        }
    }

    private void checkEachNumberValid(List<String> input) {
        boolean allValidNumbers = input.stream()
                .map(this::toInteger)
                .allMatch(super::isLottoNumber);

        if (!allValidNumbers) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ERROR_MESSAGE.getMessage());
        }
    }

    private void checkDuplicates(List<String> input) {
        long distinctCount = input.stream().distinct().count();

        if (distinctCount < input.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATION_ERROR_MESSAGE.getMessage());
        }
    }

    private int toInteger(String input) {
        return Integer.parseInt(input);
    }
}
