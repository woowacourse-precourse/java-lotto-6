package validator;

import java.util.List;

public class Validator {
    private static final int LOTTO_PRICE = 1_000;
    private static final int REMAINDER_ZERO = 0;
    private static final int WINNING_NUMBERS_COUNT = 6;
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final String ONLY_NUMBER_REGEX = "^[0-9]*$";

    public static void validatePurchaseAmount(int spend) {
        if (spend % LOTTO_PRICE != REMAINDER_ZERO) {
            throw new IllegalArgumentException("1,000원 단위로 입력해 주세요.");
        }
    }

    public static void validateInputIsNumeric(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException("숫자만 입력해 주세요.");
        }
    }

    public static void validateSeparatedByComma(String winningNumbers) {
        if (!hasComma(winningNumbers)) {
            throw new IllegalArgumentException("당첨 번호 6개를 콤마(,)로 구분해 주세요.");
        }
        String[] separatedWinningNumbers = winningNumbers.split(",");
        for (String winningNumber : separatedWinningNumbers) {
            if (!isNumeric(winningNumber)) {
                throw new IllegalArgumentException("당첨 번호 6개를 콤마(,)로 구분해 주세요.");
            }
        }
    }

    public static boolean hasComma(String winningNumbers) {
        return winningNumbers.contains(",");
    }

    public static boolean isNumeric(String input) {
        return input.matches(ONLY_NUMBER_REGEX);
    }

    public static void validateWinningNumberCount(List<Integer> winningNumbers) {
        if (winningNumbers.size() != WINNING_NUMBERS_COUNT) {
            throw new IllegalArgumentException("당첨 번호 6개를 입력해 주세요.");
        }
    }

    public static void validateWinningNumbersInRange(List<Integer> winningNumbers) {
        for (int winningNumber : winningNumbers) {
            if (isLottoNumberOutOfBounds(winningNumber)) {
                throw new IllegalArgumentException("당첨 번호는 1 이상, 45 이하로 입력해 주세요.");
            }
        }
    }

    public static boolean isLottoNumberOutOfBounds(int lottoNumber) {
        return lottoNumber < START_INCLUSIVE || lottoNumber > END_INCLUSIVE;
    }

    public static void validateWinningNumbersIsNumeric(String[] winningNumbers) {
        for (String winningNumber : winningNumbers) {
            validateInputIsNumeric(winningNumber);
        }
    }

    public static void validateBonusNumberInRange(int bonusNumber) {
        if (isLottoNumberOutOfBounds(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 1 이상, 45 이하로 입력해 주세요. ");
        }
    }
}
