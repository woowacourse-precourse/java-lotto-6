package lotto.bonus;

import lotto.lotto.LottoConstants;

public class BonusNumber {

    public static final String NOT_INTEGER_MESSAGE = "보너스 번호는 정수로 입력해야 합니다.";
    public static final String WRONG_RANGER_NUMBER_MESSAGE = "보너스 번호는 1 ~ 45여아 합니다.";
    private final Integer bonus;

    public BonusNumber(String bonus) {
        this.bonus = validate(bonus);
    }

    private Integer validate(String number) {
        Integer bonus = validateInteger(number);
        validateNumberRange(bonus);
        return bonus;
    }

    private Integer validateInteger(String bonus) {
        try {
            return Integer.valueOf(bonus);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER_MESSAGE);
        }
    }

    private void validateNumberRange(Integer bonus) {
        if (bonus < LottoConstants.MIN_LOTTO_NUMBER || bonus > LottoConstants.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(WRONG_RANGER_NUMBER_MESSAGE);
        }
    }
}
