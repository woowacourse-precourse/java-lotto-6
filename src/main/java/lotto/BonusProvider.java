package lotto;

import java.util.List;

public class BonusProvider {
    private final int BONUS_START_NUMBER = 1;
    private final int BONUS_END_NUMBER = 45;

    public int getBonus(List<Integer> winningNumber, String bonusInput) {
        validateInteger(bonusInput);
        int bonus = Integer.parseInt(bonusInput);
        validateRange(bonus);
        validateDuplication(winningNumber, bonus);

        return bonus;
    }

    private void validateDuplication(List<Integer> winningNumber, int bonus) {
        if (winningNumber.contains(bonus)) {
            throw new IllegalArgumentException("error");
        }
    }

    private void validateInteger(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("error");
        }
    }

    private void validateRange(int input) {
        if (BONUS_START_NUMBER > input || input > BONUS_END_NUMBER) {
            throw new IllegalArgumentException("error");
        }
    }
}
