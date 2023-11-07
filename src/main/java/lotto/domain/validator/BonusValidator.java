package lotto.domain.validator;

import java.util.List;

public class BonusValidator {
    private static final Integer MIN_NUMBER = 0;
    private static final Integer MAX_NUMBER = 45;
    private static final String MESSAGE_DUPLICATE_ERROR = "[ERROR]: 로또 번호와 중복된 번호를 제외해주세요.";
    private static final String MESSAGE_RANGE_ERROR = "[ERROR]: 1 ~ 45 사이의 숫자만 입력해주세요.";

    private List<Integer> lotto;
    public BonusValidator(Integer number, List<Integer> lotto) {
        this.lotto = lotto;
        validateDuplicate(number, lotto);
        validateRange(number);
    }

    private void validateDuplicate(Integer number, List<Integer> lotto) {
        if (lotto.contains(number)) {
            throw new IllegalArgumentException(MESSAGE_DUPLICATE_ERROR);
        }
    }

    private void validateRange(Integer number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(MESSAGE_RANGE_ERROR);
        }
    }
}
