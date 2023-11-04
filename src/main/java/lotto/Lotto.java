package lotto;

import java.util.List;
import lotto.validate.Validate;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validate validate = new Validate();

        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        // 1 ~ 45 사이의 숫자인지 검증
        for(int number: numbers){
            validate.validateNumberInRange(number, 1, 45);
        }

        
    }

    // TODO: 추가 기능 구현
}
