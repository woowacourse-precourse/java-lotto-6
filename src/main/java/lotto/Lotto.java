package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplication(numbers);
        validateNumberRange(numbers);

        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개만 입력해주세요.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> check = new HashSet<>();

        for (int num : numbers) {
            if (check.contains(num)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호가 중복되었습니다.");
            }
            check.add(num);
        }

    }

    private void validateNumberRange(List<Integer> numbers) {
        for (int num : numbers) {
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }

    }

    public static boolean validateBonusNum(int bonusNum, List<Integer> numbers) {
        boolean result = false;
        if (numbers.contains(bonusNum)) {
            result = true;
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 보너스 번호는 당첨번호와 중복되면 안됩니다.");
            }
        }
        return result;
    }


}
