package lotto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개 입니다.");
        }
        if (new HashSet<>(numbers).size() < 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    // TODO: 추가 기능 구현

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    public Grade draw(Lotto winning, Integer bonus) {
        int count = (int) winning.numbers.stream()
                .filter(number -> contains(number))
                .count();
        boolean contains = contains(bonus);

        return Grade.draw(count, contains);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
