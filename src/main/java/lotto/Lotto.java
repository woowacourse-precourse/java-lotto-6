package lotto;

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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 적어주세요.");
        }

        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 1부터 45까지의 숫자중에서 적어주세요.");
            }
        }

        Set<Integer> numberSet = new HashSet<>();
        for (int number : numbers) {
            if (!numberSet.add(number) == true) {
                throw new IllegalArgumentException("[ERROR] 중복되지않는 6개의 숫자를 적어주세요.");
            }

        }
    }

    // TODO: 추가 기능 구현
    static void validateAmount(String inputPurchaseAmount) {
        if (!inputPurchaseAmount.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자로만 입력하셔야 합니다.");
        }
    }

}
