package lotto;

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
            throw new IllegalArgumentException();
        }

        HashSet<Integer> distinctNumbers = new HashSet<>();
        for (Integer number : numbers) {
            if (distinctNumbers.add(number)) {
                continue;
            }
            throw new IllegalArgumentException();
        }

        if (numbers.stream().anyMatch(number -> number < 1)) {
            throw new IllegalArgumentException();
        }

        if (numbers.stream().anyMatch(number -> number > 45)) {
            throw new IllegalArgumentException();
        }
    }
}
/*
제공된 Lotto 클래스를 활용해 구현해야 한다.
numbers의 접근 제어자인 private을 변경할 수 없다.
Lotto에 필드(인스턴스 변수)를 추가할 수 없다.
Lotto의 패키지 변경은 가능하다.
 */
