package lotto;

public class LottoBonus {
    private final int bonusNumber;

    public LottoBonus(int bonusNumber) {
        isNumberInRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void isNumberInRange(int bonusNumber) {
        if (bonusNumber < Config.MIN_LOTTO_NUMBER || bonusNumber > Config.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_OUT_OF_RANGE_LOTT_NUMBER.getMessage());
        }
    }
}
