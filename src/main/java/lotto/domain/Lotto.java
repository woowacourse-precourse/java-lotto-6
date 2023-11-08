package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> overlapCheck = new HashSet<>(numbers);

        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자 갯수는 6개여야 합니다.");
        } else if (overlapCheck.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 없어야 합니다.");
        }

        for (int numberCheck : numbers){
            if (numberCheck > 45 || numberCheck < 1){
                throw new IllegalArgumentException("[ERROR] 숫자는 1부터 45까지만 입력해야 합니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
