package lotto;

public class BonusBall {
    private final Integer bonusBall;

    public BonusBall(int number, Lotto lotto) {
        validate(number, lotto);
        this.bonusBall = number;
    }

    public void validate(int number, Lotto lotto) {
        ValidateBonusBall.isInRange(number);
        ValidateBonusBall.isDuplicate(number, lotto);
    }
}
