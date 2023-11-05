package lotto;

import java.util.List;

public class Bonus {
    private final int number;

    public Bonus(int number, List<Integer> numbers) {
        validate(number, numbers);
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    private void validate(int number, List<Integer> numbers) {
        validateAllRange(number);
        validateNoDuplicates(number, numbers);
    }
}
