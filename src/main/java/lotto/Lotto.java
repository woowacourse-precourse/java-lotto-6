package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또는 6개의 숫자여야 합니다.");
        }

        List<Integer> uniqueNumbers = new ArrayList<>();
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");

            }

            if (uniqueNumbers.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 중복되는 숫자가 있습니다.");

            }
            uniqueNumbers.add(number);
        }
    }

    public List<Integer> getLotto() {
        numbers.sort(null);
        return numbers;
    }

}
