package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 수를 입력하면 안됩니다.");
        }

    }
    private void validateRange(List<Integer> numbers) {
        for (Integer now : numbers) {
            if (now < 1 || now > 45) {
                throw new IllegalArgumentException("수의 범위는 1 ~ 45 입니다.");
            }
        }
    }

    public boolean find(Integer number) {
        if (numbers.contains(number)) {
            return true;
        }
        return false;
    }

    public void print() {
        String message = numbers.stream().map(String::valueOf)
                .collect(Collectors.joining(","));
        System.out.println("["+message+"]");

    }

    public int getLottoSize() {
        return this.numbers.size();
    }

    public int get(int index) {
        return this.numbers.get(index);
    }



}
