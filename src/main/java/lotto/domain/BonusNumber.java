package lotto.domain;

public class BonusNumber {
    private final Integer number;

    public BonusNumber(Integer number) {
        validate(number);
        this.number = number;
    }

    private void validate(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45까지의 숫자여야 합니다.");
        }
    }

    public Integer getNumber() {
        return number;
    }
}
