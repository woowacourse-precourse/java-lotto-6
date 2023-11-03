package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//당첨 번호 관리
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 당첨 번호를 입력하였습니다.");
        }
    }


}
