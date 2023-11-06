package lotto.validation;

public class LottoValidation {
    private static final int STANDARD_UNIT = 1000;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;

    public static void validateIsNumber(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
    }

    public static void validateOverStandardUnit(int amount) {
        if (amount < STANDARD_UNIT) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 최소 1000원입니다.");
        }
    }

    public static void validateIsStandardUnit(int amount) {
        if (amount % STANDARD_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
    }

    public static void validateIsNumberBonus(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫쟈여야 합니다.");
        }
    }

    public static void validateInRange(int input) {
        if (input < START_NUMBER || input > END_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45사이의 숫자여야 합니다.");
        }
    }
}
