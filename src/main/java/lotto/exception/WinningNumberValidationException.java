package lotto.exception;

import java.util.List;

public class WinningNumberValidationException extends IllegalArgumentException {

    public WinningNumberValidationException(String message) {
        super(message);
    }

    public static void checkLottoNumberFormat(String input) {
        String pattern = "^\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2}$";

        if (!input.matches(pattern)) {
            throw new WinningNumberValidationException("[ERROR] 로또 번호는 '1,2,3,4,5,6'과 같은 형식으로 입력해야 합니다.");
        }
    }

    public static void checkWinningNumberLength(List<Integer> winningNumber) {
        if (winningNumber.size() != 6) {
            throw new WinningNumberValidationException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public static void checkDuplicateWinningNumbers(List<Integer> winningNumber) {
        if (winningNumber.stream().distinct().count() != 6) {
            throw new WinningNumberValidationException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public static void checkBoundaryOfWinningNumbers(List<Integer> winningNumber) {
        if (winningNumber.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new WinningNumberValidationException("[ERROR] 로또 번호는 1~45 사이의 숫자만 가능합니다.");
        }
    }
}