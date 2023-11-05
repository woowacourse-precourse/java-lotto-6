package lotto.domain;

public class BonusNumber {

    private static final String OUT_OF_RANGE_ERROR_MESSAGE = "1 ~ 45사이의 숫자만 입력할 수 있습니다.";
    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public boolean hasBonus(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
