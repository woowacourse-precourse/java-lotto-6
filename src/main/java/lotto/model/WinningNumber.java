package lotto.model;

import static lotto.util.Validate.validateDuplication;
import static lotto.util.Validate.validateRange;
import static lotto.util.Validate.validateSize;

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
