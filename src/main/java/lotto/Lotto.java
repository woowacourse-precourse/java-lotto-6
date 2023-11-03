package lotto;

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

    // TODO: 추가 기능 구현

    public boolean contains(int number) {
        return this.numbers.contains(number);
    }

    public String toString() {
        StringBuilder string = new StringBuilder("[");
        for (int index = 0; index < this.numbers.size(); index++) {
            string.append(numbers.get(index));
            if (index == this.numbers.size() - 1) {
                break;
            }
            string.append(", ");
        }
        string.append("]");

        return String.valueOf(string);
    }
}
