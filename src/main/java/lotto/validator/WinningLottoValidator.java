package lotto.validator;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Win;

public class WinningLottoValidator {
    public static void validate(String winningLotto) {
        InputValidator.validateEmpty(winningLotto);
        validateDigit(winningLotto);
        validateLotto(winningLotto);
    }

    private static void validateLotto(String winningLotto) {
        Win win = new Win();
        new Lotto(win.stringToList(winningLotto));
    }

    private static void validateDigit(String winningLotto) {
        List<String> winningNumbers = List.of(winningLotto.split(","));

        for (String number : winningNumbers) {
            InputValidator.validateDigit(number);
        }
    }
}
