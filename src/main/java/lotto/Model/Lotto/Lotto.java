package lotto.Model.Lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    /**
     * 랜덤수 를 통해 6자리 또로 1장 을 같고 있느 객체,
     *
     * @param numbers
     */

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }



    // TODO: 추가 기능 구현
}
