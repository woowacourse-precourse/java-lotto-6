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
//    public int draw(Lotto winning, Integer bonus) {
//        long count = winning.numbers.stream()
//                .filter(number -> numbers.contains(number))
//                .count();
//        boolean contains = numbers.contains(bonus);
//
//    }
}
