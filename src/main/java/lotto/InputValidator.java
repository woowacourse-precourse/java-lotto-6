package lotto;

import java.util.HashSet;
import java.util.List;

public class InputValidator {
    public static final int WINNING_NUMBER_SIZE = 6;
    public static final int MIN_INPUT_NUMBER = 1;
    public static final int MAX_INPUT_NUMBER = 45;

    public static final String MONEY_1000_UNIT_ERROR = "[ERROR] 로또 구입금액은 1,000원 단위여야 합니다.\n";
    public static final String WINNING_NUMBER_SIZE_ERROR = "[ERROR] 당첨 번호는 6자리여야 합니다.";
    public static final String WINNING_NUMBER_DUPLICATE_ERROR = "[ERROR] 당첨 번호는 서로 중복되지 않아야 합니다.";
    public static final String INPUT_NUMBER_RANGE_ERROR = "[ERROR] 번호의 범위는 1~45여야 합니다.";
    public static final String WINNING_NUMBER_WHITE_SPACE_ERROR = "[ERROR] 번호에 공백이 포함되지 않아야 합니다.";
    public static final String WINNING_NUMBER_INVALID_ERROR = "[ERROR] 번호는 숫자여야 합니다.";
    public static final String BONUS_NUMBER_INVALID_ERROR = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";

    public static void checkDivisibleBy1000(int moneyInput) {
        if (moneyInput % 1000 != 0) {
            throw new IllegalArgumentException(MONEY_1000_UNIT_ERROR);
        }
    }

    public static void checkWinningNumbers(List<Integer> winningLottoNumbers) {
        if (winningLottoNumbers.size() != WINNING_NUMBER_SIZE) {
            throw new IllegalArgumentException(WINNING_NUMBER_SIZE_ERROR);
        }

        HashSet<Integer> set = new HashSet<>(winningLottoNumbers);
        if (set.size() != winningLottoNumbers.size()) {
            throw new IllegalArgumentException(WINNING_NUMBER_DUPLICATE_ERROR);
        }

        for (int number : winningLottoNumbers) {
            if (number < MIN_INPUT_NUMBER || number > MAX_INPUT_NUMBER) {
                throw new IllegalArgumentException(INPUT_NUMBER_RANGE_ERROR);
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

    public static void checkBounsNumber(int bonusNumber, int specifiedSize, List<Integer> winningLottoNumbers) {
        if (winningLottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        if (bonusNumber < MIN_INPUT_NUMBER || bonusNumber > MAX_INPUT_NUMBER) {
            throw new IllegalArgumentException(INPUT_NUMBER_RANGE_ERROR);
        }
    }
}
