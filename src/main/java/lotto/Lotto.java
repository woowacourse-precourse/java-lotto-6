package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자가 아닙니다.");
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplicatedNumber(List<Integer> numbers){
        List<Integer> tmp = new ArrayList<>();
        for (int num : numbers){
            if (!tmp.contains(num)){
                tmp.add(num);
            }
        }

        if (tmp.size() != 6){
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다.");
        }
    }
}
