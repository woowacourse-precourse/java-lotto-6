package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lotto {
    public List<Integer> getNumbers() {
        return numbers;
    }

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateOverlap(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    private static boolean validateOverlap (List<Integer> numbers){
        Map<Integer, Integer> map = new HashMap<>();
        for (int c : numbers) {
            map.put(c, map.getOrDefault(c, 0) + 1); // 중복되면 +1, 중복된것이 없으면 0 -> +1 해서 1
            if ((map.get(c) > 1)) {
                throw new IllegalArgumentException("[ERROR] 중복된 값이 있습니다.");
            }
        }
        return false;
    }

    // TODO: 추가 기능 구현
}
