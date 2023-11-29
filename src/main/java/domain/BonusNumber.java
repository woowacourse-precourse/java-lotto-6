package domain;

public class BonusNumber {
    private final int bonusNumber;

    private BonusNumber(final int number) {
        bonusNumber = number;
    }

    public static BonusNumber create(final int number){
        return new BonusNumber(number);
    }
}
