package lotto.DidIt;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
       // ascendingOrder(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    private void validateDuplicate(List<Integer> numbers) {
        for (int i=0; i<numbers.size(); i++) {
            verifyDuplicate(numbers, i);
        }
    }

    private static void verifyDuplicate(List<Integer> numbers, int i) {
        for (int j = i+1; j< numbers.size(); j++) {
            if (numbers.get(i) == numbers.get(j)) {
                throw new IllegalArgumentException("[ERROR] 중복 존재");
            }
        }
    }

    //로또번호 오름차순 정렬
    public void ascendingOrder (List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
