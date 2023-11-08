package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.LottoValidator.validateNumberInRange;

public class WinningNumbers {

    private final List<Integer> numbers;
    private final int bonus;

    public WinningNumbers(String numbers, String bonus) {
        validateNumbers(numbers);
        validateBonus(bonus);
        List<Integer> list = new ArrayList<>();
        String[] split = numbers.split(",");
        for (String s : split) {
            list.add(Integer.parseInt(s));
        }
        this.numbers = list;

        List<Integer> results = new ArrayList<>(list);
        results.add(Integer.parseInt(bonus));

        Set<Integer> set = new HashSet<>(results);
        if (set.size() < results.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }

        this.bonus = Integer.parseInt(bonus);
    }

    private void validateNumbers(String numbers) {
        InputValidator.validateIsNotBlank(numbers);
        String[] split = numbers.split(",");
        InputValidator.validateIsNumbers(split);
        for (String s : split) {
            validateNumberInRange(Integer.parseInt(s));
        }
    }

    private void validateBonus(String bonus) {
        InputValidator.validateIsNotBlank(bonus);
        InputValidator.validateIsNumbers(bonus);
        validateNumberInRange(Integer.parseInt(bonus));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonus() {
        return bonus;
    }
}
