package lotto.validation;

import java.util.List;

public class InputValidation {

    public static void validatePurchaseAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR]구매 금액은 0보다 커야 합니다.");
        }
    }

    public static void validatePurchaseThousand(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR]구매 금액은 1000원 단위여야 합니다.");
        }
    }

    public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validateNumberRange(bonusNumber);
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR]보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }

    private static void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR]번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
