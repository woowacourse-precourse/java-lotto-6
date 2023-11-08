package lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.Constants.*;
import static lotto.Validator.*;

public class WinningNumbers {

    private List<Integer> numbers;
    private Integer bonus;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        validateListLength(numbers, LOTTERY_DIGIT_LENGTH);
        validateNumberInRange(numbers, LOTTERY_MIN_NUMBER, LOTTERY_MAX_NUMBER);
        validateIsElementUnique(numbers);
    }

    public int getBonus() {
        return this.bonus;
    }

    public void setBonus(Integer bonus) {
        validateBonus(bonus);
        this.bonus = bonus;
    }

    private void validateBonus(Integer bonus) {
        validateNumberInRange(bonus, LOTTERY_MIN_NUMBER, LOTTERY_MAX_NUMBER);
        ArrayList<Integer> numbers = new ArrayList<>(this.numbers);
        numbers.add(bonus);
        validateIsElementUnique(numbers);
    }
}
