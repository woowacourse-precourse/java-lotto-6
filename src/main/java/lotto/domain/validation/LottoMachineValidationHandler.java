package lotto.domain.validation;

import static lotto.domain.constant.LottoConstant.MAX_RANGE;
import static lotto.domain.constant.LottoConstant.MIN_RANGE;
import static lotto.domain.validation.DefaultValidationMessage.*;

import java.util.Arrays;
import java.util.List;

public class LottoMachineValidationHandler {
    private static final int MIN_LOTTO_GENERATE_COUNT = 1;
    public static final String INVALID_LOTTO_GENERATE_COUNT_MESSAGE = ERROR.getMessage() + " 로또는 최소 1장 이상 발행할 수 있습니다.";
    public static final String INVALID_LOTTO_WINNING_NUMBER = ERROR.getMessage() + " 당첨 번호에 숫자가 아닌 문자가 있습니다.";
    public static final String INVALID_LOTTO_BONUS_NUMBER = ERROR.getMessage() + " 보너스 번호에 숫자가 아닌 문자가 있습니다.";
    public static final String INVALID_LOTTO_BONUS_NUMBER_RANGE = ERROR.getMessage() + " 1 ~ 45 사이의 보너스 번호가 아닙니다.";

    private LottoMachineValidationHandler() {
    }

    public static void validationMinGenerateLottoCount(int generateLottoCount) {
        if(!isMinGenerateLottoCount(generateLottoCount)) {
            throw new IllegalArgumentException(INVALID_LOTTO_GENERATE_COUNT_MESSAGE);
        }
    }

    public static void validationAllNumeric(List<String> winningNumbers) {
        if(!isAllNumeric(winningNumbers)) {
            throw new IllegalArgumentException(INVALID_LOTTO_WINNING_NUMBER);
        }
    }

    public static void validationNumeric(String bonusNumber) {
        if(!isNumeric(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_LOTTO_BONUS_NUMBER);
        }
    }

    public static void validationNumbersRange(Integer bonusNumber) {
        if(!isValidNumberRange(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_LOTTO_BONUS_NUMBER_RANGE);
        }
    }

    private static boolean isMinGenerateLottoCount(int generateLottoCount) {
        return generateLottoCount >= MIN_LOTTO_GENERATE_COUNT;
    }

    private static boolean isAllNumeric(List<String> winningNumbers) {
        return winningNumbers.stream().allMatch(winningNumber -> winningNumber.chars().allMatch(Character::isDigit));
    }

    private static boolean isNumeric(String bonsNumber) {
        return bonsNumber.chars().allMatch(Character::isDigit);
    }

    private static boolean isValidNumberRange(Integer bonsNumber) {
        return bonsNumber >= MIN_RANGE && bonsNumber <= MAX_RANGE;
    }
}
