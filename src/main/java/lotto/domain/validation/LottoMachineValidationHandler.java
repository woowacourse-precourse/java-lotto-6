package lotto.domain.validation;

import static lotto.domain.validation.DefaultValidationMessage.*;

import java.util.List;

public class LottoMachineValidationHandler {
    private static final int MIN_LOTTO_GENERATE_COUNT = 1;
    public static final String INVALID_LOTTO_GENERATE_COUNT_MESSAGE = ERROR.getMessage() + " 로또는 최소 1장 이상 발행할 수 있습니다.";
    public static final String INVALID_LOTTO_WINNING_NUMBER = ERROR.getMessage() + " 당첨 번호에 숫자가 아닌 문자가 있습니다.";

    private LottoMachineValidationHandler() {
    }

    public static void validationMinGenerateLottoCount(int generateLottoCount) {
        if(!isMinGenerateLottoCount(generateLottoCount)) {
            throw new IllegalArgumentException(INVALID_LOTTO_GENERATE_COUNT_MESSAGE);
        }
    }

    public static void validationAllNumeric(List<String> bonusNumbers) {
        if(!isAllNumeric(bonusNumbers)) {
            throw new IllegalArgumentException(INVALID_LOTTO_WINNING_NUMBER);
        }
    }

    private static boolean isMinGenerateLottoCount(int generateLottoCount) {
        return generateLottoCount >= MIN_LOTTO_GENERATE_COUNT;
    }

    private static boolean isAllNumeric(List<String> bonusNumbers) {
        return bonusNumbers.stream().allMatch(bonusNumber -> bonusNumber.chars().allMatch(Character::isDigit));
    }
}
