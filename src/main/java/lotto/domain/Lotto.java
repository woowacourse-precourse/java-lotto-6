package lotto.domain;


import java.util.List;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countContainNumbers(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::containNumber)
                .count();
    }

    private boolean containNumber(Integer number) {
        return numbers.contains(number);
    }


    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }


}
