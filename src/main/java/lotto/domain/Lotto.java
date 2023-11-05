package lotto.domain;

import java.util.List;

public class Lotto {
    private static final int SIX = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isNotRightCount(numbers)) {
            throw new IllegalArgumentException("여섯 개의 숫자가 생성되지 않았습니다.");
        }
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
