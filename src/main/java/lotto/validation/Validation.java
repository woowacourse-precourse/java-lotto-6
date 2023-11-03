package lotto.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    public void validateUnit(int payment) {
        if(payment % 1000 != 0) {
            System.out.println("[ERROR] 입력값이 1,000원 단위가 아닙니다.");
            throw new IllegalArgumentException("[ERROR] 입력값이 1,000원 단위가 아닙니다.");
        }
    }

    public void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 입력된 숫자가 6개가 아닙니다.");
            throw new IllegalArgumentException("[ERROR] 입력된 숫자가 6개가 아닙니다.");
        }
    }

    public void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if(number < 1 || 45 < number) {
                System.out.println("[ERROR] 숫자 범위는 1 이상 45 이하여야 합니다.");
                throw new IllegalArgumentException("[ERROR] 숫자 범위는 1 이상 45 이하여야 합니다.");
            }
        }
    }

    public void validateDuplication(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if(numbers.size() != uniqueNumbers.size()) {
            System.out.println("[ERROR] 중복된 숫자가 있습니다.");
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }
}