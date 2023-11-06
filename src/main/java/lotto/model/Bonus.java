package lotto.model;

import java.util.List;

public class Bonus {

    private final int number;

    public Bonus(String number, List<Integer> answerLotto) {
        validate(number, answerLotto);
        this.number = Integer.parseInt(number);
    }

    public int getNumber() {
        return this.number;
    }

    private void validate(String number, List<Integer> answerLotto) {
        if (!number.matches("\\d+")) {
            throw new IllegalArgumentException("보너스 번호는 숫자만 입력해주세요.");
        }
        if (Integer.parseInt(number) > 45 || Integer.parseInt(number) < 1) {
            throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (answerLotto.contains(number)) {
            throw new IllegalArgumentException("보너스 숫자는 로또 번호와 중복될 수 없습니다.");
        }
    }
}
