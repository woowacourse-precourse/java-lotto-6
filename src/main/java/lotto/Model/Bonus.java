package lotto.Model;

import static lotto.Constants.MAX_LOTTO_NUMBER;
import static lotto.Constants.MIN_LOTTO_NUMBER;
import static lotto.Utils.toInt;

import java.util.List;

public class Bonus {
    public static final String ERROR_NOT_BONUS_NUMBER_FORMAT =
            String.format("[ERROR] 보너스 번호는 %d~%d사이의 숫자로만 입력해야 합니다.", MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
    public static final String ERROR_INVALID_BONUS = "[ERROR] 보너스 번호는 당첨 번호에 포함되면 안됩니다.";

    int bonusNumber;

    public Bonus(String input, WinningLotto winningLotto) {
        validate(input, winningLotto);
        this.bonusNumber = toInt(input);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(String input, WinningLotto winningLotto) throws IllegalArgumentException {
        int numberInput = validateNumber(input);
        validateNumberRange(numberInput);
        validateIncludingWinningLotto(numberInput, winningLotto);
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

    private void validateIncludingWinningLotto(int numberInput, WinningLotto winningLotto) {
        List<Integer> winningLottoNumbers = winningLotto.getWinningLotto().getNumbers();
        if (winningLottoNumbers.contains(numberInput)) {
            throw new IllegalArgumentException(ERROR_INVALID_BONUS);
        }
    }
}
