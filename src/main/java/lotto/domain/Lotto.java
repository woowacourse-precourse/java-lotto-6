package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.constant.LottoConst.IS_DUPLICATE;
import static lotto.constant.LottoConst.OVER_RANGE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(IS_DUPLICATE);
        }

    }

    private void validateRange(List<Integer> numbers) {
        for (Integer now : numbers) {
            if (now < 1 || now > 45) {
                throw new IllegalArgumentException(OVER_RANGE);
            }
        }
    }

    public boolean find(Integer number) {
        return numbers.contains(number);
    }

    public void print() {
        String message = numbers.stream().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println("[" + message + "]");

    }

    public int getLottoSize() {
        return this.numbers.size();
    }

    public int get(int index) {
        return this.numbers.get(index);
    }


}
