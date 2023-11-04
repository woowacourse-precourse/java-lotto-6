package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static final int LottoSize = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoSize) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_NUMBER_SIZE);
        }
    }

    private void duplicate(List<Integer> numbers) {
        boolean isPresent = numbers.stream()
                .distinct()
                .count() == numbers.size();

        if(!isPresent) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_NUMBER_DUPLICATE);
        }
    }

    public List<Integer> lottoNumber() {
        return numbers;
    }

}
