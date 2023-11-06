package lotto;

import java.util.List;
public class Lotto {
    private static final int NUM_OF_LOTTO =6;
    private static final String NUMBER_SIZE_ERROR = "[ERROR] 당첨 번호는 "+NUM_OF_LOTTO+"개 입력 가능합니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUM_OF_LOTTO) {
            throw new IllegalArgumentException(NUMBER_SIZE_ERROR);
        }
    }

    // TODO: 추가 기능 구현

}
