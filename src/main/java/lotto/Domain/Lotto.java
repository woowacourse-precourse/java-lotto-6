package lotto.Domain;

import java.util.List;
import lotto.Constant.Constant;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            String errorMessage = Constant.ERROR_PREFIX + "6개의 번호를 입력하지 않으셨습니다.";
            throw new IllegalArgumentException(errorMessage);
        }
    }

    // TODO: 추가 기능 구현
}
