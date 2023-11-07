package lotto;

import java.util.List;

public class WinningLotto {
    private final List<Integer> numbers;
    private final int bonus;

    private WinningLotto(List<Integer> numbers, int bonus) {
        this.numbers = numbers;
        this.bonus = bonus;
    }

    public WinningLotto of(List<Integer> numbers, int bonus) {
        validate(numbers);
        validateBonus(numbers, bonus);

        return new WinningLotto(numbers, bonus);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException();
        }
        if (numbers.stream().anyMatch(number -> number<1 || number>45)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateBonus(List<Integer> numbers, int bonus) {
        if (bonus<1||bonus>45) throw new IllegalArgumentException();
        if (numbers.contains(bonus)) throw new IllegalArgumentException();
    }

    public List<Integer> getNumbers() {
        return numbers.stream().sorted().toList();
    }

    public int getBonus() {
        return bonus;
    }
}