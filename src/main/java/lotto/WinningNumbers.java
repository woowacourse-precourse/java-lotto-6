package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class WinningNumbers {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningNumbers(String inputWinningLotto, String inputBonus) {
        validateInputLotto(inputWinningLotto);
        validateInputBonus(inputBonus);
        this.winningLotto = new Lotto(inputToNumbers(inputWinningLotto));
        this.bonusNumber = inputToNumber(inputBonus);
    }

    public List<Integer> getWinningLottoNumbers() {
        return this.winningLotto.getNumbers();
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    private void validateInputLotto(String inputLotto) {
        if (inputLotto.isEmpty() || inputLotto.equals(LINE_SEPARATION)) {
            throw new IllegalArgumentException();
        }
        if (inputLotto.contains(BLANK)) {
            throw new IllegalArgumentException();
        }
        if (!Pattern.matches("^[0-9,]+$", inputLotto)) {
            throw new IllegalArgumentException();
        }
        if (inputLotto.contains(COMMA + COMMA)) {
            throw new IllegalArgumentException();
        }
        if (Pattern.matches("^(,.*|.*,|,)$", inputLotto)) {
            throw new IllegalArgumentException();
        }
    }
}
