package lotto.entity;

import java.util.List;

public class Bonus {
    private final int number;

    public Bonus(int number) {
        validate(number);
        this.number = number;
    }

    void validate(int number) {
        if (!(Lotto.isBetweenTwoNumbers(List.of(number), Lotto.START_NUMBER, Lotto.END_NUMBER))) {
            throw new IllegalArgumentException("보너스 번호는 1부터 45까지의 정수값 중 하나입니다.");
        }
    }

    int getNumber() {
        return number;
    }
}
