package lotto.util.validator;

public class LottoNumberValidator {
    public static void validateRange(int winningNumber) {
        if (!isInRange(winningNumber)) {
            throw new IllegalArgumentException("로또 숫자는 1~45 사이의 숫자여야합니다.");
        }
    }

    private static boolean isInRange(int winningNumber) {
        return winningNumber >= 1 && winningNumber <= 45;
    }
}
