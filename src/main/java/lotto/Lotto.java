package lotto;

import java.util.List;
import lotto.EnumList.ConstantErrorMessage;
import lotto.EnumList.ConstantLotto;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != ConstantLotto.LOTTO_SIZE.value()) {
            throw new IllegalArgumentException(ConstantErrorMessage.ERROR_LOTTO_NUMBER_SIZE.errorMessage());
        }
    }

    private void duplicate(List<Integer> numbers) {
        boolean isPresent = numbers.stream()
                .distinct()
                .count() == numbers.size();

        if (!isPresent) {
            throw new IllegalArgumentException(ConstantErrorMessage.ERROR_LOTTO_NUMBER_DUPLICATE.errorMessage());
        }
    }

    public List<Integer> lottoNumber() {
        return numbers;
    }

}
