package lotto.Model;

import static lotto.Model.Lotto.MAX_LOTTO_NUMBER;
import static lotto.Model.Lotto.MIN_LOTTO_NUMBER;
import static lotto.Utils.toInt;

public class Bonus {
    public static final String ERROR_NOT_BONUS_NUMBER_FORMAT =
            String.format("[ERROR] 보너스 번호는 %d~%d사이의 숫자로만 입력해야 합니다.", MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);

    int bonusNumber;

    public Bonus(String input) {
        validate(input);
        this.bonusNumber = toInt(input);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(String input) throws IllegalArgumentException {
        int numberInput = validateNumber(input);
        validateNumberRange(numberInput);

    }

    private int validateNumber(String input) {
        try {
            return toInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_BONUS_NUMBER_FORMAT);
        }
    }

    private void validateNumberRange(int numberInput) {
        if (numberInput < MIN_LOTTO_NUMBER || numberInput > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ERROR_NOT_BONUS_NUMBER_FORMAT);
        }
    }
}
