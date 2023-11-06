package lotto.Model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        //Collections.sort(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        //this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers +"";
    }
    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateNumberRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 6개 입력해 주세요.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicate = new HashSet<>(numbers);

        if (nonDuplicate.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될수 없습니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (1 > number || 45 < number) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45의 숫자만 가능합니다.");
            }
        }
    }
}
