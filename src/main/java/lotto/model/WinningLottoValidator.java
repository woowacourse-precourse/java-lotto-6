package lotto.model;

import java.util.List;
import lotto.utils.Utils;

public class WinningLottoValidator {
    public static void validateWinningLotto(String winningLotto) {
        isInteger(winningLotto);
    }

    private static void isInteger(String winningLotto) {
        List<String> winningNumbers = Utils.splitStringToList(winningLotto);

        if (winningNumbers.stream().anyMatch(number -> !number.matches("^[0-9]+$"))) {
            throw new IllegalArgumentException("[ERROR] 로또 넘버는 숫자여야 합니다.");
        }
    }
}
