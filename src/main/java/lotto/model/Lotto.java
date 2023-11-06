package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.model.Lottos.MIN_SCORE;
import static lotto.model.Lottos.NONE_SCORE;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public int calculateScore(Lotto answer) {
        int count = (int) answer.getNumbers().stream()
                .filter(numbers::contains)
                .count();
        if (count >= MIN_SCORE) {
            return count;
        }
        return NONE_SCORE;
    }

    public boolean hasBonus(int bonus) {
        return this.numbers.contains(bonus);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6 개여야 합니다.");
        }
        if (numbers.stream().anyMatch(number -> number > 45 || number < 1)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 로또 번호는 입력할 수 없습니다.");
        }
    }
}
