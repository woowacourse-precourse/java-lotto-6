package lotto.model;

import static lotto.util.validator.Constant.LOTTO_LENGTH;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
    public boolean contains(int number) {
        return numbers.contains(number);
    }
    @Override
    public String toString(){
        return numbers.toString();
    }
}
