package lotto.domain;

public class BonusNumber {
    private final Integer bonusNumber;

    public BonusNumber(Integer number) {
        validate(number);
        this.bonusNumber = number;
    }

    private void validate(Integer number) {
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException();
        }
    }

    public Integer getBonusNumber() {
        return this.bonusNumber;
    }
}
