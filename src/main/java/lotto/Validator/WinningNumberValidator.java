package lotto.Validator;

import static lotto.config.ErrorMessage.INPUT_WINNING_CHARACTER_ERROR_MESSAGE;
import static lotto.config.ErrorMessage.INPUT_WINNING_NUMBER_SIZE_ERROR_MESSAGE;
import static lotto.config.LottoConfig.LOTTO_SIZE;

import java.util.List;

/**
 * 정답 번호를 검증하는 클래스
 */
public class WinningNumberValidator extends Validator<List<String>> {

    @Override
    public List<String> valid(List<String> input) {
        checkCount(input);
        checkEachStringInteger(input);

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
}
