package lotto.model;

import static lotto.utils.Constants.INTEGER_RANGE;

import java.util.List;
import lotto.utils.Utils;

public class WinningLottoValidator {
    public static void validateWinningLotto(String winningLotto) {
        isInteger(winningLotto);
    }

    private static void isInteger(String winningLotto) {
        List<String> winningNumbers = Utils.splitStringToList(winningLotto);

        if (winningNumbers.stream().anyMatch(number -> !number.matches(INTEGER_RANGE))) {
            throw new IllegalArgumentException("[ERROR] 로또 넘버는 숫자여야 합니다.");
        }
    }
}
