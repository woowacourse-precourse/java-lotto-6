package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class InputValidator {
    private static final String DIVISIBILITY_ERROR = "구입 금액은 " + Lotto.PRICE + "으로 나누어져야 합니다.";
    private static final String MINIMUM_AMOUNT_ERROR = "구입 금액은 " + Lotto.PRICE + " 이상이어야 합니다.";
    private static final String INVALID_INPUT_ERROR = "잘못된 입력입니다. 유효한 숫자를 입력해주세요.";
    private static final String BONUS_NUMBER_ERROR = "보너스 번호는 당첨 번호에 포함되지 않아야 합니다.";

    public static int validatePurchaseAmount(String input) {
        int purchaseAmount = InputValidator.isNumberFormat(input);
        InputValidator.greaterThanThousand(purchaseAmount);
        InputValidator.divisibleByThousand(purchaseAmount);
        return purchaseAmount;
    }

    public static int validateBonusNumber(String input, List<Integer> winningNumbers) {
        int bonusNumber = InputValidator.isNumberFormat(input);
        InputValidator.inRange(bonusNumber);
        InputValidator.notInWinningNumbers(winningNumbers, bonusNumber);
        return bonusNumber;
    }

    private static void divisibleByThousand(int purchaseAmount) {
        if (purchaseAmount % Lotto.PRICE != 0) {
            throw new IllegalArgumentException(DIVISIBILITY_ERROR);
        }
    }

    private static void greaterThanThousand(int purchaseAmount) {
        if (purchaseAmount < Lotto.PRICE) {
            throw new IllegalArgumentException(MINIMUM_AMOUNT_ERROR);
        }
    }

    private static void inRange(int number) {
        if (number < Lotto.LOTTO_MIN || number > Lotto.LOTTO_MAX) {
            throw new IllegalArgumentException(Lotto.OUT_OF_RANGE_ERROR);
        }
    }

    private static int isNumberFormat(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
    }

    private static void notInWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_ERROR);
        }
    }


}
