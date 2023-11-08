package validator;

import java.util.List;

public class InputValidator {

    public static void validatePurchasePrice(String price) {
        if (!price.matches("\\d+")) {
            throw new NumberFormatException("[ERROR] 숫자만 입력 가능합니다.");
        }
        if (Integer.parseInt(price) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원으로 나누어 떨어져야 합니다.");
        }
    }

    public static void validateWinningNumber(String[] winningNumber) {
        for (String number : winningNumber) {
            if (!number.matches("\\d+")) {
                throw new NumberFormatException("[ERROR] 숫자만 입력 가능합니다.");
            }
        }
    }

    public static void validateBonus(String bonus, List<Integer> winningNumbers) {
        if (!bonus.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }

        if (Integer.parseInt(bonus) < 1 || Integer.parseInt(bonus) > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        if (winningNumbers.contains(Integer.parseInt(bonus))) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복되는 숫자입니다.");
        }
    }

}
