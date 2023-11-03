package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final List<Number> numbers;
    private final Number bonus;

    public WinningLotto(List<Number> numbers, Number bonus) {
        this.validateNumbers(numbers);
        this.validateDuplicate(numbers, bonus);
        this.numbers = numbers;
        this.bonus = bonus;
    }

    private void validateNumbers(List<Number> numbers) {
        if (numbers.size() != 5) {
            throw new IllegalArgumentException("당첨 번호는 5개여야 함");
        }

        for (int i = 0; i < numbers.size(); i++) {
            for (int j = numbers.size()-1; j > i; j--) {
                if (numbers.get(i) == numbers.get(j)) {
                    throw new IllegalArgumentException("번호는 중복될 수 없음.");
                }
            }
        }
    }

    private void validateDuplicate(List<Number> numbers, Number bonus) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException("보너스 번호는 중복될 수 없음");
        }
    }

    @Override
    public String toString() {
        return "WinningLotto{" +
                "numbers=" + numbers +
                ", bonus=" + bonus +
                '}';
    }
}
