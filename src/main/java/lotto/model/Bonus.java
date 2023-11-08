package lotto.model;

import lotto.constant.Number;
import lotto.constant.ValidatorMessage;

public class Bonus {
    private final Integer number;

    public Bonus(String bonusNumber, Lotto winLotto) {
        int tempNumber = convertStringToInteger(bonusNumber);

        validate(tempNumber, winLotto);

        this.number = Integer.valueOf(tempNumber);
    }

    public Bonus(int number, Lotto winLotto) {
        validate(number, winLotto);

        this.number = Integer.valueOf(number);
    }

    public boolean matchBonus(Lotto lotto) {
        return lotto.contains(number);
    }

    /**
     * String -> int Type Cast
     * <p>
     * Bonus Class 생성자는 String, Int 2개로 받으며 String 생성자 생성 시 Integer Type Cast 진행 Type Cast 시 숫자가 아닌 경우 Exception 발생
     *
     * @param bonusNumber
     * @return int type
     */
    private int convertStringToInteger(String bonusNumber) {
        validateIsNumeric(bonusNumber);

        return Integer.parseInt(bonusNumber);
    }

    public void validate(Integer number, Lotto winLotto) {
        validateIsNull(number);
        validateNumberRange(number);
        validateContainsWinLotto(number, winLotto);
    }

    private void validateIsNull(Integer number) {
        if (number == null) {
            throw new IllegalArgumentException(ValidatorMessage.INVALID_IS_NULL);
        }
    }

    private void validateNumberRange(int number) {
        if (!(number >= Number.MIN_NUMBER && number <= Number.MAX_NUMBER)) {
            throw new IllegalArgumentException(ValidatorMessage.INVALID_BONUS_RANGE);
        }
    }

    private void validateContainsWinLotto(Integer number, Lotto lotto) {
        if (lotto.contains(number)) {
            throw new IllegalArgumentException(ValidatorMessage.INVALID_BONUS_DUPLICATE_WIN_LOTTO);
        }
    }

    private void validateIsNumeric(String number) {
        if (!number.matches("^\\d+$")) {
            throw new IllegalArgumentException(ValidatorMessage.INVALID_INPUT_NUMERIC);
        }
    }
}
