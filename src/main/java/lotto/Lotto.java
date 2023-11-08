package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.bytebuddy.description.field.FieldDescription.InGenericShape;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private boolean hasDuplicate(List<Integer> numbers) {
        Set<Integer> duplicateCheck = new HashSet<>();
        for (int index = 0; index < numbers.size(); index++) {
            int number = numbers.get(index);
            if (!duplicateCheck.add(number)) {
                return false;
            }
        }
        return true;
    }

    private boolean rangeBetween1To45(List<Integer> numbers) {
        for (int index = 0; index < numbers.size(); index++) {
            int number = numbers.get(index);
            if (number <= 0 || number > 45) {
                return false;
            }
        }
        return true;
    }

    private void validate(List<Integer> numbers) {

        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 6개이어야 합니다.");
        }

        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 중복되지 않는 숫자들로 구성되어있어야 합니다.");
        }

        if (!rangeBetween1To45(numbers)) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 1이상 45이하인 숫자들로 구성되어있어야 합니다.");
        }
    }
}
