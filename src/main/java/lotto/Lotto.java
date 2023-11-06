package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
   // private int bonusNumber;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateCheck(numbers);
        this.numbers = numbers;
       // this.bonusNumber = bonusNumber;
    
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 입력된 숫자가 6개가 아닙니다!.");
        }
    }

    private void duplicateCheck(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);

        if (set.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }
}
