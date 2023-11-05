package lotto.model;

public class BonusNumber {

    private static final int MIN_WINNING_NUMBER = 1;
    private static final int MAX_WINNING_NUMBER = 45;

    private final int bonusNumber;

    public BonusNumber(String bonusNumInput) {
        validateBonusNumber(bonusNumInput);
        this.bonusNumber = Integer.parseInt(bonusNumInput);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateBonusNumber(String bonusNumInput) {
        int number = Integer.parseInt(bonusNumInput);
        if (number < MIN_WINNING_NUMBER || number > MAX_WINNING_NUMBER) {
            throw new IllegalArgumentException("보너스 번호는 " + MIN_WINNING_NUMBER + "부터 "
                    + MAX_WINNING_NUMBER + "까지의 숫자만 가능합니다.");
        }
    }
}
