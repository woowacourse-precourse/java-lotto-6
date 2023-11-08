package lotto.model.generator;

import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.constant.UnitNumber;
import lotto.model.player.WinningNumber;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateIsCount6(numbers);
        validateIsDistinct(numbers);
        this.numbers = numbers;
    }

    private static void validateIsCount6(List<Integer> numbers) {
        if (numbers.size() != UnitNumber.WINNING_COUNT.getNumber()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateIsDistinct(List<Integer> numbers) {
        if(numbers.stream().distinct().toList().size() != UnitNumber.WINNING_COUNT.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_WINNING.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
