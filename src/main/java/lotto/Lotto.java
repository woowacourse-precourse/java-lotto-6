package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicated(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void validate(List<Integer> numbers) {

        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6자리 숫자여야 합니다.");
        }
    }

    private void checkDuplicated(List<Integer> numbers) {
        Map<Integer, Integer> checkTable = new HashMap<>();
        for (Integer element : numbers) {
            if (checkTable.containsKey(element)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 서로 다른 숫자여야 합니다.");
            }
            checkTable.put(element, 1);
        }
    }

}
