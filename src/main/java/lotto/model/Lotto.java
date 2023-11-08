package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        sort();
    }

    public Lotto(String[] winningNumber) {
        numbers = new ArrayList<>();
        for (String num : winningNumber) {
            numbers.add(parstInt(num));
        }
        System.out.println("당첨번호" + numbers);
        validate(numbers);
        sort();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void sort() {
        numbers.stream().sorted(Comparator.reverseOrder())
                .collect(Collectors.toList()); // 내림차순 정렬
    }

    public int parstInt(String num) {
        return Integer.parseInt(num);

    }
}
