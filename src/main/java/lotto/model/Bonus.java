package lotto.model;

import java.util.List;

public class Bonus {

    private final int number;

    public Bonus(int number, List<Integer> answerLotto) {
        validate(number, answerLotto);
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    private void validate(int number, List<Integer> answerLotto) {
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (answerLotto.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 로또 번호와 중복될 수 없습니다.");
        }
    }
}
