package lotto.model;

import static lotto.util.Validation.validateDuplication;
import static lotto.util.Validation.validateRange;
import static lotto.util.Validation.validateSize;

import java.util.List;

public class WinningNumber {

    private final List<Integer> winning;

    public WinningNumber(List<Integer> winning) {
        validate(winning);
        this.winning = winning;
    }

    public List<Integer> getWinning() {
        return winning;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        validateRange(numbers);
    }
}
