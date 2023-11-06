package lotto.domain.lotto;

public class BonusNumber {

    private int number;

    public BonusNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이여야합니다.");
        }
    }

    public int getNumber() {
        return number;
    }

    public boolean hasSameNumber(int number) {
        return this.number == number;
    }
}
