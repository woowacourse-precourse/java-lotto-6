package lotto;

import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    int prize;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        //set 자료구조에 복사해서 중복된 값이 있는지 확인
        Set<Integer> UniqueNumbers = new HashSet<>(numbers);
        if (UniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public void checkPrize(List<Integer> numbers, int bonusNumber) {

    }

}
