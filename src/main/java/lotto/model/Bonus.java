package lotto.model;

import java.util.List;

public class Bonus {

    private final int number;

    public Bonus(int number) {
        validate(number);
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    private void validate(int number) {
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호의 숫자 범위는 1~45까지입니다.");
        }
    }
}
