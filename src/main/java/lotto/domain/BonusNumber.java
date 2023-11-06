package lotto.domain;

public class BonusNumber {
    private int number;

    public BonusNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        isInRange(number);
    }

    private void isInRange(int number) {
        if (number < Lotto.MIN_VALUE || number > Lotto.MAX_VALUE) {
            throw new IllegalArgumentException("보너스 번호는 1과 45사이의 수여야 합니다.");
        }
    }

    public int getNumber() {
        return number;
    }
}
