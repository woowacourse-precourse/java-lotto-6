package lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.LottoValidator.*;

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
        validateLotteryLength(numbers);
        for (Integer number : numbers) {
            validateNumberInRange(number);
        }
        validateUniqueNumber(numbers);
    }

    public int getBonus() {
        return this.bonus;
    }

    public void setBonus(Integer bonus) {
        validateBonus(bonus);
        this.bonus = bonus;
    }

    private void validateBonus(Integer bonus) {
        validateNumberInRange(bonus);
        ArrayList<Integer> numbers = new ArrayList<>(this.numbers);
        numbers.add(bonus);
        validateUniqueNumber(numbers);
    }
}
