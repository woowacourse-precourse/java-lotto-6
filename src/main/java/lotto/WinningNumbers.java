package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningNumbers {

    private List<Integer> numbers;
    private int bonus;

    public WinningNumbers(String numbers) {
        validate(numbers);
        List<Integer> list = new ArrayList<>();
        String[] split = numbers.split(",");
        for (String s : split) {
            list.add(Integer.parseInt(s));
        }
        this.numbers = list;
    }

    private void validate(String numbers) {
        InputValidator.validateIsNotBlank(numbers);
        String[] split = numbers.split(",");
        InputValidator.validateStringArrayLength(split, 6);
        InputValidator.validateIsNumbers(split);
        for (String s : split) {
            InputValidator.validateNumberInRange(Integer.parseInt(s), 1, 45);
        }

        InputValidator.validateIsUnique(Arrays.asList(split));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
