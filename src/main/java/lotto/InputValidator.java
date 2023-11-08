package lotto;

import java.util.HashSet;
import java.util.List;

public class InputValidator {
    public static final int WINNING_NUMBER_SIZE = 6;
    public static final int MIN_WINNING_NUMBER = 1;
    public static final int MAX_WINNING_NUMBER = 45;

    public static final String MONEY_1000_UNIT_ERROR = "[ERROR] 로또 구입금액은 1,000원 단위여야 합니다.\n";
    public static final String WINNING_NUMBER_SIZE_ERROR = "[ERROR] 당첨 번호는 6자리여야 합니다.";
    public static final String WINNING_NUMBER_DUPLICATE_ERROR = "[ERROR] 당첨 번호는 서로 중복되지 않아야 합니다.";
    public static final String WINNING_NUMBER_RANGE_ERROR = "[ERROR] 당첨 번호의 범위는 1~45여야 합니다.";
    public static final String WINNING_NUMBER_WHITE_SPACE_ERROR = "[ERROR] 당첨 번호는 공백이 포함되지 않아야 합니다.";
    public static final String WINNING_NUMBER_INVALID_ERROR = "[ERROR] 당첨 번호는 모두 숫자여야 합니다.";

    public static void checkDivisibleBy1000(int moneyInput) {
        if (moneyInput % 1000 != 0) {
            throw new IllegalArgumentException(MONEY_1000_UNIT_ERROR);
        }
    }

    public static void checkWinningNumbers(List<Integer> winningLottoNumbers, int specifiedSize) {
        if (winningLottoNumbers.size() != WINNING_NUMBER_SIZE) {
            throw new IllegalArgumentException(WINNING_NUMBER_SIZE_ERROR);
        }

        HashSet<Integer> set = new HashSet<>(winningLottoNumbers);
        if (set.size() != winningLottoNumbers.size()) {
            throw new IllegalArgumentException(WINNING_NUMBER_DUPLICATE_ERROR);
        }

        for (int number : winningLottoNumbers) {
            if (number < MIN_WINNING_NUMBER || number > MAX_WINNING_NUMBER) {
                throw new IllegalArgumentException(WINNING_NUMBER_RANGE_ERROR);
            }
        }
    }

    public static void checkValidInput(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException(WINNING_NUMBER_WHITE_SPACE_ERROR);
        }
        if (!input.matches("\\s*\\d+([\\s,]+\\d+)*\\s*")) {
            throw new IllegalArgumentException(WINNING_NUMBER_INVALID_ERROR);
        }
    }
}
