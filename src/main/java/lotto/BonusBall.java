package lotto;

public class BonusBall {
    private final Integer bonusBall;

    public BonusBall(int number) {
        validate(number);
        this.bonusBall = number;
    }

    public void validate(int number) {
        ValidateBonusBall.isInRange(number);
    }
}
