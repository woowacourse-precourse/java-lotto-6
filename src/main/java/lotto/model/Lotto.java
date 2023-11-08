package lotto.model;

import java.util.List;
import lotto.constant.Number;
import lotto.constant.ValidatorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateIsNull(numbers);
        validateSize(numbers);
        validateDuplicate(numbers);
        validateNumberRange(numbers);
    }

    // TODO: 추가 기능 구현
    public boolean contains(int number) {

    }

    public static List<Integer> createLotto() {

    }

    public Rank getRank(Lotto winNumbers, Bonus bonus) {

    }

    public String getLottoNumber(){

    }

    private int getCorrectCount(Lotto winNumbers) {

    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ValidatorMessage.INVALID_LOTTO_SIZE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ValidatorMessage.INVALID_LOTTO_DUPLICATE);
        }
    }

    private void validateIsNull(List<Integer> numbers) {
        if (numbers == null || numbers.size() == 0) {
            throw new IllegalArgumentException(ValidatorMessage.INVALID_IS_NULL);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (!numbers.stream()
                .allMatch(element -> element >= Number.MIN_NUMBER && element <= Number.MAX_NUMBER)
        ) {
            throw new IllegalArgumentException(ValidatorMessage.INVALID_LOTTO_RANGE);
        }
    }
}
