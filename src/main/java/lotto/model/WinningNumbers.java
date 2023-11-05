package lotto.model;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers){
        /**
         * 초기 검증 (중복 체크, 갯수 체크, 수 범위 체크)
         * */
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
