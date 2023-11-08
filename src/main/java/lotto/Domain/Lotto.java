package lotto.Domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> duplicateCheck = new HashSet<>();
        for (int i = 0; i < numbers.size(); i++) {
            duplicateCheck.add(numbers.get(i));
        }

        if (duplicateCheck.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    public static void validateRange(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 1 || numbers.get(i) > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }

        }
    }


    public static void validateBonus(List<Integer> numbers, int bonus) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 중복되었습니다.");
        }
    }



    public List<Integer> getNumbers() {
        return numbers;
    }


}
