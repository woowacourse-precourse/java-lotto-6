package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) { //로또번호 받기
        validateIs1_45(numbers);
        validate(numbers);
        this.numbers = numbers;
        sort();
    }

    public Lotto(String[] winningNumber) {//당첨번호 받기
        numbers = new ArrayList<>();
        for (String num : winningNumber) {
            numbers.add(parstInt(num));
        }

//        System.out.println("당첨번호" + numbers);
        validate(numbers);
        validateIs1_45(numbers);
        validateWinningDuplicated(numbers);
        sort();
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    private void validateIs1_45(List<Integer> numbers) throws IllegalArgumentException {

        for (int num : numbers) {
            if (!((0 < num) && (num < 46))) {
                throw new IllegalArgumentException();
            }
        }

    }

    private void validateWinningDuplicated(List<Integer> numbers) throws IllegalArgumentException {
        HashSet<Integer> set = new HashSet<>(numbers);
        if ((numbers.size()) != (set.size())) {
            throw new IllegalArgumentException();
        }
    }

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
