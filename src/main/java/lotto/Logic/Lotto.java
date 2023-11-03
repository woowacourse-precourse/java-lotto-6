package lotto.Logic;

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
    public List<Integer> getNumbers(){
        return this.numbers;
    }
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("[");
        for (int i = 0; i < numbers.size(); i++) {
            output.append(numbers.get(i));

            if (i != numbers.size() - 1)
                output.append(", ");

        }
        output.append("]");

        return output.toString();
    }
}
