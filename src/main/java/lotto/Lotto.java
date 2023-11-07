package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLengthIsSix(numbers);
        validateNoDuplicates(numbers);
        this.numbers = numbers;
    }

    private void validateLengthIsSix(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또는 여섯개의 숫자로 구성되어야 합니다.");
        }
    }

    private void validateNoDuplicates(List<Integer> list) {
        long distinctNumberCount = list.stream()
                .distinct()
                .count();
        if(distinctNumberCount != list.size()){
            throw new IllegalArgumentException("[ERROR] 로또에는 중복되는 숫자가 있을 수 없습니다.");
        }
    }
}
