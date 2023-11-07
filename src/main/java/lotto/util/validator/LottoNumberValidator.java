package lotto.util.validator;

import java.util.List;

public class LottoNumberValidator {
    public static void validateRange(int winningNumber) {
        if (!isInRange(winningNumber)) {
            throw new IllegalArgumentException("로또 숫자는 1~45 사이의 숫자여야합니다.");
        }
    }

    private static boolean isInRange(int winningNumber) {
        return winningNumber >= 1 && winningNumber <= 45;
    }

    public static void validateDuplicates(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("입력한 당첨 번호와 중복되지 않는 보너스 번호를 입력해주세요.");
        }
    }
}
