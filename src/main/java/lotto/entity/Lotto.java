package lotto.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    public static final int PRICE = 1000;
    public static final int NUMBERS_COUNTER = 6; // 로또 번호 최대 개수
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_COUNTER) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }

        if (!(isDuplicate(numbers))) {
            throw new IllegalArgumentException("중복이 존재합니다.");
        }

        if (!(isBetweenTwoNumbers(numbers, START_NUMBER, END_NUMBER))) {
            throw new IllegalArgumentException("로또 번호는 1부터 45까지의 정수여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    private boolean isDuplicate(List<Integer> numbers) {
        List<Integer> distinctNumbers = new ArrayList<>();

        for (Integer number : numbers) {
            if (!(distinctNumbers.contains(number))) {
                distinctNumbers.add(number);
            }
        }

        return distinctNumbers.size() == numbers.size();
    }

    static boolean isBetweenTwoNumbers(List<Integer> numbers, int start, int end) {
        for (Integer number : numbers) {
            if (!((start <= number) && (number <= end))) {
                return false;
            }
        }

        return true;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
