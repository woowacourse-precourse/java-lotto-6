package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.constant.Value;
import lotto.util.Validator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // ------- 기존 것 건들지 않고 아래에 추가 작성 --------

    public static Lotto from(List<Integer> numbers) {
        checkFormat(numbers);
        return new Lotto(numbers);
    }

    public List<Integer> getNumbers() {
        List<Integer> copied = new ArrayList<>(numbers);
        Collections.sort(copied);
        return copied;
    }

    public static Lotto copy(Lotto lotto) {
        return new Lotto(lotto.getNumbers());
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public static List<Integer> checkFormat(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != Value.LOTTO_NUMBER_COUNT.get()) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_COUNT_OF_LOTTO.get());
        }
        Validator.checkDuplicated(numbers);
        numbers.forEach(Lotto::checkRange);
        return numbers;
    }

    public static int checkRange(int number) throws IllegalArgumentException {
        if (number < Value.START_NUMBER.get() || number > Value.END_NUMBER.get()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_RANGE.get());
        }
        return number;
    }
}