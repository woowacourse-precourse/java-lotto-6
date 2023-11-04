package lotto.domain;

public class BonusLotto {
    private final int number;

    public BonusLotto(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        checkNumberInRange(number);
    }

    private void checkNumberInRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 1 ~ 45 사이의 숫자를 입력해 주세요.");
        }
    }
}
