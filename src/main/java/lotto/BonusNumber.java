package lotto;

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
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 ~ 45 사이의 수여야 합니다.");
        }
    }

    public int getBonusNumber() {
        return this.number;
    }
}
