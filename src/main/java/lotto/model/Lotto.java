package lotto.model;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        Collections.sort(numbers);
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6 개여야 합니다.");
        }
        if (numbers.stream().anyMatch(number -> number > 45 || number < 1)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호의 숫자 범위는 1~45까지입니다.");
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 중복된 로또 번호는 입력할 수 없습니다.");
        }
    }

    // TODO: 추가 기능 구현
}
