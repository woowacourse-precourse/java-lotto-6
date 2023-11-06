package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int SIX = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDistinct(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isNotRightCount(numbers)) {
            throw new IllegalArgumentException("여섯 개의 숫자가 생성되지 않았습니다.");
        }
    }
    private void validateDistinct(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (isNotDistinct(numbers,numberSet)) {
            throw new IllegalArgumentException("로또 번호에 중복된 숫자가 존재합니다.");
        }
    }

    private boolean isNotDistinct(List<Integer> numbers, Set<Integer> numberSet) {
        return numbers.size() != numberSet.size();
    }

    private static boolean isNotRightCount(List<Integer> numbers) {
        return numbers.size() != SIX;
    }

    private List<Integer> getLotto(){
        return this.numbers;
    }
    public List<Integer> lotto(){
        return getLotto();
    }
}
