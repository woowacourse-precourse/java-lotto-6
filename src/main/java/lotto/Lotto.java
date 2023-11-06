package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않아야 합니다.");
        }
        if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이여야 합니다.");
        }
    }
    public ArrayList<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}